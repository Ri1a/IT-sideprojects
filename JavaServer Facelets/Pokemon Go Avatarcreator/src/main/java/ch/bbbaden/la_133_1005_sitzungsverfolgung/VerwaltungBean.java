/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.la_133_1005_sitzungsverfolgung;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Riccardo
 */
@Named(value = "verwaltungBean")
@SessionScoped
public class VerwaltungBean implements Serializable {
    
    private String bild = ".png";
    private String farbe;
    private String haare;

    public String getBild() {
        return bild;
    }

    public void setBild(String parameter) {
        this.bild = parameter + bild;
    }
    
    public String getFarbe() {
        return farbe;
    }
    
    public void setFarbe(String farbe) {
        this.farbe = farbe + bild;
    }
    
    public String getHaare() {
        return haare;
    }
    
    public void setHaare(String haare) {
        this.haare = haare + farbe;
    }


}
