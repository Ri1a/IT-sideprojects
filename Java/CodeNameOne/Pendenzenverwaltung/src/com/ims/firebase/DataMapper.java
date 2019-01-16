package com.ims.firebase;

import com.ims.entity.Entry;
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
        String kategorie = "";
        Map<String, Object> entryContent = restEntry.getValue();
        String id = restEntry.getKey();

        for (Map.Entry<String, Object> attribute : entryContent.entrySet()) {
            if (attribute.getKey().equals("title")) {
                title = attribute.getValue().toString();
            }
            if (attribute.getKey().equals("kategorie")) {
                kategorie = attribute.getValue().toString();
            }
            if (attribute.getKey().equals("text")) {
                text = attribute.getValue().toString();
            }
        }
        return new Entry(id, title, kategorie, text);
    }
      
}
