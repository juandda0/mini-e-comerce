package org.juannn.easyshop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private static Stage mainStage;
    private static final Map<String, String> viewMap = new HashMap<>();

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public static void initialize(){
        viewMap.put("welcome", "/org/juannn/easyshop/WelcomeView.fxml");
        viewMap.put("catalog", "/org/juannn/easyshop/CatalogView.fxml");
        viewMap.put("user", "/org/juannn/easyshop/UserView.fxml");
        viewMap.put("login", "/org/juannn/easyshop/LoginView.fxml");
        viewMap.put("regist", "/org/juannn/easyshop/RegisterView.fxml");
        viewMap.put("product", "/org/juannn/easyshop/ProductView.fxml");
    }

    public static void navigateTo(String viewName) {
        String fxmlPath = viewMap.get(viewName);

        if (fxmlPath == null) {
            throw new IllegalArgumentException("No such view: " + viewName);
        }

        try {
            Parent view = FXMLLoader.load(Navigator.class.getResource(fxmlPath));
            mainStage.setScene(new Scene(view));
            mainStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
