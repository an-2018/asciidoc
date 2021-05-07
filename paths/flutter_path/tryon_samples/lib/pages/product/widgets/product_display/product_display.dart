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
        child: Text("Teste")
        //ListView(children: getProducts(), scrollDirection: Axis.horizontal),
        );
  }

  List<Widget> getProducts() {
    List<Widget> list = [];
    Helper.getProductList().forEach((element) {
      print('${element.name}');
      list.add(
        GestureDetector(
          child: Container(
            width: 200,
            height: 64,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(15),
            ),
            child: Image.asset('${element.imgUrl}'),
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
