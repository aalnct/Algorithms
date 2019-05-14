package com.balazsholczer;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static List<City> destinationCities = new ArrayList<>();
    
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
