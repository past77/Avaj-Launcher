package com.avajlaucher;

import com.avajlaucher.sky.AircraftFactory;
import com.avajlaucher.sky.Flyable;
import com.avajlaucher.weather.WeatherTower;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.avajlaucher.Simulator.readFileInList;

public class Runner {
    private static Simulator simulator = new Simulator();

    public static void main(String[] args)  {
        System.out.println("HELLO AMA JAVA");

        List l = simulator.readFileInList("/Users/ppolozhe/Desktop/scenario.txt");

    try {
        simulator.openFile();
        simulator.parseInput(l);
    }
    catch (IOException e){
        e.getStackTrace();
    }
        simulator.Simulate();
        simulator.closeFile();
    }
}
