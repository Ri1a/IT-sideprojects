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
public class FirebaseImage {

    private final String name;
    private final String bucket;
    private final String downloadToken;

    /**
     *
     * @param name
     * @param bucket
     * @param downloadToken
     */
    public FirebaseImage(String name, String bucket, String downloadToken) {
        this.name = name;
        this.bucket = bucket;
        this.downloadToken = downloadToken;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getBucket() {
        return bucket;
    }

    public String getDownloadToken() {
        return downloadToken;
    }

    public String getJSONString() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"" + this.getName() + "\" ,");
        json.append("\"downloadToken\":\"" + this.getDownloadToken() + "\" ,");
        json.append("\"bucket\":\"" + this.getBucket() + "\"");

        json.append("}");
        return json.toString();
    }

}
