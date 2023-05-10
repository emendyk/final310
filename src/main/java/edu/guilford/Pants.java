package edu.guilford;



import java.io.File;

import javafx.scene.image.Image;

/**
 * The Pants class represents pants as a type of clothing.
 * It extends the abstract class Clothes.
 */
public class Pants extends Clothes {

    private final String imageName = "Pants.png";

    /**
     * Constructs a new instance of the Pants class.
     * It sets the image name to "Pants" using the superclass constructor.
     */
    public Pants() {
        super("Pants");
    }

    /**
     * Retrieves the URL of the pants image.
     *
     * @return the URL of the pants image
     */
    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + imageName);
        return file.toURI().toString();
    }

    /**
     * Generates an outfit image based on the temperature and weather condition.
     * If the temperature is greater than 60 degrees Fahrenheit, null is returned;
     * otherwise, a pants image is returned.
     *
     * @param temperature      the temperature in degrees Fahrenheit
     * @param weatherCondition the weather condition
     * @return the generated outfit image or null
     */
    @Override
    public Image getOutfit(double temperature, WeatherCondition weatherCondition) {
        if (temperature > 60) {
            return null;
        }
        return new Image(getImageUrl());
    }

}
