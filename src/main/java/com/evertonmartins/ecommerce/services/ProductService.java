package com.evertonmartins.ecommerce.services;

import com.evertonmartins.ecommerce.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Page<ProductDTO> findAll(String name, Pageable pageable);
    ProductDTO findById(Long id);
    ProductDTO insert(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    void delete(Long id);

}
