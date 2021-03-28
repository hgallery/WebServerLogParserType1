package com.calmalgo.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 After getting a list of useful data items, sum up the usage volume, then write to a file.
 **/
public class Statistics {

    private final List<List<String>> listOfUsefulItems;
    private final Map <String, Integer> usageVolume;

    Statistics (List<List<String>> listOfUsefulItems) {
        this.listOfUsefulItems = listOfUsefulItems;

        this.usageVolume = new HashMap<>();
        for (String foodCode : Constants.foodCodes)
            usageVolume.put(foodCode, 0);
    }

    void sumUpUsageVolume() {
        for (List<String> usefulItems : listOfUsefulItems) {
            for (String foodCode : Constants.foodCodes) {
                if (usefulItems.contains(foodCode)) {
                    int tally = usageVolume.get(foodCode);
                    usageVolume.put (foodCode, ++tally);
                }
            }
        }
    }


    void writeFile() {
        Path outputPath = Path.of(Constants.OUTPUT_USAGE_VOLUME_FILE_NAME);
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            for (Map.Entry<String, Integer> set : usageVolume.entrySet()) {
                writer.write(set.getKey() + " " + set.getValue());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
   }


    Map<String, Integer> getUsageVolume() {
        return usageVolume;
    }


}