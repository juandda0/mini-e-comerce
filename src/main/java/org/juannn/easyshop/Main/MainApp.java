package org.juannn.easyshop.Main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.juannn.easyshop.Navigator;

public class MainApp extends Application {

        @Override
        public void start(Stage primaryStage) {
            Navigator.setMainStage(primaryStage);
            Navigator.initialize();
            Navigator.navigateTo("login");
        }

        public static void main(String[] args) {
            launch(args);
        }

}

