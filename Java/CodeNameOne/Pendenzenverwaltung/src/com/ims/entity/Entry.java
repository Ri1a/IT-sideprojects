/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.entity;

import java.util.List;

/**
 *
 * @author Manuel Bachofner
 */
public class Entry {

    private final String title;
    private final String text;
    private String id;
    private final String kategorie;

    /**
     *
     * @param id
     * @param title
     * @param text
     * @param kategorie
     */
    public Entry(String id, String title, String kategorie, String text) {
        this.title = title;
        this.text = text;
        this.id = id;
        this.kategorie = kategorie;
    }

    /**
     *
     * @param title
     * @param text
     * @param kategorie
     */
    public Entry(String title, String kategorie, String text) {
        this.title = title;
        this.text = text;
        this.kategorie = kategorie;
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
    public String getKategorie() {
        return kategorie;
    }
    /**
     *
     * @return
     */

    public String getJSONString() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"title\":\"").append(this.getTitle()).append("\" ,");
        json.append("\"kategorie\":\"").append(this.getKategorie()).append("\" ,");
        json.append("\"text\":\"").append(this.getText()).append("\"");
        json.append("}");
        return json.toString();
    }

}
