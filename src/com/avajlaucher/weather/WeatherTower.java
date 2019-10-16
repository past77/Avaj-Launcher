package com.avajlaucher.weather;

import com.avajlaucher.Coordinates;

import java.io.IOException;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates){
            return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather(){
        try {
            this.conditionsChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
