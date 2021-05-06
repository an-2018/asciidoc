import 'package:flutter/material.dart';

class Helper {
  static final List<Widget> products = getProductList();

  static get productList => [
        'product1.png',
        'product2.png',
        'product3.png',
        'product4.png',
        'product5.png'
      ];

  static List<Widget> getProductList() {
    List<Widget> list = [];
    productList.forEach((element) {
      print('images/$element');
      list.add(
        GestureDetector(
          child: Container(
            width: 200,
            height: 64,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(15),
            ),
            child: Image.asset('images/$element'),
          ),
          onTap: () {
            print("Hello it works!");
          },
        ),
      );
    });

    return list;
  }
}
