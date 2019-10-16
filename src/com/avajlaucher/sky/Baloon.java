package com.avajlaucher.sky;

import com.avajlaucher.Coordinates;
import com.avajlaucher.Simulator;
import com.avajlaucher.weather.WeatherTower;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    private String curWeather;
    Map<String, String> comments = new HashMap<>();

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
        comments.put("sun", "Let's enjoy the good weather and take some pics.");
        comments.put("rain", "Ohh, it's rain we can drink.");
        comments.put("fog", "This so awful, fucking fog, I can't enjoy the landscapes.");
        comments.put("snow", "Who, shit, is an author of idea to use baloon today?!");
    }

    @Override
    public void updateConditions() throws IOException {

        curWeather = weatherTower.getWeather(coordinates);
       // System.out.println(curWeather);
        switch(curWeather.toLowerCase()){
            case "sun" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 2, coordinates.getHeight() + 4);
            case "rain" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 5, coordinates.getHeight());
            case "fog" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 3, coordinates.getHeight());
            case "snow" :
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 15, coordinates.getHeight());
        }
        if (curWeather.toLowerCase().equals("snow")) {

            Simulator.writeBuf("Baloon#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
            System.out.println("Baloon#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
            this.weatherTower.unregister(this);
            Simulator.writeBuf("Tower says: Baloon#" + this.name +"(" + this.id + ") unregistered from weather tower");
            System.out.println("Tower says: Baloon#" + this.name +"(" + this.id + ") unregistered from weather tower");
        }
        else {
            Simulator.writeBuf("Baloon#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
            System.out.println("Baloon#" + this.name + "(" + this.id + "): " + comments.get(curWeather.toLowerCase()));
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws IOException{
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writeBuf("Tower says: Baloon#" + this.name +"(" + this.id + ") registered to weather tower");
        System.out.println("Tower says: Baloon#" + this.name +"(" + this.id + ") registered to weather tower");
    }
}
