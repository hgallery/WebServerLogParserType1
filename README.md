# WebServerLogParserType1

**Purpose:**

For a specific log file format, this CLI application extracts and analyzes the data.

**Scenario:**

There are a number of shops that sell food items.
Each shop has a number of employees.
There is a warehouse that supplies food items to the shops.
Whenever employees submit an order to the warehouse, the activity is logged.

**The project contains these source files:**

- ``Parser.java``: This class extracts the useful data items and stores them to a list.
- ``Statistics.java``: This class counts how many orders of each food item have been placed, 
  and stores the counting in key-value pairs in the format of <food_item, number_of_orders>
- ``FileWriter.java``: This interface is implemented by Parser and Statistics for a pattern.
- ``Main.java``: This class instantiates Parser and Statistics, and uses their methods.
- ``Constants.java``: This class has the constant values used in the project.

**The project contains these data files:**

- Input file: ``input.txt`` (The Parser program reads the data from this log file that is in a specific format.)
- Output file 1: ``output_useful_items.txt``  (The Parser program writes the extracted data to this file.)
- Output file 2: ``output_usage_volume.txt``  (The Statistics program writes the food ordering usage to this file.)


**About Functional Programming:**

It is aimed at having Lambda functions only in pure functional form. A function is considered pure if it meets these requirements:
- The return value of the function depends only on the input parameters passed to the function.
- The execution of the function brings no side effects. (Search for this topic on the Internet if further information is required.)

By maintaining the pure functional form, developers can consider applying parallel stream processing.

**About Branching:**

***Main branch:*** contains only the program files, input file, output files, and this Readme file.  
***Master branch:*** also contains the IntelliJ IDEA's configuration files.

**A number of modern techniques and features are used including:**

- Generics
- Lambda Expression
- Functional Programming
- Non-blocking I/O ver. 2
- var of Java 10
- Text Block of Java 15


**These development tools have been used:**
- OpenJDK
- IntelliJ IDEA
