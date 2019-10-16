package com.avajlaucher.weather;

import com.avajlaucher.Coordinates;

public final class WeatherProvider {

    private static WeatherProvider weatherProvider;
    public String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};


    private WeatherProvider() {
    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    String getCurrentWeather(Coordinates coordinates){
        int rand = (int) (Math.random() * 4);
        int randNum =  coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() + rand ;

        return weather[randNum % 4];
    }

}
