package wk9.twostage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader mainLoader = new FXMLLoader();
        Parent root = mainLoader.load(getClass().getResource("mainstage.fxml").openStream());
        primaryStage.setTitle("Main Stage");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        MainController mainController = mainLoader.getController();
        mainController.setMainGrid((Pane)root);

        FXMLLoader secondaryLoader = new FXMLLoader();
        Stage secondaryStage = new Stage();
        Parent secondaryRoot =
                secondaryLoader.load(getClass().getResource("secondarystage.fxml").openStream());
        SecondaryController secondaryController = secondaryLoader.getController();
        secondaryStage.setTitle("OtherWin");
        secondaryStage.setScene(new Scene(secondaryRoot));
        secondaryStage.hide();

        mainController.setOtherStage(secondaryStage);
        mainController.setOtherController(secondaryController);

        secondaryController.setMainStage(primaryStage);
        secondaryController.setMainController(mainController);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
