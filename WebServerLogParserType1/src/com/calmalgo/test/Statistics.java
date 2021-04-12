package com.calmalgo.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 This class gets a list of useful data items, tallies the food order usage, and writes to a file.
 **/
class Statistics implements FileWriter{

    private final List<List<String>> listOfUsefulItems;
    private final Map<String, Integer> usageVolume;

    Statistics (List<List<String>> listOfUsefulItems) {
        this.listOfUsefulItems = listOfUsefulItems;

        this.usageVolume = new TreeMap<>();
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

    @Override
    public void writeFile() {

        Path outputPath = Path.of(Constants.OUTPUT_USAGE_VOLUME_FILE_NAME);

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            if (!Files.exists(outputPath))
                Files.createFile(outputPath);

            for (Map.Entry<String, Integer> entry : usageVolume.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
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
