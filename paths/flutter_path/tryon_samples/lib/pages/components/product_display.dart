import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';

main() {
  runApp(ProductDisplay());
}

class ProductDisplay extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
        color: Colors.amber,
        height: 128.0,
        width: MediaQuery.of(context).size.width / 2);
  }
}
