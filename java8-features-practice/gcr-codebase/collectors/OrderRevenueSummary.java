package collectors;

import java.util.*;
import java.util.stream.*;

class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("Rahul", 500),
                new Order("Amit", 300),
                new Order("Rahul", 700)
        );

        Map<String, Double> revenue =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.summingDouble(Order::getAmount)
                        ));

        System.out.println(revenue);
    }
}

class Order {
    private String customer;
    private double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    String getCustomer() { return customer; }
    double getAmount() { return amount; }
}
