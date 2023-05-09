
package edu.guilford;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;

/**
 * The OutfitGenerator class generates a random outfit based on the user's temperature input.
 * If the temperature is above 60, a shirt and shorts are worn. If the temperature is below 60,
 * a jacket and pants are worn.
 */
public class OutfitGenerator extends Application {

    private static final int MIN_TEMP = 0;
    private static final int MAX_TEMP = 100;
    private static final int DEFAULT_TEMP = 70;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create grid pane to hold input, button, and images
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setAlignment(Pos.CENTER);

        


        // create label and text field for temperature input
        Label tempLabel = new Label("Temperature:");
        TextField tempTextField = new TextField();
        tempTextField.setText(String.valueOf(DEFAULT_TEMP));

        // add label and text field to grid pane
        gridPane.add(tempLabel, 0, 0);
        gridPane.add(tempTextField, 1, 0);

        // create button to generate outfit
        Button generateButton = new Button("Generate Outfit");
        generateButton.setOnAction(event -> generateOutfit(gridPane, tempTextField));

        // add button to grid pane
        gridPane.add(generateButton, 0, 1, 2, 1);

        // create image views for top and bottom clothing items
        ImageView topImageView = new ImageView();
        topImageView.setFitWidth(15);
        topImageView.setFitHeight(20);

        ImageView bottomImageView = new ImageView();
        bottomImageView.setFitWidth(15);
        bottomImageView.setFitHeight(20);

        // add image views to grid pane
        gridPane.add(topImageView, 0, 1);
        gridPane.add(bottomImageView, 1, 1);

        // create stack pane to hold grid pane
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);

        // create scene
        Scene scene = new Scene(root, 700, 500);

        // set stage properties
        primaryStage.setTitle("Outfit Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Generates an outfit based on the user's temperature input.
     *
     * @param gridPane      the grid pane that holds the input, button, and images
     * @param tempTextField the text field that holds the user's temperature input
     */
    private void generateOutfit(GridPane gridPane, TextField tempTextField) {
        // get temperature input from text field
        int temp = DEFAULT_TEMP;
        try {
            temp = Integer.parseInt(tempTextField.getText());
        } catch (NumberFormatException e) {
            // if temperature input is not a number, use default value
            temp = DEFAULT_TEMP;
        }
    
        // create arrays of top and bottom clothing item image paths
        String[] shirtImagePaths = {"Shirt.png"}; //"Shirt2.png", "Shirt3.png"};
        String[] jacketImagePaths = {"Jacket.png"}; //"Jacket2.png", "Jacket3.png"};
        String[] shortsImagePaths = {"Shorts.png"}; // "Shorts2.png", "Shorts3.png"};
        String[] pantsImagePaths = {"Pants.png"}; //"Pants2.png", "Pants3.png"};
    
        // create random number generators
        Random randomTop = new Random();
        Random randomBottom = new Random();
    
        // initialize top and bottom clothing item image paths
        String topImagePath = "";
        String bottomImagePath = "";
    
        // check temperature and select top and bottom clothing items accordingly
        if (temp >= 60) {
            topImagePath = shirtImagePaths[randomTop.nextInt(shirtImagePaths.length)];
            bottomImagePath = shortsImagePaths[randomBottom.nextInt(shortsImagePaths.length)];
        } else {
            topImagePath = jacketImagePaths[randomTop.nextInt(jacketImagePaths.length)];
            bottomImagePath = pantsImagePaths[randomBottom.nextInt(pantsImagePaths.length)];
        }
    
        // load top and bottom clothing item images
        Image topImage = new Image(getClass().getResourceAsStream("/edu/guilford/" + topImagePath));
        Image bottomImage = new Image(getClass().getResourceAsStream("/edu/guilford/" + bottomImagePath));
    
        // update top and bottom clothing item image views
        ImageView topImageView = new ImageView(topImage);
        ImageView bottomImageView = new ImageView(bottomImage);
        gridPane.getChildren().set(1, topImageView);
        gridPane.getChildren().set(2, bottomImageView);
    }
    
    /**
     * The main method launches the OutfitGenerator application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

