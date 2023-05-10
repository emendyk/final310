package edu.guilford;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.util.Random;
/**
 * OufitGenerator sets up the GUI for the outfit generator. Where a random outfit is displayed,
 * when the user clicks on the generate outfit button.
 * GridPane is used to hold the buttons and images. The background color is set to lightblue
 * so the lighter colored outfits are able to be seen when displayed.
 */

public class OutfitGenerator extends Application {
    
    private final int MAX_TEMP = 150;
    private final int MIN_TEMP = -50;
    private final int DEFAULT_TEMP = 70;
    private ImageView topImageView;
    private ImageView bottomImageView;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // create grid pane to hold buttons and images
        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setStyle("-fx-background-color: lightblue;");
        // create label and text field for temperature input
        Label tempLabel = new Label("Temperature:");
        TextField tempTextField = new TextField();
        tempTextField.setMaxWidth(50);
        tempTextField.setText(String.valueOf(DEFAULT_TEMP));
        

        // add label and text field to grid pane
        gridPane.add(tempLabel, 0, 2);
        gridPane.add(tempTextField, 1, 2);
        // add four JRadio button for weather condition (sunny, cloudy, raining, windy)

        ToggleGroup weatherGroup = new ToggleGroup();
        RadioButton sunnyButton = new RadioButton("Sunny");
        sunnyButton.setToggleGroup(weatherGroup);
        RadioButton cloudyButton = new RadioButton("Cloudy");
        cloudyButton.setToggleGroup(weatherGroup);
        RadioButton rainingButton = new RadioButton("Raining");
        rainingButton.setToggleGroup(weatherGroup);
        RadioButton windyButton = new RadioButton("Windy");
        windyButton.setToggleGroup(weatherGroup);

        // add radio buttons to grid pane
        gridPane.add(sunnyButton, 0, 4);
        gridPane.add(cloudyButton, 0, 5);
        gridPane.add(rainingButton, 0, 6);
        gridPane.add(windyButton, 0, 7);

        // create label and text field for weather condition (sunny, cloudy, raining, windy)
        Label weatherLabel = new Label("Weather Condition:");
        // add weather label to grid pane
        gridPane.add(weatherLabel, 0, 3);

        

        // create button to generate outfit
        Button generateButton = new Button("Generate Outfit");
        generateButton.setOnAction(event -> generateOutfit(gridPane));

        // add button to grid pane
        gridPane.add(generateButton, 2, 7);

        // create image views for clothing items
         topImageView = new ImageView();
        topImageView.setFitWidth(250);
        topImageView.setFitHeight(300);
         bottomImageView = new ImageView();
        bottomImageView.setFitWidth(250);
        bottomImageView.setFitHeight(300);

        // add image views to grid pane
        gridPane.add(topImageView, 0, 12);
        gridPane.add(bottomImageView, 0, 13);

        // create stack pane to hold grid pane
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);

        // create scene
        Scene scene = new Scene(root, 700, 1000);

        // set stage properties
        primaryStage.setTitle("Outfit Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    /**
     * The method generateOutfit generates a random outfit from the arrays of 
     * top and bottom images.
     * The images are loaded from the resources folder and through the variable topImage and bottomImage.
     * The images are updated to the pane using topImageView and bottomImageView.
     * @param gridPane
     */

    private void generateOutfit(GridPane gridPane) {
        
         
        // create arrays of top and bottom image paths
        String[] shirtImagePaths = {"Shirt.png", "Shirt2.png", "Shirt3.png", "Shirt4.png", "Shirt5.png", "Shirt6.png"};
        String[] shortsImagePaths = {"Shorts.png", "Shorts2.png", "Shorts3.png", "Shorts4.png", "Shorts5.png", "Shorts6.png", "Shorts7.png"};
        String[] pantsImagePaths = {"Pants.png", "Pants2.png", "Pants3.png", "Pants4.png", "Pants5.png", "Pants6.png"};
        String[] jacketImagePaths = {"Jacket.png", "Jacket2.png", "Jacket3.png", "Jacket4.png", "Jacket5.png", "Jacket6.png"};

        String[] topImagePaths = {"Shirt.png", "Shirt2.png", "Shirt3.png", "Shirt4.png", "Shirt5.png", "Shirt6.png", "Jacket.png", "Jacket2.png", "Jacket3.png", "Jacket4.png", 
    "Jacket5.png", "Jacket6.png"};
        String[] bottomImagePaths = {"Shorts.png", "Pants.png", "Shorts2.png", "Pants2.png", "Shorts3.png", "Shorts4.png", "Shorts5.png", "Shorts6.png", "Shorts7.png", 
    "Pants3.png", "Pants4.png", "Pants5.png", "Pants6.png"};

        // create random number generator
        Random randomTop = new Random();
        Random randomBottom = new Random();

        // generate random top and bottom

        String topImagePath = topImagePaths[randomTop.nextInt(topImagePaths.length)];
        String bottomImagePath = bottomImagePaths[randomBottom.nextInt(bottomImagePaths.length)];
        

        
        // load clothing item images
        Image topImage = new Image(getClass().getResourceAsStream("/edu/guilford/" + topImagePath));
        Image bottomImage = new Image(getClass().getResourceAsStream("/edu/guilford/" + bottomImagePath));

        // update clothing item image views
       //  topImageView = (ImageView) gridPane.getChildren().get(1);
        topImageView.setImage(topImage);
        // bottomImageView = (ImageView) gridPane.getChildren().get(2);
        bottomImageView.setImage(bottomImage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}