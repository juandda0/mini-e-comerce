package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.juannn.easyshop.Navigator;

public class WelcomeController {

    @FXML
    private Button btnStart;

    public WelcomeController() {
    }

    @FXML
    public void initialize(){
        btnStart.setOnAction(event -> Navigator.navigateTo("catalog"));
    }
}
