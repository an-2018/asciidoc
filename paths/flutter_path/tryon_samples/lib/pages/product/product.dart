import 'package:flutter/material.dart';

import 'widgets/widgets.dart';

class ProductPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Center(child: Text("Product")),
      ),
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
