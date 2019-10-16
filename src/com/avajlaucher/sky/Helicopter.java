package com.avajlaucher.sky;

import com.avajlaucher.Coordinates;
import com.avajlaucher.Simulator;
import com.avajlaucher.weather.WeatherTower;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private String curWeather;
    Map<String, String> comments = new HashMap<>();

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        comments.put("sun", "This is hot.");
        comments.put("rain", "Oh shit, again this fucking rain.");
        comments.put("fog", "Where is the Earth?");
        comments.put("snow", "I hope my rotor is Ok.");
    }

    @Override
    public void updateConditions() throws IOException {
        curWeather = weatherTower.getWeather(coordinates);
        //System.out.println(curWeather);
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
                        coordinates.getLatitude() + 12, coordinates.getHeight());
        }
        Simulator.writeBuf("Helicopter#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
        System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        Simulator.writeBuf("Tower says: Helicopter#" + this.name +"(" + this.id + ") registered to weather tower");
        System.out.println("Tower says: Helicopter#" + this.name +"(" + this.id + ") registered to weather tower");
    }
}
