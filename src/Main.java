import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static Button button;
    private static Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("password-generator");

        button = new Button("Generate Password");

        label = new Label("aaa0aaa#aaa0");

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

}
