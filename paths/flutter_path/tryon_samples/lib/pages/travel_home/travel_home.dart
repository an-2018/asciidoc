import 'dart:js';

import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      body: TravelHome(),
    ),
  ));
}

class TravelHome extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width,
      decoration: BoxDecoration(color: Colors.blue[50]),
      child: ListView(
        children: [hero(context), hero(context)],
      ),
    );
  }

  var hero = (context) => Container(
        height: MediaQuery.of(context).size.height,
        decoration: BoxDecoration(color: Colors.amber),
        child: Column(
          children: [
            Container(
              height: 500,
              width: MediaQuery.of(context).size.width,
              decoration: BoxDecoration(color: Colors.blue[50]),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.end,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text(
                    "Tryon",
                    style: TextStyle(fontSize: 56, fontWeight: FontWeight.w400),
                  )
                ],
              ),
            ),
            Container(
              child: Column(
                children: [
                  Container(
                      decoration: BoxDecoration(
                          color: Colors.white,
                          borderRadius: BorderRadius.circular(10)),
                      width: MediaQuery.of(context).size.width * 0.45,
                      padding: EdgeInsets.all(10),
                      child: FormInput()),
                ],
              ),
            ),
            Padding(padding: EdgeInsets.all(10)),
            Container(
              width: MediaQuery.of(context).size.width * 0.45,
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Container(
                    width: 50,
                    height: 50,
                    color: Colors.white,
                  ),
                  Container(
                    width: 50,
                    height: 50,
                    color: Colors.white,
                  )
                ],
              ),
            )
          ],
        ),
      );
}

class FormInput extends StatefulWidget {
  @override
  _FormInputState createState() => _FormInputState();
}

class _FormInputState extends State<FormInput> {
  final _formKey = GlobalKey<FormState>();

  var formField = TextFormField(
    validator: (value) {
      if (value == null || value.isEmpty) {
        return "Please enter some text";
      }
      return null;
    },
  );

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        children: <Widget>[
          formField,
        ],
      ),
    );
  }
}

/*
 ElevatedButton(
            onPressed: () {
              if (_formKey.currentState.validate()) {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text("Processing Data"),
                  ),
                );
              }
            },
            child: Text("Submit"),
          ),
          */
