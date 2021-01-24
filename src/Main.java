import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("password-generator");

        Button button = new Button("Generate Password");

        Label label = new Label("...");
        label.setPadding(new Insets(10, 0, 0, 0));
        label.setFont(new Font(25));

        VBox layout = new VBox();
        layout.setPadding(new Insets(100, 100, 100, 100));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button, label);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();

    }

}
