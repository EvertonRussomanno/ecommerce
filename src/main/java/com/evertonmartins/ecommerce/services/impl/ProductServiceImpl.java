package com.evertonmartins.ecommerce.services.impl;

import com.evertonmartins.ecommerce.dto.ProductDTO;
import com.evertonmartins.ecommerce.entities.Product;
import com.evertonmartins.ecommerce.repositories.ProductRepository;
import com.evertonmartins.ecommerce.services.ProductService;
import com.evertonmartins.ecommerce.services.exceptions.DatabaseException;
import com.evertonmartins.ecommerce.services.exceptions.ResourceNotFoudException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @Override
//    @Transactional(readOnly = true)
//    public Page<ProductDTO> findAll(String name, Pageable pageable) {
//        Page<Product> list = productRepository.findAll(pageable);
//        return list.map(x -> new ProductDTO(x));

//    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String name, Pageable pageable) {
        Page<Product> list = productRepository.searchByName(name, pageable);
        return list.map(x -> new ProductDTO(x));
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoudException("Resource not found!"));
        return new ProductDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = new Product();
        copyDtoToEntity(productDTO, entity);
        productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        try {
            Product entity = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, entity);
            productRepository.save(entity);
            return new ProductDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoudException("Resouce not found!");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoudException("Resource not found!");
        }
        try {
            productRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity database fail!");
        }

    }

    private void copyDtoToEntity(ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
        entity.setImgUrl(productDTO.getImgUrl());
    }
}
