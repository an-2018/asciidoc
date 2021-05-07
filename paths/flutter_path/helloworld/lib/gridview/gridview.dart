import 'package:flutter/material.dart';
import 'package:helloworld/models/MockCategories.dart';
import 'package:helloworld/models/MockList.dart';

class MyGrid extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Center(
            child: GridView.count(
              crossAxisCount: CategoryTypes.values.length,
              children: getCategoryList(),
            ),
          ),
        ],
      ),
    );
  }

  List<Widget> getCategoryList() {
    return mockList.map<Widget>((element) {
      return Padding(
        padding: const EdgeInsets.all(8.0),
        child: Container(
          color: Colors.amber,
          child: Center(child: Text(element.name)),
        ),
      );
    }).toList();
  }
}
