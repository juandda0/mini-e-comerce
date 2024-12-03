package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import org.juannn.easyshop.Navigator;
import org.juannn.easyshop.backend.models.Producto;
import org.juannn.easyshop.backend.persistencia.BBDD;

import java.util.ArrayList;
import java.util.List;

public class HistoryController {
    @FXML
    private GridPane historyListGrid;

    @FXML
    private Label lbl_account;

    @FXML
    private Label lbl_cart;

    @FXML
    private Label lbl_easy;

    @FXML
    private Label lbl_shop;

    private final Font fontProductName = Font.font("Segoe UI Semibold", FontWeight.NORMAL, FontPosture.REGULAR, 16);
    private final Font fontPrice = Font.font("Segoe UI SemiLight", FontWeight.NORMAL, FontPosture.REGULAR, 14);

    private List<Producto> productosHistorial = BBDD.getHistorial();

    @FXML
    public void initialize() {

        updateWishlist(); // Actualiza la vista con los productos en el carrito

        lbl_easy.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));
        lbl_shop.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));

        lbl_account.setOnMouseClicked(event -> Navigator.navigateTo("user"));
        lbl_cart.setOnMouseClicked(event -> Navigator.navigateTo("cart"));
    }

    private void updateWishlist() {
        historyListGrid.getChildren().clear(); // Limpiar el GridPane antes de agregar los productos
        historyListGrid.setHgap(10); // Espacio horizontal entre los productos
        historyListGrid.setVgap(10); // Espacio vertical entre las filas
        historyListGrid.setPadding(new Insets(10)); // Padding alrededor del GridPane

        historyListGrid.setAlignment(Pos.CENTER);

        int fila = 0;

        for (Producto producto : productosHistorial) {
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

            productoBox.getChildren().addAll(imagenView, textContainer);

            historyListGrid.add(productoBox, 0, fila++);
        }
    }

}
