# WebServerLogParserType1
Purpose:
For a specific file format, extract the useful data items, and calculate the usage volume.

This program utilizes a number of modern techniques including
> Generics
> Lambda Expression
> Functional Programming
> Non-blocking I/O ver. 2
> var of Java 10
> Text Block of Java 15

These developement tools have been used:
> OpenJDK 16
> IntelliJ


Input file: input.txt (This is the log file in a specific format for demonstration)
Output file 1: output_useful_items.txt  (The program writes the extracted items to this file.)
Output file 2: output_usage_volume.txt  (The program writes the usage volume to this file.)


The screen-output in Shell:

Useful Items
-------------------
[yyyy-mm-dd, hh-mm-ss, POST, VEGGIE001, SHOP_1, user_id_1234]
[yyyy-mm-dd, hh-mm-ss, POST, VEGGIE002, SHOP_2, user_id_5678]
[yyyy-mm-dd, hh-mm-ss, POST, PASTA001, SHOP_1, user_id_7890]
[yyyy-mm-dd, hh-mm-ss, POST, VEGGIE002, SHOP_1, user_id_1234]
[yyyy-mm-dd, hh-mm-ss, POST, PASTA002, SHOP_1, user_id_7890]
[yyyy-mm-dd, hh-mm-ss, POST, PASTA002, SHOP_1, user_id_2468]

Usage Volume
-------------------
PASTA002 2
PASTA001 1
VEGGIE002 2
VEGGIE001 1


