package edu.guilford;

import java.io.File;

/**
 * The Shirt class represents a shirt as a type of clothing.
 * It extends the abstract class Clothes.
 */
public class Shirt extends Clothes {

    private final String imageName = "Shirt.png";

    /**
     * Constructs a new instance of the Shirt class.
     * It sets the image name to "Shirt" using the superclass constructor.
     */
    public Shirt() {
        super("Shirt");
    }

    /**
     * Retrieves the URL of the shirt image.
     *
     * @return the URL of the shirt image
     */
    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + imageName);
        return file.toURI().toString();
    }
}
