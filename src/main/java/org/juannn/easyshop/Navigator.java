package org.juannn.easyshop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Navigator {

    // Stage principal de la aplicación. Este es el contenedor de la ventana donde se cargan las vistas.
    private static Stage mainStage;

    // Mapa que guarda los nombres de las vistas y sus rutas correspondientes en archivos FXML.
    private static final Map<String, String> viewMap = new HashMap<>();

    // Método para asignar el Stage principal (ventana principal) de la aplicación.
    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    // Método para inicializar el mapa con los nombres de vistas y sus rutas FXML
    public static void initialize(){
        // Aquí se definen las vistas disponibles en la aplicación y sus rutas FXML asociadas
        viewMap.put("welcome", "/org/juannn/easyshop/WelcomeView.fxml");
        viewMap.put("catalog", "/org/juannn/easyshop/CatalogView.fxml");
        viewMap.put("user", "/org/juannn/easyshop/UserView.fxml");
        viewMap.put("login", "/org/juannn/easyshop/LoginView.fxml");
        viewMap.put("regist", "/org/juannn/easyshop/RegisterView.fxml");
        viewMap.put("product", "/org/juannn/easyshop/ProductView.fxml");
        viewMap.put("cart", "/org/juannn/easyshop/CartView.fxml");
        viewMap.put("wish", "/org/juannn/easyshop/WishList.fxml");
        viewMap.put("history", "/org/juannn/easyshop/PurchaseHistory.fxml");
    }

    // Método que se encarga de cargar y mostrar la vista correspondiente
    public static void navigateTo(String viewName) {
        // Se obtiene la ruta FXML correspondiente al nombre de la vista
        String fxmlPath = viewMap.get(viewName);

        // Si no se encuentra la vista en el mapa, se lanza una excepción
        if (fxmlPath == null) {
            throw new IllegalArgumentException("No such view: " + viewName);
        }

        try {
            // Cargamos el archivo FXML de la vista
            Parent view = FXMLLoader.load(Navigator.class.getResource(fxmlPath));

            // Establecemos la nueva escena (Scene) con la vista cargada y mostramos la ventana
            mainStage.setScene(new Scene(view));
            mainStage.show();
        } catch (IOException e){
            // Si hay un error al cargar la vista, lo imprimimos en la consola
            e.printStackTrace();
        }
    }
}
