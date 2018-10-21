/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.login;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author ricky
 */
@Named(value = "User")
@Dependent
public class User {

    private String id;
    private String user;
    private String password;

    public User() {
       
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    

}
