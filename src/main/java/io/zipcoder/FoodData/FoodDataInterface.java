package io.zipcoder.FoodData;

import java.util.ArrayList;

public interface FoodDataInterface {

    ArrayList foodPrices = new ArrayList();

    public void addNewPriceToList(double priceToAdd);

    public ArrayList getFoodPrices();

}
