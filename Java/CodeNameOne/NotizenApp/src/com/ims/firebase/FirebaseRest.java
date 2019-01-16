/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.firebase;

import com.ims.entity.Entry;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.MultipartRequest;

import com.codename1.io.JSONParser;

import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

/**
 *
 * @author Manuel Bachofner
 */
public class FirebaseRest {

    private final static int HTTP_NO_NETWORK = 0;
    private final static int HTTP_OK = 200;
    private final static int HTTP_UNAUTHORIZED = 401;

    private String url;

    /**
     *
     * @param body
     * @param isPost
     * @param method
     * @return
     */
    public Map synchronousRequest(String body, boolean isPost, String method) {
        final ConnectionRequest req = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                os.write(body.getBytes("UTF-8"));
            }
        };

        req.setUrl(url);
        req.setPost(isPost);
        if (method != null) {
            req.setHttpMethod(method);
        }
        req.setContentType("application/json");
       
        req.setFailSilently(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        req.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(req);
        NetworkManager.getInstance().setTimeout(2000);
        if (req.getResponseCode() != HTTP_OK) {
            if (req.getResponseCode() == HTTP_UNAUTHORIZED) {
                throw new RuntimeException("Der Benutzer ist nicht autorisiert" + req.getResponseErrorMessage());
            }
            if (req.getResponseCode() == HTTP_NO_NETWORK) {
                throw new RuntimeException("Keine Netzwerkverbindung. " + req.getResponseErrorMessage());
            }
            try {
                Map<String, Object> errorResult = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
                Map<String, Object> error = (Map<String, Object>) errorResult.get("error");
                throw new RuntimeException("Fehler mit code " + req.getResponseCode() + ". " + error.get("message"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        JSONParser parser = new JSONParser();
        try {
            if (req.getResponseData().length > 4) {
                System.out.println(req.getResponseData().length);
                return parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Map synchronousRequestAuth(String body, boolean isPost) {
        final ConnectionRequest req = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                os.write(body.getBytes("UTF-8"));
            }
        };

        req.setUrl(url);
        req.setPost(isPost);

        req.setContentType("application/json");
        req.setFailSilently(true);

        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        req.setDisposeOnCompletion(dlg);

        NetworkManager.getInstance().addToQueueAndWait(req);
        NetworkManager.getInstance().setTimeout(2000);
        if (req.getResponseCode() != HTTP_OK) {
            if (req.getResponseCode() == HTTP_UNAUTHORIZED) {
                throw new RuntimeException("Der Benutzer ist nicht autorisiert" + req.getResponseErrorMessage());
            }
            if (req.getResponseCode() == HTTP_NO_NETWORK) {
                throw new RuntimeException("Keine Netzwerkverbindung. " + req.getResponseErrorMessage());
            }
            try {
                Map<String, Object> errorResult = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
                Map<String, Object> error = (Map<String, Object>) errorResult.get("error");
                throw new RuntimeException("Fehler mit code " + req.getResponseCode() + ". " + error.get("message"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        JSONParser parser = new JSONParser();
        try {
            if (req.getResponseData().length > 4) {
                System.out.println(req.getResponseData().length);
                return parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param body
     * @param isPost
     * @return
     */
    public Map synchronousRequest(String body, boolean isPost) {
        return synchronousRequest(body, isPost, null);
    }

    /**
     *
     * @param entity
     * @param url
     */
    public void saveEntry(Entry entity, String url) {
      
        final ConnectionRequest req = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                os.write(entity.getJSONString().getBytes("UTF-8"));
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                if (getResponseCode() != HTTP_OK) {
                    if (getResponseCode() == HTTP_UNAUTHORIZED) {
                        throw new RuntimeException("Der Benutzer ist nicht autorisiert");
                    }
                    if (getResponseCode() == HTTP_NO_NETWORK) {
                        throw new RuntimeException("Keine Netzwerkverbindung.");
                    }
                    throw new RuntimeException("Fehler mit code " + getResponseCode() + ".");
                }
            }
        };
        req.setRequestBody(entity.getJSONString());
        req.setUrl(url);
        req.setPost(true);
        req.setContentType("application/json");
        req.setFailSilently(true);
        NetworkManager.getInstance().addToQueue(req);
    }

    /**
     *
     * @param filePath
     * @param fbImagePath
     * @param tokenId
     * @return
     */
    public Map<String, Object> imageUpload(String filePath, String fbImagePath, String tokenId) {
        try {
            MultipartRequest request = new MultipartRequest();
            request.setUrl(url + "&name=" + fbImagePath);
            request.addRequestHeader("Authorization", "Bearer " + tokenId);
            request.setPost(true);
            request.setBoundary("gdb");
            request.setFailSilently(true);

            String mime = "image/jpeg";
            request.addData("file", filePath, mime);

            InfiniteProgress prog = new InfiniteProgress();
            Dialog dlg = prog.showInifiniteBlocking();
            request.setDisposeOnCompletion(dlg);
            NetworkManager.getInstance().addToQueueAndWait(request);
            if (request.getResponseCode() != 200) {
                throw new RuntimeException(request.getResponseErrorMessage());
            } else {
                JSONParser parser = new JSONParser();
                return parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
