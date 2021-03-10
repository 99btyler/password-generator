import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private final String[] coreTypes = {"abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789"};
    private final String endType = "!@#$%^&*()-=_+";
    private final Random random = new Random();

    final SimpleStringProperty password = new SimpleStringProperty("✖✖✖✖✖✖✖✖✖✖✖✖");

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

        final int amountOfChunks = 3;
        final int charsPerChunk = 4;
        final StringBuilder stringBuilder = new StringBuilder(amountOfChunks * charsPerChunk);

        for (int chunk = 0; chunk < amountOfChunks; chunk++) {

            final String randomCoreType = coreTypes[random.nextInt(coreTypes.length)];

            for (int i = 0; i < charsPerChunk; i++) {

                if (i == (charsPerChunk - 1)) {

                    final char randomEndTypeChar = endType.charAt(random.nextInt(endType.length()));
                    stringBuilder.append(randomEndTypeChar);

                } else {

                    final char randomCoreTypeChar = randomCoreType.charAt(random.nextInt(randomCoreType.length()));
                    stringBuilder.append(randomCoreTypeChar);

                }

            }
        }

        password.set(stringBuilder.toString());

    }

}
