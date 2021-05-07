import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class MyAnimation extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(),
        body: const Center(
          child: MyStatefullWidget(),
        ),
      ),
    );
  }
}

class MyStatefullWidget extends StatefulWidget {
  const MyStatefullWidget({Key key}) : super(key: key);
  @override
  _MyStatefullWidgetState createState() => _MyStatefullWidgetState();
}

class _MyStatefullWidgetState extends State<MyStatefullWidget> {
  double sideLength = 50;

  @override
  Widget build(BuildContext context) {
    return AnimatedContainer(
      height: sideLength,
      width: sideLength,
      duration: const Duration(seconds: 2),
      curve: Curves.easeIn,
      color: Colors.amber,
      child: InkWell(
        onTap: () {
          setState(() {
            sideLength == 50 ? sideLength = 100 : sideLength = 50;
          });
        },
      ),
    );
  }
}
