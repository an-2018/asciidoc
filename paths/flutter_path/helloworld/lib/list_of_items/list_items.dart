import 'package:flutter/material.dart';

class MixedList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Datasource to list of widgets"),
      ),
      body: MyDataSource(
        items: List<ListItem>.generate(
          20,
          (i) {
            return i % 2 == 0
                ? HeadingItem("Heading $i")
                : MessageItem("Sender $i", "Body $i");
          },
        ),
      ),
    );
  }
}

class MyDataSource extends StatelessWidget {
  final List<ListItem> items;

  const MyDataSource({Key key, this.items}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: items.length,
      itemBuilder: (context, index) {
        final item = items[index];
        return ListTile(
          title: item.buildTitle(context),
          subtitle: item.buildSubTitle(context),
        );
      },
    );
  }
}

// Create a datasource with different types of items

abstract class ListItem {
  Widget buildTitle(BuildContext context);

  Widget buildSubTitle(BuildContext context);
}

class HeadingItem implements ListItem {
  final String heading;

  HeadingItem(this.heading);

  @override
  Widget buildTitle(BuildContext context) {
    return Text(
      heading,
      style: Theme.of(context).textTheme.headline5,
    );
  }

  @override
  Widget buildSubTitle(BuildContext context) => null;
}

class MessageItem implements ListItem {
  final String sender;
  final String body;

  MessageItem(this.sender, this.body);

  @override
  Widget buildSubTitle(BuildContext context) => Text(sender);

  @override
  Widget buildTitle(BuildContext context) => Text(body);
}

// Create a list of items

final items = List<ListItem>.generate(
    20,
    (i) => i % 2 == 0
        ? HeadingItem("Heading $i")
        : MessageItem("Sender $i", "Message body $i"));

// Conver the data source into a list of widgets
