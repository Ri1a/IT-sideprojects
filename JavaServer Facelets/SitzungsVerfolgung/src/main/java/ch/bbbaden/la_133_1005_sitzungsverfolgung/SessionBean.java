/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.la_133_1005_sitzungsverfolgung;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Joel
 */
@Named(value = "SessionBean")
@RequestScoped
public class SessionBean {

    public SessionBean() {
    }
    
    public String newPage(){
        return "/sitzung2.xhtml";
    }
    
}
