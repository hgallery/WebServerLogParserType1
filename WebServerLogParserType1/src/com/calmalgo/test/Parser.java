package com.calmalgo.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 This class reads the log file, extracts the useful data items, and writes to a file.
**/
class Parser implements FileWriter {

    private List<List<String>> listOfUsefulItems;


    Function<String, List<String>> extractedItems = (logLine) -> {

        List<String> extractedItems = new ArrayList<>();

        boolean hasPostIndicator;
        String[] tokens = logLine.split(" ");

        if (tokens.length >= 4) {

            hasPostIndicator = tokens[3].equals(Constants.POST_INDICATOR);

            if (hasPostIndicator) {

                String[] logFilePathAndDate = tokens[0].split(":");
                extractedItems.add(logFilePathAndDate[2]);

                extractedItems.add(tokens[1]);     // time
                extractedItems.add(tokens[3]);     // POST indicator

                int indexBegin = tokens[4].lastIndexOf("/");
                int indexEnd = tokens[4].lastIndexOf(".");
                String foodCode = tokens[4].substring(indexBegin+1, indexEnd);
                extractedItems.add(foodCode.toUpperCase());      // food code

                String[] shopAndUser = tokens[7].split("\\\\");
                extractedItems.add(shopAndUser[0]);     // shop
                extractedItems.add(shopAndUser[1]);     // user_id
            }
            else {
                extractedItems.add("");
            }
        }
        else {
            extractedItems.add("");
        }

        return extractedItems;
    };


    Predicate<List<String>> isEmpty = extractedItems -> extractedItems.get(0).equals("");


    void extractListOfUsefulItems() {
        Path inputPath = Path.of(Constants.INPUT_FILE_NAME);
        try (Stream<String> textStream = Files.lines(inputPath)) {
            listOfUsefulItems = textStream
                                .map(extractedItems)
                                .filter(isEmpty.negate())
                                .collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    List<List<String>> getListOfUsefulItems() {
        return listOfUsefulItems;
    }


    @Override
    public void writeFile() {
        Path outputPath = Path.of(Constants.OUTPUT_USEFUL_ITEMS_FILE_NAME);

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            if (!Files.exists(outputPath))
                Files.createFile(outputPath);

            for (List<String> usefulItems : listOfUsefulItems) {
                for (String item : usefulItems) {
                    writer.write(item + " ");
                }
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
