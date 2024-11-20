package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.data.BBDD;

public class RegisterController {

    // Campos de texto y contraseñas
    @FXML
    private TextField txt_Email;

    @FXML
    private TextField txt_UserName;

    @FXML
    private PasswordField txt_Password;

    @FXML
    private PasswordField txt_ConfirmPassword;

    // Botones
    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_SingIn;

    @FXML
    public void initialize() {
        btn_SingIn.setOnAction(event -> Navigator.navigateTo("login"));
        btn_Register.setOnAction(event -> handleRegisterAction());
    }

    @FXML
    private void handleRegisterAction() {
        String nombre = txt_UserName.getText();
        String email = txt_Email.getText();
        String contrasena = txt_Password.getText();
        String confirmContrasena = txt_ConfirmPassword.getText();

        if (!contrasena.equals(confirmContrasena)) {
            showAlert("Error", "Las contraseñas no coinciden.");
            return;
        }

        boolean registrado = BBDD.registrarUsuario(nombre, email, contrasena);

        if (registrado) {
            showAlert("Éxito", "Usuario registrado exitosamente.");
            Navigator.navigateTo("login"); // Navegar a login
        } else {
            showAlert("Error", "El correo electrónico ya está registrado.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
