/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m326.pattern.iterator.fotosammlung;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author Kim Strasser
 */
public class Images implements Container {

    private ImageIterator iteratorFilename;
    private ImageIterator iteratorRandom;
    private List<String> imagesFile = new ArrayList();
    private final List<Image> images = new ArrayList();
    private final static String FOLDER = "img/";

    public Images() {
        imagesFile = Arrays.asList(new File(FOLDER).list());
        setImagesFilename();
    }

    public void setImagesFilename() {
        Collections.sort(imagesFile);
        setImages();
        iteratorFilename = new ImageIterator(images);
    }

    public void setImagesRandom() {
        Collections.shuffle(imagesFile);
        setImages();
        iteratorRandom = new ImageIterator(images);
    }

    private void setImages() {
        images.clear();
        Image image = null;
        for (String file : imagesFile) {
            File imageFile = new File(FOLDER + file);
            String localUrl = null;
            try {
                localUrl = imageFile.toURI().toURL().toString();
            } catch (MalformedURLException ex) {
                Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
            }
            image = new Image(localUrl);
            images.add(image);
            System.out.println(file);
        }
    }

    public void deleteImage(Image image) {
        images.remove(image);
    }

    @Override
    public Iterator getIterator(String order) {
        if ("Random".equals(order)) {
            return iteratorRandom;
        } else {
            return iteratorFilename;
        }
    }

}
