import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private static Button button = new Button("Generate Password");
    private static Label label = new Label("...");

    private final String pLettersLower = "abcdefghijklmnopqrstuvwxyz";
    private final String pLettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String pNumbers = "0123456789";
    private final String pSpecialCharacters = "-=[];,./~!@#$%^&*()_+{}:<>?";

    private final Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("password-generator");

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

        // Default: AAA0aaa-AAA-

        StringBuilder stringBuilder = new StringBuilder(12);

        for (int i = 0; i < stringBuilder.capacity(); i+=4) {
            for (int ii = 0; ii < 4; ii++) {

                if (ii == 3) {

                    if (i == 0) {
                        stringBuilder.append(pNumbers.charAt(random.nextInt(pNumbers.length())));
                    } else {
                        stringBuilder.append(pSpecialCharacters.charAt(random.nextInt(pSpecialCharacters.length())));
                    }

                } else {

                    if (i == 4) {
                        stringBuilder.append(pLettersLower.charAt(random.nextInt(pLettersLower.length())));
                    } else {
                        stringBuilder.append(pLettersUpper.charAt(random.nextInt(pLettersUpper.length())));
                    }

                }

            }
        }

        label.setText(stringBuilder.toString());

    }

}
