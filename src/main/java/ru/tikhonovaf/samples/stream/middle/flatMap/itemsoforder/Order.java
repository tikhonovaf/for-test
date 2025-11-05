package ru.tikhonovaf.samples.stream.middle.flatMap.itemsoforder;

import java.util.List;

class Order {
    List<Product> products;

    Order(List<Product> products) {
        this.products = products;
    }
}