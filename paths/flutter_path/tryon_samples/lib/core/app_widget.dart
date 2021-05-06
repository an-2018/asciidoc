import 'package:flutter/material.dart';
import 'package:tryon_samples/pages/product/product.dart';

class AppWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Center(child: Text("Tryon Samples")),
        backgroundColor: Colors.blue,
      ),
      body: Container(
        padding: EdgeInsets.all(20),
        child: Row(
          children: [
            getPageLink("Products", context),
            getPageLink("Provider", context)
          ],
        ),
      ),
    );
  }

  Widget getPageLink(String pageLink, BuildContext context) {
    return Column(
      children: [
        GestureDetector(
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Container(
              height: 64,
              width: 128,
              child: Center(
                child: Text(
                  "$pageLink",
                  style: TextStyle(color: Colors.white),
                ),
              ),
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(15),
                color: Colors.blue,
              ),
            ),
          ),
          onTap: () {
            Navigator.push(context,
                MaterialPageRoute(builder: (context) => ProductPage()));
          },
        ),
      ],
    );
  }
}
