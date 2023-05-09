package edu.guilford;

import java.io.File;

public class Shirt extends Clothes {
    
    private final String imageName = "Shirt.png";
    
    public Shirt() {
        super("Shirt");
    }

    @Override
    protected String getImageUrl() {
        File file = new File("resources/edu/guilford/" + imageName);
        return file.toURI().toString();
    }
}


