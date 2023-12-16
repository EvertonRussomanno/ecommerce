package com.evertonmartins.ecommerce.services.impl;


import com.evertonmartins.ecommerce.dto.OrderDTO;
import com.evertonmartins.ecommerce.entities.Order;
import com.evertonmartins.ecommerce.repositories.OrderRepository;
import com.evertonmartins.ecommerce.services.OrderService;
import com.evertonmartins.ecommerce.services.exceptions.ResourceNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoudException("Resource not found!"));
        return new OrderDTO(order);
    }
}
