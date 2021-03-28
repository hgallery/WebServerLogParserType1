# WebServerLogParserType1

Purpose:
For a specific log file format, this program shows how to extract the useful data items, and sums up the selected data.

Scenario:
There are a number of shops that sell food items.
Each shop has a number employees.
There is a warehouse that supplies food items to the shops.
Whenever employees submit an order of food item to the warehouse, the activity is logged.

The package contains theses classes:
- Parser.java: This class extracts the useful data items and stores them to a list.
- Statistics.java: This class sums up every food ordering, and stores that data in key-value pairs in the format of <food_item, number_of_orders>
- Main.java: This class instantiates Parser and Statistics, and uses them.
- Constants.java: This class has the constant values used in the project.

This package contains these data files:
- Input file: input.txt (This is the log file in the specific format.)
- Output file 1: output_useful_items.txt  (The program writes the extracted data items to this file.)
- Output file 2: output_usage_volume.txt  (The program writes the food ordering usage volume to this file.)

A number of modern techniques are used in the program including:
- Generics
- Lambda Expression
- Functional Programming
- Non-blocking I/O ver. 2
- var of Java 10
- Text Block of Java 15

These development tools have been used:
- OpenJDK 16
- IntelliJ IDEA 2020.2.3
