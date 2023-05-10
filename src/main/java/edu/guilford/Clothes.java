package edu.guilford;


import java.util.Random;

import javafx.scene.image.Image;

/**
 * The abstract class representing clothes.
 */
public abstract class Clothes {
    protected String imageName;

    private static final Random random = new Random();

    /**
     * Constructs a new instance of the Clothes class with the specified image name.
     *
     * @param imageName the name of the image associated with the clothes
     */
    public Clothes(String imageName) {
        this.imageName = imageName;
    }

    /**
     * Retrieves the URL of the image associated with the clothes.
     *
     * @return the URL of the image
     */
    protected String getImageUrl() {
        return getClass().getClassLoader().getResource("edu/guilford/resources/" + imageName).toExternalForm();
    }

    /**
     * Generates a random double value within the specified range.
     *
     * @param min the minimum value (inclusive) of the range
     * @param max the maximum value (exclusive) of the range
     * @return a random double value within the specified range
     */
    protected double getRandomDouble(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    /**
     * Generates an outfit image based on the specified parameters.
     * This method should be implemented in subclasses.
     *
     * @param parseDouble   a double value representing a parameter
     * @param valueOf       a WeatherCondition value representing a parameter
     * @return the generated outfit image
     */
    public Image getOutfit(double parseDouble, WeatherCondition valueOf) {
        return null;
    }
}

