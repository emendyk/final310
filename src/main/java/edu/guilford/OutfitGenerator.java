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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private ToggleGroup weatherGroup;
    private TextField tempTextField;
    private List<String> availableTopImagePaths;

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
        tempTextField = new TextField();
        tempTextField.setMaxWidth(50);
        tempTextField.setText(String.valueOf(DEFAULT_TEMP));
        gridPane.add(tempLabel, 0, 2);
        gridPane.add(tempTextField, 1, 2);
        // create label and radio buttons for weather conditions
        weatherGroup = new ToggleGroup();
        RadioButton sunnyButton = new RadioButton("Sunny");
        sunnyButton.setToggleGroup(weatherGroup);
        RadioButton cloudyButton = new RadioButton("Cloudy");
        cloudyButton.setToggleGroup(weatherGroup);
        RadioButton rainingButton = new RadioButton("Raining");
        rainingButton.setToggleGroup(weatherGroup);
        RadioButton windyButton = new RadioButton("Windy");
        windyButton.setToggleGroup(weatherGroup);
        gridPane.add(sunnyButton, 0, 4);
        gridPane.add(cloudyButton, 0, 5);
        gridPane.add(rainingButton, 0, 6);
        gridPane.add(windyButton, 0, 7);
        // create and add a label for the weather condition
        Label weatherLabel = new Label("Weather Condition:");
        gridPane.add(weatherLabel, 0, 3);
        // create and add a button to generate the outfit
        Button generateButton = new Button("Generate Outfit");
        generateButton.setOnAction(event -> generateOutfit(gridPane));
        gridPane.add(generateButton, 2, 7);
        // set the Image View and size of the top and bottom images
        topImageView = new ImageView();
        topImageView.setFitWidth(250);
        topImageView.setFitHeight(300);

        bottomImageView = new ImageView();
        bottomImageView.setFitWidth(250);
        bottomImageView.setFitHeight(300);
        // place the top and bottom images on the grid pane
        gridPane.add(topImageView, 0, 12);
        gridPane.add(bottomImageView, 0, 13);

        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        // create a scene and place it in the stage
        Scene scene = new Scene(root, 700, 1000);
        primaryStage.setTitle("Outfit Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
//      * The method generateOutfit generates a random outfit from the arrays of 
//      * top and bottom images.
//      * The images are loaded from the resources folder and through the variable topImage and bottomImage.
//      * The images are updated to the pane using topImageView and bottomImageView.
//      * @param gridPane
         */

    private void generateOutfit(GridPane gridPane) {
        // arrays of the top and bottom images
        String[] shirtImagePaths = {"Shirt.png", "Shirt2.png", "Shirt3.png", "Shirt4.png", "Shirt5.png", "Shirt6.png"};
        String[] shortsImagePaths = {"Shorts.png", "Shorts2.png", "Shorts3.png", "Shorts4.png", "Shorts5.png", "Shorts6.png", "Shorts7.png"};
        String[] pantsImagePaths = {"Pants.png", "Pants2.png", "Pants3.png", "Pants4.png", "Pants5.png", "Pants6.png"};
        String[] jacketImagePaths = {"Jacket.png", "Jacket2.png", "Jacket3.png", "Jacket4.png", "Jacket5.png", "Jacket6.png"};
        // get the input from the user
        RadioButton selectedWeatherButton = (RadioButton) weatherGroup.getSelectedToggle();
        String selectedWeather = selectedWeatherButton.getText();
        int temperature = Integer.parseInt(tempTextField.getText());
        // store the top and bottom image paths in a list
        List<String> availableTopImagePaths = new ArrayList<>();
        List<String> availableBottomImagePaths = new ArrayList<>();
        // if the temperature is greater than 60 and the weather is sunny or cloudy the outfit will be shorts and a shirt
        // if the temperature is between 60 and 70 and the weather is windy or raining the outfit will be shorts and a jacket
        // if the temperature is between 70 and 150 the outfit will be pants and a jacket
        if (temperature > 60) {
            if (selectedWeather.equals("Sunny") || selectedWeather.equals("Cloudy")) {
                availableTopImagePaths.addAll(Arrays.asList(shirtImagePaths));
                availableBottomImagePaths.addAll(Arrays.asList(shortsImagePaths));
            } else if ((temperature > 60 && temperature < 70) && (selectedWeather.equals("Windy") || selectedWeather.equals("Raining"))) {
                availableTopImagePaths.addAll(Arrays.asList(jacketImagePaths));
                availableBottomImagePaths.addAll(Arrays.asList(shortsImagePaths));
            } else {
                availableTopImagePaths.addAll(Arrays.asList(jacketImagePaths));
                availableBottomImagePaths.addAll(Arrays.asList(pantsImagePaths));
            }
        } else {
            availableTopImagePaths.addAll(Arrays.asList(jacketImagePaths));
            availableBottomImagePaths.addAll(Arrays.asList(pantsImagePaths));
        }
        // pick a random image from the list
        Random randomTop = new Random();
        Random randomBottom = new Random();
        String topImagePath = availableTopImagePaths.get(randomTop.nextInt(availableTopImagePaths.size()));
        String bottomImagePath = availableBottomImagePaths.get(randomBottom.nextInt(availableBottomImagePaths.size()));

        Image topImage = new Image(getClass().getResourceAsStream(topImagePath));
        Image bottomImage = new Image(getClass().getResourceAsStream(bottomImagePath));

        topImageView.setImage(topImage);
        bottomImageView.setImage(bottomImage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

