package wk5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class SimpleGUI extends Application {

    private Label label;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new StackPane();
        label = new Label("Here is some text that can be manipulated with the button above.");
        Button clickMe = new Button("Click Me");
        clickMe.setOnAction(this::clickHandler);
        root.getChildren().addAll(label, clickMe);

        primaryStage.setTitle("Simple GUI");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    private void clickHandler(ActionEvent event) {
        if (label.getEffect() == null) {
            label.setEffect(new BoxBlur());
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Remove blur.");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get()==ButtonType.OK) {
                label.setEffect(null);
            }
        }
    }
}