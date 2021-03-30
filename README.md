# WebServerLogParserType1

Purpose:
For a specific log file format, this program extracts the useful data items, and sums up the selected data.

Scenario:
There are a number of shops that sell food items.
Each shop has a number of employees.
There is a warehouse that supplies food items to the shops.
Whenever employees submit an order to the warehouse, the activity is logged.

The project contains these source files:
- Parser.java: This class extracts the useful data items and stores them to a list.
- Statistics.java: This class counts how many orders of each food item have been placed, and stores the countings in key-value pairs in the format of <food_item, number_of_orders>
- FileWriter.java: This interface is implemented by Parser and Statistics.
- Main.java: This class instantiates Parser and Statistics, and uses them.
- Constants.java: This class has the constant values used in the project.

The project contains these data files:
- Input file: input.txt (The program reads the data from this log file that is in a specific format.)
- Output file 1: output_useful_items.txt  (The program writes the extracted data items to this file.)
- Output file 2: output_usage_volume.txt  (The program writes the food ordering usage volume to this file.)

A number of modern techniques and features are used in the program including:
- Generics
- Lambda Expression
- Functional Programming
- Non-blocking I/O ver. 2
- var of Java 10
- Text Block of Java 15

These development tools have been used:
- OpenJDK
- IntelliJ IDEA
