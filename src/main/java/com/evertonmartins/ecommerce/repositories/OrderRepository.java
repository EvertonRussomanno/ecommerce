package com.evertonmartins.ecommerce.repositories;

import com.evertonmartins.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
