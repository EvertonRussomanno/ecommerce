package com.evertonmartins.ecommerce.services;

import com.evertonmartins.ecommerce.dto.OrderDTO;

public interface OrderService {

    OrderDTO findById(Long id);
}
