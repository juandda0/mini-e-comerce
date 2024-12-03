package org.juannn.easyshop.Main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.juannn.easyshop.Navigator;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Se asigna el Stage principal a la clase Navigator para poder usarlo más tarde
        Navigator.setMainStage(primaryStage);

        // Inicializamos las rutas de las vistas disponibles
        Navigator.initialize();

        // Al iniciar la aplicación, se navega automáticamente a la vista de bienvenida
        Navigator.navigateTo("welcome");
    }

    // Método main que ejecuta la aplicación JavaFX
    public static void main(String[] args) {
        launch(args);
    }
}
