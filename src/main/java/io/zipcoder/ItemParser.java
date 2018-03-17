package io.zipcoder;

import io.zipcoder.FoodData.AppleData;
import io.zipcoder.FoodData.BreadData;
import io.zipcoder.FoodData.CookieData;
import io.zipcoder.FoodData.MilkData;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemParser {

    int errorCounter = 0;
    MilkData milkData = new MilkData();
    CookieData cookieData = new CookieData();
    BreadData breadData = new BreadData();
    AppleData appleData = new AppleData();

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
            if (firstLetter == 'c') return "Cookie";
            if (firstLetter == 'a') return "Apple";
            if (firstLetter == 'b') return "Bread";
        } catch (Exception e) {
            errorCounter++;
            return "What?";
        }
        return "How did the program even get here lol";
    }

}
