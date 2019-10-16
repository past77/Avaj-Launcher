package com.avajlaucher.sky;

import com.avajlaucher.Coordinates;

public class Aircraft {
   protected long id;
   protected String name;
   protected Coordinates coordinates;
   private static long idCounter = 1;

   Aircraft(){}

   protected Aircraft(String name, Coordinates coordinates){
       this.id = nextId();
       this.name = name;
       this.coordinates = coordinates;
   }

   long nextId(){
       return idCounter++;
   }
}
