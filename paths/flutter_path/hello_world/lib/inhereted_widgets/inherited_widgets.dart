import 'package:flutter/cupertino.dart';
import 'package:hello_world/main.dart';

main() {
  runApp(Protoype());
}

class MyApp extends InheritedWidget {
  String name;
  MyApp({this.name, Widget child}) : super(child: child);
  @override
  bool updateShouldNotify(covariant InheritedWidget oldWidget) => true;

static MyApp of(BuildContext context) {
    return context.dependOnInheritedWidgetOfExactType<MyApp>();
  }
}

class Protoype extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final name = MyApp.of(context).name;
    return Container(
      child: Center(
        child: Text(name),
      ),
    );
  }
}
