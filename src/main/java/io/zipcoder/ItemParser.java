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
        String rawDataFix = rawData.substring(0, rawData.length() - 2);
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawDataFix);
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

    public void doEverythingBesidesOutput() {
        String input = fileToString(fileName);
        ArrayList<String> arrayList = parseRawDataIntoStringArray(input);
        for (String anArrayList : arrayList) {
            // everything happens here lol
            String[] temp = anArrayList.split("([;:|^@!*%])");
            if (!temp[1].equals("") && !temp[3].equals("") && !temp[5].equals("") && !temp[7].equals("")) {
                if (nameFixer(temp[1]).equals("Cookies")) {
                    cookieData.addNewPriceToList(Double.parseDouble(temp[3]));
                }
                if (nameFixer(temp[1]).equals("Milk")) {
                    milkData.addNewPriceToList(Double.parseDouble(temp[3]));
                }
                if (nameFixer(temp[1]).equals("Bread")) {
                    breadData.addNewPriceToList(Double.parseDouble(temp[3]));
                }
                if (nameFixer(temp[1]).equals("Apples")) {
                    appleData.addNewPriceToList(Double.parseDouble(temp[3]));
                }
            } else {
                errorCounter++;
            }
        }
    }

    public void output() {
        doEverythingBesidesOutput();
        for (int i = 0; i < milkData.getFoodPrices().size(); i++) {
            System.out.println(String.format("%-15s%10s%15s%2d%5s", "name:", "Milk", "seen: ", milkData.getFoodPrices().size(), " times"));
            System.out.println("================================================");
        }
        for (int j = 0; j < cookieData.getFoodPrices().size(); j++) {
            System.out.println(String.format("%-15s%10s%15s%2d%5s", "name:", "Cookies", "seen: ", cookieData.getFoodPrices().size(), " times"));
            System.out.println("================================================");
        }
        for (int k = 0; k < breadData.getFoodPrices().size(); k++) {
            System.out.println(String.format("%-15s%10s%15s%2d%5s", "name:", "Bread", "seen: ", breadData.getFoodPrices().size(), " times"));
            System.out.println("================================================");
        }
        for (int l = 0; l < appleData.getFoodPrices().size(); l++) {
            System.out.println(String.format("%-15s%10s%15s%2d%5s", "name:", "Apple", "seen: ", appleData.getFoodPrices().size(), " times"));
            System.out.println("================================================");
        }
        System.out.println("Exceptions:                                    " + errorCounter);
    }

}
