package wk5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Optional;

public class Teenager extends Application {

    private Label response;
    private TextField input;
    public static final int HEIGHT = 200;
    public static final int WIDTH = 350;
    @Override
    public void start(Stage stage) {
        response = new Label();
        input = new TextField();
        input.setOnAction(this::handleInput);
        Button clear = new Button("Clear");
        clear.setOnAction(this::handleClear);
        GridPane pane = new GridPane();
        pane.add(new Label("Please enter your age: "), 0, 0);
        pane.add(input, 0, 1);
        pane.add(response, 1, 2);
        pane.add(clear, 2, 0);
        stage.setScene(new Scene(pane, WIDTH, HEIGHT));
        stage.show();
    }

    private void handleClear(ActionEvent event) {
        response.setText("");
        input.setText("");
    }

    private void handleInput(ActionEvent event) {
        String text = ((TextField)event.getSource()).getText();
        int age = -1;
        try {
            age = Integer.parseInt(text);
        } catch(NumberFormatException exception) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Invalid input");
            dialog.setHeaderText("invalid input");
            Optional<String> result = dialog.showAndWait();
            if(result.isPresent()) {
                String response = result.get();
                input.setText(response);
                age = Integer.parseInt(response);
            }
        }
        String not = "";
        if (age < 13 || age > 19) {
            not = "not ";
        }
        response.setText("You are " + not + "a teenager.");
    }

}
