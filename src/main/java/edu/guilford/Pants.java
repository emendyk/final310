package edu.guilford;



import java.io.File;

import javafx.scene.image.Image;

public class Pants extends Clothes {

    private final String imageName = "Pants.png";
    
    public Pants() {
        super("Pants");
    }


    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + imageName);
        return file.toURI().toString();
    }

    @Override
    public Image getOutfit(double temperature, WeatherCondition weatherCondition) {
        if (temperature > 60) {
            return null;
        }
        return new Image(getImageUrl());
    }

}

