package edu.guilford;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;

public class OutfitGenerator extends Application {

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // create grid pane to hold buttons and images
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setStyle("-fx-background-color: lightblue;");


        

        // create button to generate outfit
        Button generateButton = new Button("Generate Outfit");
        generateButton.setOnAction(event -> generateOutfit(gridPane));

        // add button to grid pane
        gridPane.add(generateButton, 2, 0);

        // create image views for clothing items
        ImageView topImageView = new ImageView();
        topImageView.setFitWidth(300);
        topImageView.setFitHeight(350);
        ImageView bottomImageView = new ImageView();
        bottomImageView.setFitWidth(300);
        bottomImageView.setFitHeight(350);

        // add image views to grid pane
        gridPane.add(topImageView, 0, 1);
        gridPane.add(bottomImageView, 0, 2);

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

    private void generateOutfit(GridPane gridPane) {
         
        // create arrays of top and bottom image paths
        String[] topImagePaths = {"Shirt.png", "Jacket.png", "Shirt2.png", "Shirt3.png", "Shirt4.png", "Shirt5.png", "Shirt6.png", "Jacket2.png", "Jacket3.png", "Jacket4.png", 
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
        ImageView topImageView = (ImageView) gridPane.getChildren().get(1);
        topImageView.setImage(topImage);
        ImageView bottomImageView = (ImageView) gridPane.getChildren().get(2);
        bottomImageView.setImage(bottomImage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}