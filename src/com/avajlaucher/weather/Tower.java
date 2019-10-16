package com.avajlaucher.weather;

import com.avajlaucher.sky.Flyable;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tower {
   private List<Flyable> observes = new ArrayList<>();

   public void register (Flyable flyable){
        observes.add(flyable);
    }

    public void unregister(Flyable flyable){
        observes.remove(flyable);

    }

    protected void conditionsChanged() throws IOException {

       for (int i = 0; i < observes.size(); i++) {
          // System.out.println(observes.get(i).toString());
           observes.get(i).updateConditions();
       }
    }
}
