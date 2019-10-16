package com.avajlaucher.sky;

import com.avajlaucher.Coordinates;
import com.avajlaucher.Simulator;
import com.avajlaucher.weather.WeatherTower;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower = new WeatherTower();
    private String curWeather;
    Map<String, String> comments = new HashMap<>();

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
        comments.put("sun", "So beauty clouds.");
        comments.put("rain", "We're gonna be a rainbow!!!.");
        comments.put("fog", "Rain? Duh.. I don't care about it.");
        comments.put("snow", "OMG! Winter is coming!!!");
    }


    @Override
    public void updateConditions() throws IOException {
        curWeather = weatherTower.getWeather(coordinates);
        switch(curWeather.toLowerCase()){
            case "sun" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            case "rain" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 5, coordinates.getHeight());
            case "fog" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 1, coordinates.getHeight());
            case "snow" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 7, coordinates.getHeight());
        }

        Simulator.writeBuf("JetPlane#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
        System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws IOException {

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writeBuf("Tower says: JetPlane#" + this.name +"(" + this.id + ") registered to weather tower");
        System.out.println("Tower says: JetPlane#" + this.name +"(" + this.id + ") registered to weather tower");
    }
}
