package org.juannn.easyshop.ViewControllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import org.juannn.easyshop.Navigator;

public class UserController {

    @FXML
    private ImageView img_profile;  // Imagen de perfil del usuario

    @FXML
    private Label lbl_easy;  // Etiqueta de "EasyShop" (probablemente para regresar al catálogo)

    @FXML
    private JFXButton btn_wish;  // Botón para la lista de deseos

    @FXML
    private JFXButton btn_history;  // Botón para ver el historial de compras

    @FXML
    private JFXButton btn_cart;  // Botón para acceder al carrito

    @FXML
    private Label lbl_shop;  // Etiqueta de "Shop" (para navegar al catálogo)

    public void initialize() {
        // Aplicar forma circular a la imagen de perfil
        adjustProfilePhoto(img_profile, 50);

        // Configuración de navegación de las etiquetas y botones
        lbl_easy.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));  // Redirigir al catálogo
        lbl_shop.setOnMouseClicked(event -> Navigator.navigateTo("catalog"));  // Redirigir al catálogo
        btn_wish.setOnMouseClicked(event -> Navigator.navigateTo("wish"));  // Redirigir a la lista de deseos
        btn_history.setOnAction(actionEvent -> Navigator.navigateTo("history"));  // Redirigir al historial
        btn_cart.setOnAction(actionEvent -> Navigator.navigateTo("cart"));  // Redirigir al carrito
    }

    // Método para ajustar la imagen de perfil a un círculo
    private void adjustProfilePhoto(ImageView imageView, double radius) {
        if (imageView != null) {
            Circle clip = new Circle(radius);
            clip.setCenterX(imageView.getFitWidth() / 2);
            clip.setCenterY(imageView.getFitHeight() / 2);
            imageView.setClip(clip);  // Establecer la imagen dentro de un círculo
        }
    }
}
