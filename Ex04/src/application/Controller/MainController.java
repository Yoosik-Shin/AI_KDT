package application.Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnList;

    @FXML
    void exit(ActionEvent event) {
    	Main.exit();
    }

    @FXML
    void list(ActionEvent event) throws Exception {
    	Main.setRoot("UI/List");
    }

}
