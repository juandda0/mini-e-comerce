package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.juannn.easyshop.Navigator;

public class LoginController {

    // Campos de texto para el login
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;

    // Botones para login y registro
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegist;

    @FXML
    public void initialize() {
        btnRegist.setOnAction(event -> Navigator.navigateTo("regist"));
        btnLogin.setOnAction(event -> Navigator.navigateTo("catalog"));
    }

    // Método para manejar la acción del botón de Login
    @FXML
    private void handleLoginAction() {
        String user = txtUser.getText();
        String password = txtPassword.getText();

        // Lógica para autenticar al usuario
        if (authenticate(user, password)) {
            // Lógica de éxito (por ejemplo, redirigir a la página principal)
        } else {
            // Lógica de error (mostrar mensaje de error)
        }
    }


    // Método de ejemplo para autenticar al usuario (deberías reemplazarlo con tu lógica real)
    private boolean authenticate(String user, String password) {
        // Aquí va la lógica de autenticación
        return user.equals("admin") && password.equals("1234");  // Ejemplo de autenticación simple
    }
}
