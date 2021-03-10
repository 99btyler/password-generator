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
    private String currentCoreType = coreTypes[0];

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

            String newCoreType = currentCoreType;
            while (newCoreType == currentCoreType) {
                newCoreType = coreTypes[random.nextInt(coreTypes.length)];
            }
            currentCoreType = newCoreType;

            for (int i = 0; i < charsPerChunk; i++) {

                if (i == (charsPerChunk - 1)) {

                    final char etChar = endType.charAt(random.nextInt(endType.length()));
                    stringBuilder.append(etChar);

                } else {

                    final char ctChar = currentCoreType.charAt(random.nextInt(currentCoreType.length()));
                    stringBuilder.append(ctChar);

                }

            }
        }

        password.set(stringBuilder.toString());

    }

}
