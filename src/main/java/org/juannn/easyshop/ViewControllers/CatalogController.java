package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;

public class CatalogController {

    // ImageViews
    @FXML
    private ImageView ImageProduct1;
    @FXML
    private ImageView ImageProduct2;
    @FXML
    private ImageView ImageProduct3;
    @FXML
    private ImageView ImageProduct4;
    @FXML
    private ImageView ImageProduct5;
    @FXML
    private ImageView ImageProduct6;

    // Buttons
    @FXML
    private Button addProduct1;
    @FXML
    private Button addProduct2;
    @FXML
    private Button addProduct3;
    @FXML
    private Button addProduct4;
    @FXML
    private Button addProduct5;
    @FXML
    private Button addProduct6;

    // Spinners
    @FXML
    private Spinner<Integer> quantityProduct1;
    @FXML
    private Spinner<Integer> quantityProduct2;
    @FXML
    private Spinner<Integer> quantityProduct3;
    @FXML
    private Spinner<Integer> quantityProduct4;
    @FXML
    private Spinner<Integer> quantityProduct5;
    @FXML
    private Spinner<Integer> quantityProduct6;

    @FXML
    public void initialize() {
        configureSpinner(quantityProduct1);
        configureSpinner(quantityProduct2);
        configureSpinner(quantityProduct3);
        configureSpinner(quantityProduct4);
        configureSpinner(quantityProduct5);
        configureSpinner(quantityProduct6);
    }

    private void configureSpinner(Spinner<Integer> spinner) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        spinner.setValueFactory(valueFactory);
    }
}
