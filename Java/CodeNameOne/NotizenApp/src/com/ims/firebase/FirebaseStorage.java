/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.firebase;

import com.ims.entity.FirebaseImage;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.html.HTMLUtils;
import java.util.Map;

/**
 *
 * @author Manuel Bachofner
 */
public class FirebaseStorage {

    String url;

    private final String tokenId;

    /**
     *
     * @param projectId
     * @param tokenId
     */
    public FirebaseStorage(String projectId,String tokenId) {
        this.tokenId = tokenId;
        url = "https://firebasestorage.googleapis.com/v0/b/"+projectId+".appspot.com/o?uploadType=media";

    }

    /**
     *
     * @param filePath
     * @param fbImagePath
     * @return
     */
    public FirebaseImage putFile(String filePath, String fbImagePath) {
        FirebaseRest rest = new FirebaseRest();
        rest.setUrl(url);
        Map<String, Object>  resultMap = rest.imageUpload(filePath, fbImagePath, tokenId);
        if(resultMap != null){
            return new FirebaseImage((String) resultMap.get("name"), (String) resultMap.get("bucket"), (String) resultMap.get("downloadTokens"));
        }
        return null;
    } 
    
    /**
     *
     * @param fbImage
     * @return
     */
    public String getFileUrl(FirebaseImage fbImage) {
        String url = "https://dummyimage.com/100x100/000/9c9c9c.jpg&text=BBB";
        if(fbImage != null ){
             url = "https://firebasestorage.googleapis.com/v0/b/"+fbImage.getBucket()+"/o/"+HTMLUtils.encodeString(fbImage.getName())+"?alt=media&token="+fbImage.getDownloadToken();  
        }
        return url;
        
    }

    /**
     *
     * @param fbImage
     */
    public void deleteFile(FirebaseImage fbImage) {
        
        ConnectionRequest request = new ConnectionRequest();
        request.setUrl(url + "&name=" + fbImage.getName());
        request.addRequestHeader("Authorization", "Bearer " + tokenId);
        request.setHttpMethod("DELETE");
        request.setFailSilently(true);
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        request.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(request);
        if (request.getResponseCode() != 200) {
            System.out.println(request.getResponseErrorMessage());
        }

    }   
}
