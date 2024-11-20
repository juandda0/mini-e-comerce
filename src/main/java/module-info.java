module org.juannn.easyshop {

    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;


    requires org.kordamp.ikonli.bootstrapicons;
    requires org.kordamp.ikonli.carbonicons;

    requires com.jfoenix;

    opens org.juannn.easyshop to javafx.fxml;
    exports org.juannn.easyshop;
    exports org.juannn.easyshop.ViewControllers;
    exports org.juannn.easyshop.Main;
    opens org.juannn.easyshop.ViewControllers to javafx.fxml;
    opens org.juannn.easyshop.Main to javafx.fxml;
}