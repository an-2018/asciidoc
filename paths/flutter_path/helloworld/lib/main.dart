import 'package:flutter/material.dart';
import 'package:helloworld/animation_samples/animation/animation.dart';
import 'package:helloworld/gridview/gridview.dart';

void main() => runApp(ProductPage());

class ProductPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MyGrid(),
    );
  }
}
