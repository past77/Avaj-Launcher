package com.avajlaucher.sky;

import com.avajlaucher.weather.WeatherTower;

import java.io.IOException;

public interface Flyable {
    void updateConditions() throws IOException;
    void registerTower(WeatherTower weatherTower) throws IOException;
}
