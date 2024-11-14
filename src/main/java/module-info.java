module org.juannn.easyshop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens org.juannn.easyshop to javafx.fxml;
    exports org.juannn.easyshop;
    exports org.juannn.easyshop.ViewControllers;
    exports org.juannn.easyshop.Main;
    opens org.juannn.easyshop.ViewControllers to javafx.fxml;
    opens org.juannn.easyshop.Main to javafx.fxml;
}