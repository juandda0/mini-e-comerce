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
import org.juannn.easyshop.backend.persistencia.BBDD;

import java.util.ArrayList;
import java.util.List;

public class CatalogController {

    @FXML
    private GridPane catalogGrid;  // Contenedor principal donde se mostrarán los productos en una cuadrícula

    @FXML
    private Button addProduct;  // Botón para añadir un nuevo producto (para pruebas)

    @FXML
    private JFXComboBox<String> categoryComboBox;  // ComboBox para filtrar los productos por categoría

    @FXML
    private Label lbl_account;  // Enlace a la vista de la cuenta del usuario

    @FXML
    private Label lbl_cart;  // Enlace al carrito de compras

    // Fuentes personalizadas para los productos
    Font fontProductName = Font.font("Segoe UI Semibold", FontWeight.NORMAL, FontPosture.REGULAR, 16);
    Font fontPrice = Font.font("Segoe UI SemiLight", FontWeight.NORMAL, FontPosture.REGULAR, 14);

    @FXML
    public void initialize() {
        // Inicialización de la vista, configurando el ComboBox y añadiendo productos de ejemplo
        categoryComboBox.setPromptText("Select a category");

        // Añadir categorías al ComboBox para filtrar productos
        categoryComboBox.getItems().addAll("All categories", "Clothing", "Books", "Toys");

        // Obtener los productos desde la base de datos (a través de la clase BBDD)
        List<Producto> productos = BBDD.obtenerProductos();  // Obtener productos desde la base de datos

        // Actualizar la vista del catálogo con los productos obtenidos
        updateCatalog(productos);

        // Acción para agregar un producto de ejemplo al catálogo (simulado)
        addProduct.setOnAction(event -> {
            Producto nuevoProducto = new Producto(
                    productos.size() + 1,
                    "product " + (productos.size() + 1),
                    500,
                    "Images/64521603-suéter-para-la-ropa-aislada-en-el-fondo-blanco.jpg",
                    "Category" + (productos.size() + 1),
                    productos.size() + 1
            );

            // Agregar el nuevo producto a la lista y actualizar el catálogo
            productos.add(nuevoProducto);
            updateCatalog(productos);
        });

        // Enlaces para navegar a las vistas de cuenta y carrito
        lbl_account.setOnMouseClicked(event -> Navigator.navigateTo("user"));
        lbl_cart.setOnMouseClicked(event -> Navigator.navigateTo("cart"));
    }

    // Método para actualizar el catálogo
    private void updateCatalog(List<Producto> productos) {
        // Limpiar la vista actual del catálogo antes de agregar los productos
        catalogGrid.getChildren().clear();

        // Configuración del espaciado y márgenes en el GridPane
        catalogGrid.setHgap(10);
        catalogGrid.setVgap(10);
        catalogGrid.setPadding(new Insets(10));

        int columna = 0, fila = 0;

        // Recorrer la lista de productos y mostrar cada uno en la interfaz
        for (Producto producto : productos) {
            VBox productoBox = new VBox();
            productoBox.setAlignment(Pos.BASELINE_LEFT);
            productoBox.setPrefWidth(150);
            productoBox.setPrefHeight(200);
            productoBox.setSpacing(5);
            productoBox.setPadding(new Insets(20));

            // Cargar la imagen del producto
            ImageView imagenView;
            try {
                Image image = new Image(producto.getImageRut(), true); // Cargar imagen desde la URL especificada
                imagenView = new ImageView(image);
            } catch (Exception e) {
                // Si ocurre un error al cargar la imagen, usar una imagen por defecto
                imagenView = new ImageView(new Image("Images/default.png", true));
            }
            imagenView.setFitWidth(180);
            imagenView.setFitHeight(180);

            // Etiqueta para el nombre del producto
            Label nombreLabel = new Label(producto.getNombre());
            nombreLabel.setFont(fontProductName);

            // Etiqueta para el precio del producto
            Label precioLabel = new Label("$" + String.valueOf(producto.getPrecio()));
            precioLabel.setFont(fontPrice);

            // Añadir los elementos al VBox (contenedor de cada producto)
            productoBox.getChildren().addAll(imagenView, nombreLabel, precioLabel);

            // Hacer que el cursor cambie a mano al pasar sobre el producto
            productoBox.setCursor(Cursor.OPEN_HAND);

            // Acción al hacer clic en un producto (navegar a la vista de detalles del producto)
            productoBox.setOnMouseClicked(event -> {
                Navigator.navigateTo("product");  // Navegar a la vista de producto
                ProductController.setProductDetails(producto.getCategory(), producto.getNombre(), "$" + producto.getPrecio());
            });

            // Agregar el VBox con el producto al GridPane (en la posición adecuada)
            catalogGrid.add(productoBox, columna, fila);

            columna++;
            if (columna == 4) { // Cambiar de fila después de agregar 4 productos
                columna = 0;
                fila++;
            }
        }
    }
}
