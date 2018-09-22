/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.la_133_9910_HelloWorld;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Alexander Flick
 */
@Named(value = "helloWorld")
@RequestScoped
public class HelloWorld {

    private final String ausgabe = "Los geht es mit JSF!";
    
    
    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

    public String getAusgabe() {
        return ausgabe;
    }    
    
}
