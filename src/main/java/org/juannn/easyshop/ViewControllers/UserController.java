package org.juannn.easyshop.ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class UserController {

    @FXML
    private ImageView img_profile;


    public void initialize() {
        // Aplicar forma circular al ImageView
        adjustProfilePhoto(img_profile, 50);
    }

    private void adjustProfilePhoto(ImageView imageView, double radius) {
        if (imageView != null) {
            Circle clip = new Circle(radius);
            clip.setCenterX(imageView.getFitWidth() / 2);
            clip.setCenterY(imageView.getFitHeight() / 2);
            imageView.setClip(clip);
        }
    }
}
