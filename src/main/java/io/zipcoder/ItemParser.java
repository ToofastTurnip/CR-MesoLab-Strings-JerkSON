package io.zipcoder;

import io.zipcoder.FoodData.AppleData;
import io.zipcoder.FoodData.BreadData;
import io.zipcoder.FoodData.CookieData;
import io.zipcoder.FoodData.MilkData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ItemParser {

    private int errorCounter = 0;
    private MilkData milkData = new MilkData();
    private CookieData cookieData = new CookieData();
    private BreadData breadData = new BreadData();
    private AppleData appleData = new AppleData();
    String fileName = "RawData.txt";

    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }

    public Item parseStringIntoItem(String rawItem) throws ItemParseException{
        return null;
    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }

    public String nameFixer(String name) {
        try {
            char firstLetter = name.toLowerCase().charAt(0);
            if (firstLetter == 'm') return "Milk";
            if (firstLetter == 'c') return "Cookies";
            if (firstLetter == 'a') return "Apples";
            if (firstLetter == 'b') return "Bread";
            else return "What?";
        } catch (Exception e) {
            errorCounter++;
            return "What??";
        }
    }

    public String outputBuilder() {
        StringBuilder sb = new StringBuilder();
        // Build dat table boy
        return sb.toString();
    }

    public String fileToString(String filename) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = ItemParser.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void doEverything() {
        String input = fileToString(fileName);
        ArrayList<String> arrayList = parseRawDataIntoStringArray(input);
        for (int i = 0; i < arrayList.size(); i++) {
            // everything happens here lol
        }
    }

}
