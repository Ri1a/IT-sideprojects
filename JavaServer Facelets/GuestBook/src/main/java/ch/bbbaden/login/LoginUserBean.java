/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.login;

import ch.bbbaden.eintraege.Eintrag;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.jdom2.JDOMException;

/**
 *
 * @author Alexander Flick
 */
@Named(value = "loginUserBean")
@SessionScoped
public class LoginUserBean implements Serializable {

    private String username;
    private String password;
    private User u;
    private boolean loggedIn;
    
    private String nachricht;
    

    public String doLogin() throws JDOMException, IOException {
        
        LoginDAO login = new LoginDAO();
        u = login.check(username, password);
        if(u == null) {
            return "/start.xhtml";
        }
        loggedIn = true;
        return "/secured/welcome?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Eintrag> getEintraege() throws JDOMException, IOException {
        return LoginDAO.getData();
        
    }

    public User getU() {
        return u;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setU(User u) {
        this.u = u;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }
    
}
