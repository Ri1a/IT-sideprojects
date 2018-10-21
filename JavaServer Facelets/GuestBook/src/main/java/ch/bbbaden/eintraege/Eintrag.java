/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.eintraege;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ricky
 */
@Named(value = "Eintrag")
@Dependent
public class Eintrag {

    private String eintragID;
    private String eintragName;
    private String eintragDatum;
    private String eintragNachricht;

    public Eintrag() {
       
    }

    public String getEintragID() {
        return eintragID;
    }

    public String getEintragName() {
        return eintragName;
    }

    public String getEintragDatum() {
        return eintragDatum;
    }

    public String getEintragNachricht() {
        return eintragNachricht;
    }

    public Eintrag(String eintragID, String eintragName, String eintragDatum, String eintragNachricht) {
        this.eintragID = eintragID;
        this.eintragName = eintragName;
        this.eintragDatum = eintragDatum;
        this.eintragNachricht = eintragNachricht;
    }
    
    

}
