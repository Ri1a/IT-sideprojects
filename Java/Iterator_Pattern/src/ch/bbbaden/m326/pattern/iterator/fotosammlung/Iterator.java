/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.m326.pattern.iterator.fotosammlung;

import javafx.scene.image.Image;

/**
 *
 * @author Kim Strasser
 */
public interface Iterator {
    public boolean hasNext();
    public boolean hasBack();
    public void next();
    public void back();
    public Image currentItem();
    
}
