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
public class Entry {

    private final String title;
    private final String text;
    private String id;
    private final FirebaseImage fbImage;

    /**
     *
     * @param id
     * @param title
     * @param text
     * @param fbImage
     */
    public Entry(String id, String title, String text, FirebaseImage fbImage) {
        this.title = title;
        this.text = text;
        this.id = id;
        this.fbImage = fbImage;
    }

    /**
     *
     * @param title
     * @param text
     * @param fbImage
     */
    public Entry(String title, String text, FirebaseImage fbImage) {
        this.title = title;
        this.text = text;

        this.fbImage = fbImage;
    }

    /*
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @return
     */
    public FirebaseImage getFbImage() {
        return fbImage;
    }

    public String getJSONString() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"title\":\"" + this.getTitle() + "\" ,");
        json.append("\"text\":\"" + this.getText() + "\"");
        if (getFbImage() != null) {
            json.append(",\"fbImage\":" + this.getFbImage().getJSONString() );
        }
        json.append("}");
        return json.toString();
    }

}
