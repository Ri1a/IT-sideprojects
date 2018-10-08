/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m326.pattern.iterator.fotosammlung;

import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author Kim Strasser
 */
public class ImageIterator implements Iterator {

    private int currentPos = 0;
    private final List<Image> images;

    public ImageIterator(List<Image> images) {
        currentPos = 0;
        this.images = images;
    }

    @Override
    public boolean hasNext() {
        return currentPos + 1 < images.size();
    }

    @Override
    public void next() {
        if (this.hasNext()) {
            currentPos++;
        } else {
            currentPos = 0;
        }
    }

    @Override
    public boolean hasBack() {
        return currentPos > 0;
    }

    @Override
    public void back() {
        if (this.hasBack()) {
            currentPos--;
        } else {
            currentPos = images.size() - 1;
        }
    }

    @Override
    public Image currentItem() {
        return images.get(currentPos);
    }

}
