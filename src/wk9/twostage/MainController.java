package wk9.twostage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {
    private Stage otherStage;
    private SecondaryController otherController;

    @FXML
    private Pane mainGrid;

    public void setOtherStage(Stage otherStage) {
        this.otherStage = otherStage;
    }

    public void setOtherController(SecondaryController otherController) {
        this.otherController = otherController;
    }

    public void showOther(ActionEvent actionEvent) {
        if (otherStage.isShowing())
            otherStage.hide();
        else {
            Stage myStage = (Stage)mainGrid.getScene().getWindow();
            otherStage.setX(myStage.getX());
            otherStage.setY(myStage.getY() + myStage.getHeight());
            otherStage.setWidth(myStage.getWidth());
            otherStage.show();
        }
    }

    public void setMainGrid(Pane mainGrid) {
        this.mainGrid = mainGrid;
    }
}
