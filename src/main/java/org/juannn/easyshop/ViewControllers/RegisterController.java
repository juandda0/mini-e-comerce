package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.persistencia.BBDD;

public class RegisterController {

    @FXML
    private TextField txt_Email;  // Campo de texto para el correo electrónico

    @FXML
    private TextField txt_UserName;  // Campo de texto para el nombre de usuario

    @FXML
    private PasswordField txt_Password;  // Campo para la contraseña del usuario

    @FXML
    private PasswordField txt_ConfirmPassword;  // Campo para confirmar la contraseña

    @FXML
    private JFXButton btn_Register;  // Botón para registrar al usuario

    @FXML
    private JFXButton btn_SingIn;  // Botón para ir a la pantalla de inicio de sesión

    @FXML
    public void initialize() {
        // Navegar al login cuando se haga clic en "Iniciar sesión"
        btn_SingIn.setOnAction(event -> Navigator.navigateTo("login"));

        // Manejar el evento del botón de registro
        btn_Register.setOnAction(event -> handleRegisterAction());
    }

    @FXML
    private void handleRegisterAction() {
        // Obtener los valores de los campos
        String email = txt_Email.getText();
        String userName = txt_UserName.getText();
        String password = txt_Password.getText();
        String confirmPassword = txt_ConfirmPassword.getText();

        // Verificar que los campos no estén vacíos
        if (email.isEmpty() || userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert("Error", "Por favor, ingrese todos los campos.");
            return;
        }

        // Verificar que las contraseñas coincidan
        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Las contraseñas no coinciden.");
            return;
        }

        // Intentar registrar el usuario
        boolean registroExitoso = BBDD.registrar(userName, email, password);

        // Mostrar mensaje de éxito o error
        if (registroExitoso) {
            showAlert("Éxito", "Usuario registrado exitosamente.");
            Navigator.navigateTo("login");  // Navegar al login después de registrar
        } else {
            showAlert("Error", "El correo electrónico ya está registrado.");
        }
    }

    // Método para mostrar alertas con mensajes personalizados
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
