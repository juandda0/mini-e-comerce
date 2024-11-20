package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.juannn.easyshop.Navigator;

public class MainController {


    @FXML
    private Button btnBack;

    public MainController(){

    }
    @FXML
    public void initialize() {
        btnBack.setOnAction(event -> Navigator.navigateTo("welcome"));
    }

}
