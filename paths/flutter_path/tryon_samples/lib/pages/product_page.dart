import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:tryon_samples/pages/components/product_display.dart';

import 'components/product_list.dart';

class ProductPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Align(
            alignment: Alignment.bottomCenter,
            child: ProductDisplay(),
          ),
          Align(
            alignment: Alignment.centerLeft,
            child: ProductList(),
          ),
        ],
      ),
    );
  }
}
