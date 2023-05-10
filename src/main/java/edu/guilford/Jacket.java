package edu.guilford;

import javafx.scene.image.Image;
import java.io.File;

/**
 * The Jacket class represents a jacket as a type of clothing.
 * It extends the abstract class Clothes.
 */
public class Jacket extends Clothes {
    private static final String IMAGE_NAME = "Jacket.png";

    /**
     * Constructs a new instance of the Jacket class.
     * It sets the image name to "Jacket" using the superclass constructor.
     */
    public Jacket() {
        super("Jacket");
    }

    /**
     * Retrieves the URL of the jacket image.
     *
     * @return the URL of the jacket image
     */
    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + IMAGE_NAME);
        return file.toURI().toString();
    }

    /**
     * Generates an outfit image based on the temperature and weather condition.
     * If the temperature is less than 60 degrees Fahrenheit or the weather condition is raining,
     * a jacket image is returned; otherwise, null is returned.
     *
     * @param temperature      the temperature in degrees Fahrenheit
     * @param weatherCondition the weather condition
     * @return the generated outfit image or null
     */
    @Override
    public Image getOutfit(double temperature, WeatherCondition weatherCondition) {
        if (temperature < 60 || weatherCondition == WeatherCondition.RAINING) {
            return new Image(getImageUrl());
        } else {
            return null;
        }
    }
}




    



