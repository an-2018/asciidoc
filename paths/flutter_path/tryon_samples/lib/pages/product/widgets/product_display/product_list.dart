import 'package:flutter/material.dart';

class ProductList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        height: 64.0,
        width: MediaQuery.of(context).size.width * 0.8,
        color: Colors.cyan,
        child: Row(
          children: [
            Image.asset('images/product1.png')
            ],
        ),
      ),
    );
  }
}
