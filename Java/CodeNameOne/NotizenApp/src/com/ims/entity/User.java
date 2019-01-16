/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.entity;

/**
 *
 * @author Manuel Bachofner
 */
public class User {

    String email;
    String idToken;
    String refreshToken;

    /**
     *
     * @param email
     * @param idToken
     * @param refreshToken
     */
    public User(String email, String idToken, String refreshToken) {
        this.email = email;
        this.idToken = idToken;
        this.refreshToken = refreshToken;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getIdToken() {
        return idToken;
    }

    /**
     *
     * @return
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    

}
