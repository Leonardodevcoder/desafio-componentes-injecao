package com.leonardo.desafio;

import com.leonardo.desafio.entities.Order;
import com.leonardo.desafio.services.OrderService;
import com.leonardo.desafio.services.ShippingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o código do pedido:");
        int code = scanner.nextInt();

        System.out.println("Digite o valor básico do pedido:");
        double basicValue = scanner.nextDouble();

        System.out.println("Digite a porcentagem de desconto:");
        double discountPercentage = scanner.nextDouble();

        Order order = new Order(code, basicValue, discountPercentage);
        OrderService orderService = new OrderService(new ShippingService());

        double totalValue = orderService.calculateTotalValue(order);
        System.out.println("Pedido código " + order.getCode());
        System.out.println("Valor total: R$ " + String.format("%.2f", totalValue));
    }
}