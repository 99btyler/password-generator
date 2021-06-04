package com.gmail.__99tylerberinger.passwordgenerator;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    final SimpleStringProperty password = new SimpleStringProperty("✖✖✖✖✖✖✖✖");

    private final String[] leadingChars = {"abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789"};
    private String currentLeadingChars = leadingChars[0];

    private final String trailingChars = "!@#$%^&*()-=_+";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Widgets
        final Label labelPassword = new Label();
        labelPassword.textProperty().bind(password);

        final Label labelAmountOfChunks = new Label("amount of chunks:");
        final Spinner<Integer> spinnerAmountOfChunks = new Spinner<>(2, 10, 3, 1);

        final Label labelCharsPerChunk = new Label("chars per chunk:");
        final Spinner<Integer> spinnerCharsPerChunk = new Spinner<>(3, 10, 4, 1);

        final Button buttonGenerate = new Button("GENERATE");
        buttonGenerate.setOnMouseClicked(e -> generate(spinnerAmountOfChunks.getValue(), spinnerCharsPerChunk.getValue()));

        // Scene
        final Scene scene = new Scene(new VBox(labelPassword, labelAmountOfChunks, spinnerAmountOfChunks, labelCharsPerChunk, spinnerCharsPerChunk, buttonGenerate));
        // TODO: scene.getStylesheets().add("Theme.css");

        // Stage
        primaryStage.setTitle("password-generator");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void generate(int amountOfChunks, int charsPerChunk) {

        final StringBuilder stringBuilder = new StringBuilder(amountOfChunks * charsPerChunk);
        final Random random = new Random();

        for (int chunk = 0; chunk < amountOfChunks; chunk++) {

            // Get a new leadingChars section for the chunk
            String newCurrentLeadingChars = currentLeadingChars;
            while (newCurrentLeadingChars == currentLeadingChars) {
                newCurrentLeadingChars = leadingChars[random.nextInt(leadingChars.length)];
            }
            currentLeadingChars = newCurrentLeadingChars;

            // Fill the chunk with the leadingChars and trailingChar
            for (int i = 0; i < charsPerChunk; i++) {

                if (i < (charsPerChunk - 1)) {

                    final char leadingChar = currentLeadingChars.charAt(random.nextInt(currentLeadingChars.length()));
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
