package com.encore.order.Ordering.service;

import com.encore.order.Ordering.repository.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderingService {
    private final OrderingRepository orderingRepository;
    @Autowired
    public OrderingService(OrderingRepository orderingRepository) {
        this.orderingRepository = orderingRepository;
    }
}