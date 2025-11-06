package ru.tikhonovaf.samples.stream.sobes.flatMapOrderProduct;


import lombok.Data;

import java.util.List;

@Data
public class Order {
   String orderId;
   String customerName;
   List<Product> products;

}
