package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.models.Producto;
import org.juannn.easyshop.backend.models.Usuario;
import org.juannn.easyshop.backend.persistencia.BBDD;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;
public class WishController {
    @FXML
    private Label lbl_account;

    @FXML
    private Label lbl_cart;

    @FXML
    private Label lbl_easy;

    @FXML
    private Label lbl_shop;

    @FXML
    private GridPane wishlistGrid;

    @FXML
    private JFXButton btn_buy;

    private final Font fontProductName = Font.font("Segoe UI Semibold", FontWeight.NORMAL, FontPosture.REGULAR, 16);
    private final Font fontPrice = Font.font("Segoe UI SemiLight", FontWeight.NORMAL, FontPosture.REGULAR, 14);

    private List<Producto> listaDeseos = BBDD.getListaDeseos();

    @FXML
    public void initialize() {
        updateWishlist(); // Actualiza la vista con los productos en la lista de deseos

        lbl_easy.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));
        lbl_shop.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));

        lbl_account.setOnMouseClicked(event -> Navigator.navigateTo("user"));
        lbl_cart.setOnMouseClicked(event -> Navigator.navigateTo("cart"));
    }

    private void updateWishlist() {
        wishlistGrid.getChildren().clear(); // Limpiar el GridPane antes de agregar los productos
        wishlistGrid.setHgap(10); // Espacio horizontal entre los productos
        wishlistGrid.setVgap(10); // Espacio vertical entre las filas
        wishlistGrid.setPadding(new Insets(10)); // Padding alrededor del GridPane

        wishlistGrid.setAlignment(Pos.CENTER);

        int fila = 0;

        for (Producto producto : listaDeseos) {
            // Crear un HBox para cada producto
            HBox productoBox = new HBox(40);  // Espacio entre los elementos dentro de cada HBox
            productoBox.setAlignment(Pos.CENTER_LEFT);
            productoBox.setPadding(new Insets(20)); // Espaciado dentro del HBox
            productoBox.setStyle("-fx-border-color: #dcdcdc; -fx-border-radius: 5; -fx-background-radius: 5;");

            ImageView imagenView;
            try {
                Image image = new Image(producto.getImageRut(), true);
                imagenView = new ImageView(image);
            } catch (Exception e) {
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

            JFXButton addToCartButton = new JFXButton("Add to Cart");
            addToCartButton.setStyle("-fx-border-color: #dcdcdc; -fx-font-size: 12px;");
            addToCartButton.setOnAction(event -> {
                // Agregar el producto al carrito
                if (BBDD.agregarAlCarrito(producto)) {
                    // Eliminar el producto de la lista de deseos
                    BBDD.eliminarDeLaListaDeDeseos(producto);
                    // Actualizar la vista
                    updateWishlist();
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Added", "Product added to the cart and removed from the wish list.");
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "Failed to add product to the cart.");
                }
            });

            HBox.setMargin(addToCartButton, new Insets(0, 0, 0, 20));

            HBox.setHgrow(imagenView, Priority.NEVER);  // No permite que la imagen se expanda
            HBox.setHgrow(textContainer, Priority.ALWAYS);  // Permite que el contenedor de texto crezca
            HBox.setHgrow(addToCartButton, Priority.NEVER);  // No permite que el botón se expanda

            productoBox.getChildren().addAll(imagenView, textContainer, addToCartButton);

            wishlistGrid.add(productoBox, 0, fila++);
        }
    }

    // Método para mostrar alertas
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
