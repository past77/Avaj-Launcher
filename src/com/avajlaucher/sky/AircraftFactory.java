package com.avajlaucher.sky;

import com.avajlaucher.Coordinates;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch(type.toLowerCase()){
            case "baloon" :
                return new Baloon(name, coordinates);
            case "helicopter" :
                return new Helicopter(name, coordinates);
            case "jetplane" :
                return new JetPlane(name, coordinates);
            default:
                return null;
        }
    }
}
