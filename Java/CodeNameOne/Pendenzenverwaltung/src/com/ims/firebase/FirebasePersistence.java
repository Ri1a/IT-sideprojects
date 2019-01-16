/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.firebase;

import com.ims.entity.Entry;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Manuel Bachofner
 */
public class FirebasePersistence {

    private final static int HTTP_NO_NETWORK = 0;
    private final static int HTTP_OK = 200;
    private final static int HTTP_UNAUTHORIZED = 401;

    private final String url;
    private final FirebaseRest rest;

    /**
     *
     * @param rest
     * @param url
     */
    public FirebasePersistence(FirebaseRest rest, String url) {
        this.rest = rest;
        this.url = url;
    }

    /**
     *sdfasdf
     * @param entry
     */
    public void post(Entry entry) {
        rest.saveEntry(entry, url);
    }

    /**
     *
     * @return
     */
    public Map<String, Entry> loadAll() {
        rest.setUrl(url);
        Map<String, Entry> allEntries;
        Map<String, Map<String, Object>> restResult = rest.synchronousRequest("", false);
        DataMapper mapper = new DataMapper();
        return mapper.mapAllEntries(restResult);
    }

    /**
     *
     */
    public void delete() {
        rest.setUrl(url);
        rest.synchronousRequest("", false, "DELETE");
    }

    

}
