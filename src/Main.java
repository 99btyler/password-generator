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

        VBox layout = new VBox();
        layout.getChildren().addAll(button, label);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();

    }

}
