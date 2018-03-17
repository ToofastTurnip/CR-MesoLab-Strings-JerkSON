package io.zipcoder.FoodData;

import java.util.ArrayList;

public class BreadData implements FoodDataInterface {

    public void addNewPriceToList(double priceToAdd) {
        foodPrices.add(priceToAdd);
    }

    public ArrayList getFoodPrices() {
        return foodPrices;
    }

}
