import 'package:flutter/material.dart';
import 'package:helloworld/animation_samples/animation/animation.dart';
import 'package:helloworld/gridview/gridview.dart';
import 'package:helloworld/image_list/image_list.dart';
import 'package:helloworld/list_of_items/list_items.dart';
import 'package:helloworld/pie_chart/pie_chart.dart';

void main() => runApp(ProductPage());

class ProductPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Samples"),
          backgroundColor: Colors.amber,
        ),
        body: Container(
          padding: EdgeInsets.symmetric(horizontal: 30),
          child: GridView.builder(
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 2,
                  crossAxisSpacing: 10,
                  mainAxisSpacing: 10,
                  childAspectRatio: 1.4),
              itemCount: listOfWidgets.length,
              itemBuilder: (context, index) {
                return Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    color: Colors.amber,
                    child: GestureDetector(
                      onTap: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => listOfWidgets[index]),
                        );
                      },
                      child: ListTile(
                        title: Center(
                          child: Text("$index"),
                        ),
                      ),
                    ),
                  ),
                );
              }),
        ),
      ),
    );
  }
}

List<Widget> listOfWidgets = [
  MyAnimation(),
  MyPieChart(),
  MyDataSource(),
  MyGrid(),
  MyImageList()
];
