package com.leonardo.desafio.services;

import com.leonardo.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ShippingService shippingService;

    @Autowired
    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double calculateTotalValue(Order order) {
        double discount = order.getBasicValue() * order.getDiscountPercentage() / 100;
        double valueAfterDiscount = order.getBasicValue() - discount;
        double shipping = shippingService.calculateShipping(order.getBasicValue());

        return valueAfterDiscount + shipping;
    }
}