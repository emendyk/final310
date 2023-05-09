
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

        // create button to generate outfit
        Button generateButton = new Button("Generate Outfit");
        generateButton.setOnAction(event -> generateOutfit(gridPane));

        // add button to grid pane
        gridPane.add(generateButton, 0, 0);

        // create image views for clothing items
        ImageView topImageView = new ImageView();
        topImageView.setFitWidth(150);
        topImageView.setFitHeight(200);
        ImageView bottomImageView = new ImageView();
        bottomImageView.setFitWidth(150);
        bottomImageView.setFitHeight(200);

        // add image views to grid pane
        gridPane.add(topImageView, 0, 1);
        gridPane.add(bottomImageView, 1, 1);

        // create stack pane to hold grid pane
        StackPane root = new StackPane();
        root.getChildren().add(gridPane);

        // create scene
        Scene scene = new Scene(root, 400, 500);

        // set stage properties
        primaryStage.setTitle("Outfit Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateOutfit(GridPane gridPane) {
        // create arrays of top and bottom image paths
        String[] topImagePaths = {"Shirt.png", "Jacket.png"};
        String[] bottomImagePaths = {"Shorts.png", "Pants.png"};

        // create random number generator
        Random random = new Random();

        // generate random top and bottom
        String topImagePath = topImagePaths[random.nextInt(topImagePaths.length)];
        String bottomImagePath = bottomImagePaths[random.nextInt(bottomImagePaths.length)];

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

