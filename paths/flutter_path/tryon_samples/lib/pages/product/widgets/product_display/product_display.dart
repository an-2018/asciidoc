import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:tryon_samples/core/helpers.dart';

class ProductDisplay extends StatelessWidget {
  final Widget image;

  const ProductDisplay({Key key, this.image}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: [
          Text('Product Display'),
          Expanded(
            flex: 2,
            child: ProductImage(
              image: Image.asset('images/product1.png'),
            ),
          ),
          Expanded(
            flex: 1,
            child: ProductListMiniatures(),
          ),
        ],
      ),
    );
  }
}

class ProductImage extends StatelessWidget {
  const ProductImage({
    Key key,
    this.image,
  }) : super(key: key);

  final Widget image;

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 64.0,
      width: double.infinity,
      color: Colors.white54,
      child: image,
    );
  }
}

class ProductListMiniatures extends StatelessWidget {
  const ProductListMiniatures({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 250.0,
      width: double.infinity,
      color: Colors.grey,
      child:
          ListView(children: Helper.products, scrollDirection: Axis.horizontal),
    );
  }
}
