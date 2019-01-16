/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.firebase;

import com.ims.entity.Entry;
import com.ims.entity.FirebaseImage;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Manuel Bachofner
 */
public class DataMapper {

    /**
     *
     * @param restResult
     * @return
     */
    public Map<String, Entry> mapAllEntries(Map<String, Map<String, Object>> restResult) {
        Map<String, Entry> allEntries = new LinkedHashMap();

        if (restResult != null) {
            for (Map.Entry<String, Map<String, Object>> restEntry : restResult.entrySet()) {

                String id = restEntry.getKey();
                Entry mappedEntry = mapEntry(restEntry);
                allEntries.put(id,mappedEntry);
            }

        }
        return allEntries;
    }

    private Entry mapEntry(Map.Entry<String, Map<String, Object>> restEntry) {
        String title = "";
        String text = "";
        FirebaseImage image = null;
        Map<String, Object> entryContent = restEntry.getValue();
        String id = restEntry.getKey();

        for (Map.Entry<String, Object> attribute : entryContent.entrySet()) {
            if (attribute.getKey().equals("title")) {
                title = attribute.getValue().toString();
            }
            if (attribute.getKey().equals("text")) {
                text = attribute.getValue().toString();
            }
            if (attribute.getKey().equals("fbImage")) {
                image = createImage((Map<String, String>) attribute.getValue());
            }
        }
        return new Entry(id, title, text, image);
    }

    private FirebaseImage createImage(Map<String, String> content) {
        FirebaseImage image = null;
        String filename = "";
        String downloadToken = "";
        String bucket = "";
        for (Map.Entry<String, String> file : content.entrySet()) {
            System.out.println(file.getKey());
            if (file.getKey().equals("name")) {
                filename = file.getValue();
            }
            if (file.getKey().equals("downloadToken")) {
                downloadToken = file.getValue();
            }
            if (file.getKey().equals("bucket")) {
                bucket = file.getValue();
            }
            image = new FirebaseImage(filename, bucket, downloadToken);
        }

        return image;
    }
    
    
      
}
