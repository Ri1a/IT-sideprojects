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
@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    public String indexPage() {
        return "/index.xhtml";
    }
    
    public String auswahl1() {
        return "/auswahl1.xhtml";
    }
    
    public String auswahl2() {
        return "/auswahl2.xhtml";
    }

}
