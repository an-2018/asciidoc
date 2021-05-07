import 'package:flutter/material.dart';
import 'package:tryon_samples/models/product.dart';

class Helper {
  static List<Product> getProductList() {
    return <Product>[
      Product("Fogo Trip", "images/product1.png", "Description", 12000),
      Product("Santiago Trip", "images/product2.png", "Description", 12000),
      Product("Sal Trip", "images/product3.png", "Description", 12000),
    ];
  }
}
