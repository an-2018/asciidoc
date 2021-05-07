import 'package:flutter/material.dart';
import 'package:tryon_samples/core/app_widget.dart';
import 'package:tryon_samples/pages/home/home.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Home(),
    );
  }
}
