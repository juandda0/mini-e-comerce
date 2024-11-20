package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductController {

    @FXML
    private Label lbl_category;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_price;

    private static ProductController instance;

    @FXML
    public void initialize() {

        instance = this;
        cbx_quantity.setPromptText("Quantity");
        cbx_quantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    // Método estático para actualizar los detalles del producto
    public static void setProductDetails(String category, String name, String price) {
        if (instance != null) {
            instance.lbl_category.setText(category);
            instance.lbl_name.setText(name);
            instance.lbl_price.setText(price);
        }
    }

    @FXML
    JFXComboBox<String> cbx_quantity;

}
