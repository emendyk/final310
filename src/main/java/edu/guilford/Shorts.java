package edu.guilford;

import javafx.scene.image.Image;

import java.io.File;

public class Shorts extends Clothes {

    private final String imageName = "Shorts.png";

    public Shorts() {
        super("Shorts");
    }

    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + imageName);
        return file.toURI().toString();
    }

    @Override
    public Image getOutfit(double temperature, WeatherCondition weatherCondition) {
        if (temperature < 60) {
            return null;
        }
        if (weatherCondition == WeatherCondition.RAINING) {
            return null;
        }
        return new Image(getImageUrl());
    }
}

    