package edu.guilford;

import java.io.File;
import java.util.Random;

import javafx.scene.image.Image;

public abstract class Clothes {
    protected String imageName;

    private static final Random random = new Random();

    public Clothes(String imageName) {
        this.imageName = imageName;
    }

    protected String getImageUrl() {
        return getClass().getClassLoader().getResource("edu/guilford/resources/" + imageName).toExternalForm();
    }
    
    protected double getRandomDouble(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    public Image getOutfit(double parseDouble, WeatherCondition valueOf) {
        return null;
    }
}
