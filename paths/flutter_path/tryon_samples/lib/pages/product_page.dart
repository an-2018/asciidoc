import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:tryon_samples/pages/components/product_details.dart';
import 'package:tryon_samples/pages/components/product_display.dart';

import 'components/product_list.dart';

class ProductPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Body(),
    );
  }
}

class Body extends StatelessWidget {
  const Body({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        children: [
          Expanded(
            flex: 2,
            child: ProductDisplay(),
          ),
          Expanded(
            flex: 1,
            child: ProductDetail(),
          )
        ],
      ),
    );
  }
}
