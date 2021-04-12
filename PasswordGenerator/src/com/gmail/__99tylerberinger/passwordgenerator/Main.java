package com.gmail.__99tylerberinger.passwordgenerator;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    final SimpleStringProperty password = new SimpleStringProperty("✖✖✖✖✖✖✖✖✖✖✖✖");

    final int amountOfChunks = 3;
    final int charsPerChunk = 4;

    private final String[] leadingChars = {"abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789"};
    private final String trailingChars = "!@#$%^&*()-=_+";

    private String currentLeadingCharsSection = leadingChars[0];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Widgets
        final Button button = new Button("Generate Password");
        button.setOnMouseClicked(e -> generatePassword());

        final Label label = new Label();
        label.textProperty().bind(password);

        // Scene
        final Scene scene = new Scene(new VBox(button, label));
        scene.getStylesheets().add("Theme.css");

        // Stage
        primaryStage.setTitle("password-generator");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void generatePassword() {

        final StringBuilder stringBuilder = new StringBuilder(amountOfChunks * charsPerChunk);

        final Random random = new Random();

        for (int chunk = 0; chunk < amountOfChunks; chunk++) {

            // Get a new leadingChars section for the chunk
            String newLeadingCharsSection = currentLeadingCharsSection;
            while (newLeadingCharsSection == currentLeadingCharsSection) {
                newLeadingCharsSection = leadingChars[random.nextInt(leadingChars.length)];
            }
            currentLeadingCharsSection = newLeadingCharsSection;

            // Fill the chunk with the leadingChars and trailingChar
            for (int i = 0; i < charsPerChunk; i++) {

                if (i < (charsPerChunk - 1)) {

                    final char leadingChar = currentLeadingCharsSection.charAt(random.nextInt(currentLeadingCharsSection.length()));
                    stringBuilder.append(leadingChar);

                } else {

                    final char trailingChar = trailingChars.charAt(random.nextInt(trailingChars.length()));
                    stringBuilder.append(trailingChar);

                }

            }
        }

        password.set(stringBuilder.toString());

    }

}
