package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.juannn.easyshop.Navigator;

public class WelcomeController {

    @FXML
    private JFXButton btn_Start;

    public WelcomeController() {
    }

    @FXML
    public void initialize(){
        btn_Start.setOnAction(event -> Navigator.navigateTo("login"));
    }
}
