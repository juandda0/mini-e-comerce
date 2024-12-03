package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.models.Producto;
import org.juannn.easyshop.backend.persistencia.BBDD;

import java.util.ArrayList;
import java.util.List;

public class CartController {


    @FXML
    private GridPane cartListGrid;

    @FXML
    private Label lbl_account;

    @FXML
    private Label lbl_shop;

    @FXML
    private Label lbl_easy;

    private final Font fontProductName = Font.font("Segoe UI Semibold", FontWeight.NORMAL, FontPosture.REGULAR, 16);
    private final Font fontPrice = Font.font("Segoe UI SemiLight", FontWeight.NORMAL, FontPosture.REGULAR, 14);

    private final List<Producto> productosCarrito = new ArrayList<>();
    @FXML
    public void initialize() {
        productosCarrito.clear();
        productosCarrito.addAll(BBDD.getCarrito());

        // Aquí se simula la carga de productos, deberías reemplazar esta parte por la llamada al backend
        updateCartlist(); // Actualiza la vista con los productos en el carrito

        lbl_easy.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));
        lbl_shop.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));

        lbl_account.setOnMouseClicked(event -> Navigator.navigateTo("user"));
    }


    private void updateCartlist() {
        cartListGrid.getChildren().clear(); // Limpiar el GridPane antes de agregar los productos
        cartListGrid.setHgap(10); // Espacio horizontal entre los productos
        cartListGrid.setVgap(10); // Espacio vertical entre las filas
        cartListGrid.setPadding(new Insets(10)); // Padding alrededor del GridPane

        cartListGrid.setAlignment(Pos.CENTER);

        int fila = 0;

        for (Producto producto : productosCarrito) {
            // Crear un HBox para cada producto
            HBox productoBox = new HBox(40);  // Espacio entre los elementos dentro de cada HBox
            productoBox.setAlignment(Pos.CENTER_LEFT);
            productoBox.setPadding(new Insets(20)); // Espaciado dentro del HBox
            productoBox.setStyle("-fx-border-color: #dcdcdc; -fx-border-radius: 5; -fx-background-radius: 5;");

            ImageView imagenView;
            try {
                // Intenta cargar la imagen del producto
                Image image = new Image(producto.getImageRut(), true);
                imagenView = new ImageView(image);
            } catch (Exception e) {
                // Si falla, muestra una imagen predeterminada
                imagenView = new ImageView(new Image("Images/default.png", true));
            }
            imagenView.setFitWidth(80);  // Establecer el tamaño de la imagen
            imagenView.setFitHeight(80);

            VBox textContainer = new VBox(5);
            textContainer.setAlignment(Pos.CENTER_LEFT); // Alineación del texto al lado izquierdo

            Label nombreLabel = new Label(producto.getNombre());
            nombreLabel.setFont(fontProductName); // Establece la fuente para el nombre

            Label precioLabel = new Label("$" + producto.getPrecio());
            precioLabel.setFont(fontPrice); // Establece la fuente para el precio

            textContainer.getChildren().addAll(nombreLabel, precioLabel);
            HBox.setHgrow(imagenView, Priority.NEVER);  // No permite que la imagen se expanda
            HBox.setHgrow(textContainer, Priority.ALWAYS);  // Permite que el contenedor de texto crezca

            productoBox.getChildren().addAll(imagenView, textContainer);

            cartListGrid.add(productoBox, 0, fila++);
        }
    }
    @FXML
    private void onBuy() {
        List<Producto> productosCarrito = BBDD.getCarrito();  // Obtener los productos del carrito
        if (productosCarrito.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Empty Cart", "No products in the cart.");
            return;
        }

        // Mover los productos al historial
        for (Producto producto : productosCarrito) {
            BBDD.agregarAlHistorial(producto);  // Agregar al historial
        }

        // Limpiar el carrito
        BBDD.limpiarCarrito();

        // Actualizar la vista del carrito
        updateCartlist();

        // Mostrar un mensaje de éxito
        mostrarAlerta(Alert.AlertType.INFORMATION, "Purchase Successful", "Your purchase has been completed!");
    }

    // Método para mostrar alertas
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }



}
