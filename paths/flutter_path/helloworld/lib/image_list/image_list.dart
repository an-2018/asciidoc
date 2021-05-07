import 'package:flutter/material.dart';

class MyImageList extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.start,
            mainAxisSize: MainAxisSize.max,
            children: getImageList(),
          ),
        ),
      ),
    );
  }

  getImageList() {
    List<Widget> list = [];

    ['pic1.jpg', 'pic2.jpg', 'pic3.jpg'].forEach((element) {
      list.add(Expanded(
        child: Container(
          width: 200,
          height: 100,
          child: Image.asset("images/$element"),
        ),
      ));
    });
    list.add(
      Text(
        "Hello",
        style: TextStyle(fontSize: 32),
      ),
    );
    return list;
  }
}
