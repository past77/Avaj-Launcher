package com.avajlaucher;

import com.avajlaucher.sky.AircraftFactory;
import com.avajlaucher.weather.WeatherProvider;
import com.avajlaucher.weather.WeatherTower;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Simulator {
    int result;

    AircraftFactory aircraftFactory  = new AircraftFactory();
    WeatherTower weatherTower = new WeatherTower();
   private static BufferedWriter writer;

    public static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter("/Users/ppolozhe/Desktop/simulator.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void closeFile(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBuf(String fileContent) {

        try {
            writer.write(fileContent);
            writer.newLine();
        }
        catch (IOException e){
            e.getMessage();
        }

    }

    void parseInput(List l) throws IOException{

        Iterator<String> itr = l.iterator();
        result = Integer.parseInt(itr.next());
        while (itr.hasNext()) {
            String[] parts = itr.next().split(" ");
            if (itr.hasNext()) {
                aircraftFactory.newAircraft(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4])).registerTower(weatherTower);
            }
        }
    }
    void Simulate(){
        for (int i = 0; i < result; i++)
            weatherTower.changeWeather();
    }
}
