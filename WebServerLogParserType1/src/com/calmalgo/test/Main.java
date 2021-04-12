package com.calmalgo.test;
import java.util.List;


/**
 The Main class uses the Parser class and Statistics class.
 **/
public class Main {


    public static void main(String[] args) {

        var parser = new Parser();
        parser.extractListOfUsefulItems();


        String titleUsefulItems = """
                                
                                Useful Items
                                -------------------
                                """;
        System.out.print(titleUsefulItems);
        parser.getListOfUsefulItems().forEach(System.out::println);
        parser.writeFile();


        List<List<String>> listOfUsefulItems = parser.getListOfUsefulItems();
        var statistics = new Statistics(listOfUsefulItems);
        statistics.sumUpUsageVolume();


        String titleUsageVolume = """
                                 
                                 Usage Volume
                                 -------------------
                                 """;
        System.out.print(titleUsageVolume);
        statistics.getUsageVolume().forEach( (k,v) -> System.out.println(k + " " + v));
        statistics.writeFile();

    }
}

