package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.juannn.easyshop.Navigator;

public class RegisterController {

    // Campos de texto y contraseñas
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;

    // Botones
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnBack;

    @FXML
    public void initialize() {
        btnBack.setOnAction(event -> Navigator.navigateTo("login"));
    }

    @FXML
    private void handleRegisterAction() {
    }

    // Método de ejemplo para manejar la acción del botón de retroceso
    @FXML
    private void handleBackAction() {
        // Lógica para regresar a la vista anterior
    }
}
