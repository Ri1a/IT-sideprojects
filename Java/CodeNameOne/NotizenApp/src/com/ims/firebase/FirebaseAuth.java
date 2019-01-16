/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.firebase;

import com.ims.entity.User;
import com.codename1.util.regex.RE;

import java.util.Map;

/**
 *
 * @author Manuel Bachofner
 */
public class FirebaseAuth {

    private final static String API_URL = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/";
    private final String api_key;

    private User user;
    private final FirebaseRest rest;
    private String errorMessage;

    /**
     *
     * @param api_key
     * @param rest
     */
    public FirebaseAuth(String api_key, FirebaseRest rest) {
        this.rest = rest;
        this.api_key = api_key;
    }

    /**
     *
     * @param email
     * @param password
     */
    public boolean signUp(String email, String password) {
        errorMessage = "";
        String body = createRequestBody(email, password);
        String url = API_URL + "signupNewUser?key=" + api_key;
        return callAPI(url, body);
    }

    /**
     *
     * @param email
     * @param password
     */
    public boolean signIn(String email, String password) {
        errorMessage = "";
        String body = createRequestBody(email, password);
        String url = API_URL + "verifyPassword?key=" + api_key;
        return callAPI(url, body);
    }

    public boolean callAPI(String url, String body) {
        rest.setUrl(url);
        try {
            Map result = rest.synchronousRequest(body, true);
            user = new User(result.get("email").toString(), result.get("idToken").toString(), result.get("refreshToken").toString());
            return true;
        } catch (RuntimeException ex) {
            errorMessage = ex.getMessage();
            return false;
        }
    }

    private String createRequestBody(String email, String password) {
        return "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @return
     */
    public String getTokenId() {
        return user.getIdToken();
    }

    /**
     *
     * @return
     */
    public String getUserFolderName() {
        RE r = new RE("[^a-zA-Z0-9]");
        return r.subst(user.getEmail(), "");
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
