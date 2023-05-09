package edu.guilford;

import javafx.scene.image.Image;
import java.io.File;

import java.io.File;
import javafx.scene.image.Image;

public class Jacket extends Clothes {
    private static final String IMAGE_NAME = "Jacket.png";

    public Jacket() {
        super("Jacket");
    }

    
       protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + IMAGE_NAME);
        return file.toURI().toString();
    }

    @Override
    public Image getOutfit(double temperature, WeatherCondition weatherCondition) {
        if (temperature < 60 || weatherCondition == WeatherCondition.RAINING) {
            return new Image(getImageUrl());
        } else {
            return null;
        }
    }


    
}


