package wk5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleGUI extends Application implements EventHandler<ActionEvent> {

    private Label label;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new StackPane();
        label = new Label("Here is some text that can be manipulated with the button above.");
        Button clickMe = new Button("Click Me");
        clickMe.setOnAction(this);
        root.getChildren().addAll(label, clickMe);

        primaryStage.setTitle("Simple GUI");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(label.getEffect()==null) {
            label.setEffect(new BoxBlur());
        } else {
            label.setEffect(null);
        }
    }
}