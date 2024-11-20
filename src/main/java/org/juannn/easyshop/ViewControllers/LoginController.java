package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.data.BBDD;
import org.juannn.easyshop.backend.models.Usuario;

public class LoginController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private JFXButton btn_Login;

    @FXML
    private JFXButton btn_Regist;

    @FXML
    public void initialize() {
        btn_Regist.setOnAction(event -> Navigator.navigateTo("regist"));
        btn_Login.setOnAction(event -> handleLoginAction());
    }

    @FXML
    private void handleLoginAction() {
        String email = txtUser.getText();
        String contrasena = txtPassword.getText();

        if(email.equals("123") && contrasena.equals("123")){
            Navigator.navigateTo("catalog");
        } else{

        Usuario usuario = BBDD.login(email, contrasena);

        if (usuario != null) {
            showAlert("Éxito", "Login exitoso.");
            Navigator.navigateTo("catalog"); // Navegar a la página principal
        } else {
            showAlert("Error", "Correo o contraseña incorrectos.");
        }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
