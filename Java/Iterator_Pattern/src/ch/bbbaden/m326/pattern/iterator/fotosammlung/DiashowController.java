/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m326.pattern.iterator.fotosammlung;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

/**
 *
 * @author Kim Strasser
 */
public class DiashowController implements Initializable {

    @FXML
    private MenuItem btnClose;
    @FXML
    private MenuItem btnDelete;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnNext;
    @FXML
    private ImageView imageView;
    @FXML
    private MenuItem btnRandom;
    @FXML
    private MenuItem btnFilename;

    private Images img;
    private Iterator iterator;

    @FXML
    private void handleNext(ActionEvent event) {
        iterator.next();
        imageView.setImage(iterator.currentItem());
    }

    @FXML
    private void handleBack(ActionEvent event) {
        iterator.back();
        imageView.setImage(iterator.currentItem());
    }

    @FXML
    private void handleClose(ActionEvent event) {
        System.exit(0);
        System.out.println("Programm wurde geschlossen");
    }

    @FXML
    private void handleOrderRandom(ActionEvent event) {
        img.setImagesRandom();
        iterator = img.getIterator("Random");
        imageView.setImage(iterator.currentItem());
    }

    @FXML
    private void handleOrderFilename(ActionEvent event) {
        img.setImagesFilename();
        iterator = img.getIterator("Filename");
        imageView.setImage(iterator.currentItem());
    }

    @FXML
    private void handleDelete(ActionEvent event) {

        img.deleteImage(imageView.getImage());

        try {

            iterator.next();
            imageView.setImage(iterator.currentItem());
            System.out.println("Ein Bild wurde gelöscht");

        } catch (Exception e) {

            System.out.println("Bild kann nicht gelöscht werden");
            btnDelete.setDisable(true);
            btnNext.setDisable(true);
            btnBack.setDisable(true);
            btnRandom.setDisable(true);
            btnFilename.setDisable(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img = new Images();
        iterator = img.getIterator("Filename");
        imageView.setImage(iterator.currentItem());
    }

}
