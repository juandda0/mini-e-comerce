package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class CatalogController {

    @FXML
    private GridPane catalogGrid;

    @FXML
    private Button addProduct;

    @FXML
    private JFXComboBox<String> categoryComboBox;

    //FONTS
    Font fontProductName = Font.font("Segoe UI Semibold", FontWeight.NORMAL, FontPosture.REGULAR, 16);
    Font fontPrice = Font.font("Segoe UI SemiLight", FontWeight.NORMAL, FontPosture.REGULAR, 14);

    // Lista de productos persistente (temporal)
    private final List<Producto> productos = new ArrayList<>();

    @FXML
    public void initialize() {

        categoryComboBox.setPromptText("Select a category");

        categoryComboBox.getItems().addAll("All categories", "Clothing", "Books", "Toys");
        productos.addAll(getMockProductos());
        updateCatalog();

        addProduct.setOnAction(event -> {
            Producto nuevoProducto = new Producto(
                    productos.size() + 1,
                    "product " + (productos.size() + 1),
                    500,
                    "Images/64521603-suéter-para-la-ropa-aislada-en-el-fondo-blanco.jpg",
                    "Category" + (productos.size() + 1)
            );

            productos.add(nuevoProducto);
            updateCatalog();
        });
    }

    private void configureSpinner(Spinner<Integer> spinner) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        spinner.setValueFactory(valueFactory);
    }

    private void updateCatalog() {
        catalogGrid.getChildren().clear();

        catalogGrid.setHgap(10);
        catalogGrid.setVgap(10);
        catalogGrid.setPadding(new Insets(10));

        int columna = 0, fila = 0;

        for (Producto producto : productos) {
            VBox productoBox = new VBox();
            productoBox.setAlignment(Pos.BASELINE_LEFT);
            productoBox.setPrefWidth(150);
            productoBox.setPrefHeight(200);
            productoBox.setSpacing(5);
            productoBox.setPadding(new Insets(20));

            // Imagen del producto
            ImageView imagenView;
            try {
                Image image = new Image(producto.getImageRut(), true); // Cargar imagen
                imagenView = new ImageView(image);
            } catch (Exception e) {
                // Imagen por defecto en caso de error
                imagenView = new ImageView(new Image("Images/default.png", true));
            }
            imagenView.setFitWidth(180);
            imagenView.setFitHeight(180);

            // Nombre del producto
            Label nombreLabel = new Label(producto.getNombre());
            nombreLabel.setFont(fontProductName);

            Label precioLabel = new Label("$" + String.valueOf(producto.getPrecio()));
            precioLabel.setFont(fontPrice);

            // Agregar elementos al VBox
            productoBox.getChildren().addAll(imagenView, nombreLabel, precioLabel);


            productoBox.setCursor(Cursor.OPEN_HAND);
            productoBox.setOnMouseClicked(event -> {
                Navigator.navigateTo("product");
                ProductController.setProductDetails(producto.getCategory(), producto.getNombre(), "$" + producto.getPrecio());
            });

            // Agregar al GridPane
            catalogGrid.add(productoBox, columna, fila);

            columna++;
            if (columna == 4) { // Cambiar fila después de 4 columnas
                columna = 0;
                fila++;
            }
        }
    }

    private List<Producto> getMockProductos() {
        // Simular datos de productos iniciales
        List<Producto> mockProductos = new ArrayList<>();
        mockProductos.add(new Producto(1, "Producto 1", 100, "Images/64521603-suéter-para-la-ropa-aislada-en-el-fondo-blanco.jpg", "Category 1"));
        mockProductos.add(new Producto(2, "Producto 2", 200, "Images/64521603-suéter-para-la-ropa-aislada-en-el-fondo-blanco.jpg", "Category 2"));
        mockProductos.add(new Producto(3, "Producto 3", 300, "Images/64521603-suéter-para-la-ropa-aislada-en-el-fondo-blanco.jpg", "Category 3"));
        return mockProductos;
    }
}
