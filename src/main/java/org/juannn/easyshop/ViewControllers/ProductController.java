package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.juannn.easyshop.backend.persistencia.BBDD;
import org.juannn.easyshop.backend.models.Producto;
import org.juannn.easyshop.Navigator;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProductController {

    @FXML
    private Label lbl_category;  // Etiqueta para mostrar la categoría del producto

    @FXML
    private Label lbl_name;  // Etiqueta para mostrar el nombre del producto

    @FXML
    private Label lbl_price;  // Etiqueta para mostrar el precio del producto

    private static ProductController instance;  // Instancia estática para acceder a los métodos desde otras clases

    @FXML
    private Label lbl_easy;  // Etiqueta para el nombre del sitio (probablemente un logo)

    @FXML
    private Label lbl_shop;  // Etiqueta para redirigir al catálogo de productos

    @FXML
    private Label lbl_account;  // Etiqueta para redirigir a la página de usuario

    @FXML
    private Label lbl_cart;  // Etiqueta para redirigir al carrito de compras

    @FXML
    private JFXButton btn_wish;  // Botón para agregar a la lista de deseos

    @FXML
    private JFXButton btn_add;  // Botón para agregar al carrito

    @FXML
    private JFXComboBox<String> cbx_quantity;  // ComboBox para seleccionar la cantidad de productos

    @FXML
    public void initialize() {
        // Se asigna la instancia del controlador a la variable estática para que se pueda acceder a ella desde otras clases
        instance = this;

        // Configuración del ComboBox para seleccionar la cantidad de productos
        cbx_quantity.setPromptText("Quantity");
        cbx_quantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9");

        // Configuración de eventos para las etiquetas de navegación
        lbl_easy.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));  // Navegar al catálogo de productos
        lbl_shop.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));  // Navegar al catálogo

        lbl_account.setOnMouseClicked(event -> Navigator.navigateTo("user"));  // Navegar a la página de usuario
        lbl_cart.setOnMouseClicked(event -> Navigator.navigateTo("cart"));  // Navegar al carrito de compras

        // Configuración de eventos de los botones
        btn_wish.setOnAction(event -> agregarAListaDeseos());  // Agregar producto a la lista de deseos
        btn_add.setOnAction(event -> agregarAlCarrito());  // Agregar producto al carrito
    }

    // Método estático para actualizar los detalles del producto desde otras vistas
    public static void setProductDetails(String category, String name, String price) {
        if (instance != null) {  // Verificar que la instancia del controlador esté inicializada
            instance.lbl_category.setText(category);  // Actualizar la categoría del producto
            instance.lbl_name.setText(name);  // Actualizar el nombre del producto
            instance.lbl_price.setText(price);  // Actualizar el precio del producto
        }
    }

    // Método para agregar el producto a la lista de deseos
    // Método para agregar el producto a la lista de deseos o moverlo
    private void agregarAListaDeseos() {
        String productName = lbl_name.getText();  // Obtener el nombre del producto
        Producto producto = obtenerProductoPorNombre(productName);  // Buscar el producto en la lista de productos

        if (producto != null) {
            // Verificar si el producto ya está en el carrito
            if (BBDD.estaEnCarrito(producto)) {
                // Eliminarlo del carrito antes de agregarlo a la lista de deseos
                BBDD.eliminarDelCarrito(producto);
                mostrarAlerta(AlertType.INFORMATION, "Moved", "Product removed from the cart and added to the wish list.");
            }

            // Agregar el producto a la lista de deseos
            boolean exito = BBDD.agregarALaListaDeDeseos(producto);
            if (exito) {
                mostrarAlerta(AlertType.INFORMATION, "Success", "Product added to the wish list!");
            } else {
                mostrarAlerta(AlertType.ERROR, "Error", "Failed to add product to the wish list.");
            }
        }
    }

    // Método para agregar el producto al carrito o moverlo
    private void agregarAlCarrito() {
        String productName = lbl_name.getText();  // Obtener el nombre del producto
        Producto producto = obtenerProductoPorNombre(productName);  // Buscar el producto en la lista de productos

        if (producto != null) {
            // Verificar si el producto ya está en la lista de deseos
            if (BBDD.estaEnListaDeseos(producto)) {
                // Eliminarlo de la lista de deseos antes de agregarlo al carrito
                BBDD.eliminarDeLaListaDeDeseos(producto);
                mostrarAlerta(AlertType.INFORMATION, "Moved", "Product removed from the wish list and added to the cart.");
            }

            // Agregar el producto al carrito
            boolean exito = BBDD.agregarAlCarrito(producto);
            if (exito) {
                mostrarAlerta(AlertType.INFORMATION, "Success", "Product added to the cart!");
            } else {
                mostrarAlerta(AlertType.ERROR, "Error", "Failed to add product to the cart.");
            }
        }
    }

    // Método para mostrar alertas
    private void mostrarAlerta(AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    // Método para obtener un producto por su nombre (puedes ajustar la lógica según tu estructura de datos)
    private Producto obtenerProductoPorNombre(String nombre) {
        for (Producto producto : BBDD.obtenerProductos()) {
            if (producto.getNombre().equals(nombre)) {
                return producto;  // Devolver el producto que coincide con el nombre
            }
        }
        return null;  // Si no se encuentra el producto
    }
}
