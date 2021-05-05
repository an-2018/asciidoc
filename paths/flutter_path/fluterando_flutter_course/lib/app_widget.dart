import 'package:flutter/material.dart';
import 'home_page.dart';

main(List<String> args) {
  runApp(AppWidget());
}

class AppWidget extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Home(), theme: ThemeData(primarySwatch: Colors.blue));
  }
}
