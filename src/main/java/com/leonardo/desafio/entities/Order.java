package com.leonardo.desafio.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private int code;
    private double basicValue;
    private double discountPercentage;
}