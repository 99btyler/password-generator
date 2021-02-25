import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private final Button button = new Button("Generate Password");
    private final Label label = new Label("✖✖✖✖✖✖✖✖✖✖✖✖");

    private final String pLettersLower = "abcdefghijklmnopqrstuvwxyz";
    private final String pLettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String pNumbers = "0123456789";
    private final String pSpecialCharacters = "!@#$%^&*()-=_+";

    private final Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("password-generator");
        primaryStage.setResizable(false);

        button.setOnMouseClicked(e -> generatePassword());

        // Set layout
        final VBox layout = new VBox();
        layout.getChildren().addAll(button, label);

        // Set scene
        final Scene scene = new Scene(layout);
        scene.getStylesheets().add("Theme.css");

        // Display it
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void generatePassword() {

        final int amountOfChunks = 3; // algorithm expects 3 or less
        final int charsPerChunk = 4; // best if 2 or greater

        final StringBuilder stringBuilder = new StringBuilder(amountOfChunks * charsPerChunk);

        for (int chunk = 0; chunk < amountOfChunks; chunk++) {
            for (int i = 0; i < charsPerChunk; i++) {

                switch (chunk) {

                    case 0:

                        if (i == charsPerChunk - 1) {
                            stringBuilder.append(getRandomChar(pNumbers));
                        } else {
                            stringBuilder.append(getRandomChar(pLettersUpper));
                        }

                        break;

                    case 1:

                        if (i == charsPerChunk - 1) {
                            stringBuilder.append(getRandomChar(pSpecialCharacters));
                        } else {
                            stringBuilder.append(getRandomChar(pLettersLower));
                        }

                        break;

                    case 2:

                        if (i == charsPerChunk - 1) {
                            stringBuilder.append(getRandomChar(pSpecialCharacters));
                        } else {
                            stringBuilder.append(getRandomChar(pLettersUpper));
                        }

                        break;

                    default:
                        // amountOfChunks is greater than 3
                        stringBuilder.append("✖");
                        break;

                }

            }
        }

        label.setText(stringBuilder.toString());

    }

    private Character getRandomChar(String string) {
        return string.charAt(random.nextInt(string.length()));
    }

}
