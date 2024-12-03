package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.models.Usuario;
import org.juannn.easyshop.backend.persistencia.BBDD;

public class LoginController {

    @FXML
    private TextField txtUser;  // Field to enter the username (email)

    @FXML
    private PasswordField txtPassword;  // Field to enter the password

    @FXML
    private JFXButton btn_Login;  // Button to log in

    @FXML
    private JFXButton btn_Regist;  // Button to navigate to the registration form

    @FXML
    public void initialize() {
        // Configure button events
        btn_Regist.setOnAction(event -> Navigator.navigateTo("regist"));  // Navigate to the registration page
        btn_Login.setOnAction(event -> handleLoginAction());  // Call the method to handle login
    }

    @FXML
    private void handleLoginAction() {
        // Get the entered credentials
        String email = txtUser.getText();
        String contrasena = txtPassword.getText();

        // Check that fields are not empty
        if (email.isEmpty() || contrasena.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill out all fields.");
            return;
        }

        // Try to log in with the provided credentials
        Usuario usuario = BBDD.login(email, contrasena);

        // Check if the credentials are correct
        if (usuario != null) {
            // Successful login
            showAlert(Alert.AlertType.INFORMATION, "Success", "Login successful.");
            Navigator.navigateTo("catalog");  // Navigate to the main page
        } else {
            // Failed login
            showAlert(Alert.AlertType.ERROR, "Error", "Incorrect email or password.");
        }
    }

    // Method to display alerts
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
<