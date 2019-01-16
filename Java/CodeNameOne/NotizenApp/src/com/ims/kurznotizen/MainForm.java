/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.kurznotizen;

import com.codename1.ui.Form;
import com.ims.firebase.FirebaseAuth;
import com.ims.firebase.FirebasePersistence;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class MainForm extends com.codename1.ui.Form {
    
    //Firebase
    private final static String FB_PORJECT_ID = "pendenzenverwaltung-ee6d2";
    private final static String FB_API_KEY = "AIzaSyCCIQxVgs-SM6xLKbMuiqZ5mAqGXlG7M3k";

    private final static String FB_PORJECT_URL = "https://" + FB_PORJECT_ID + ".firebaseio.com/entries.json";

    private FirebaseAuth auth;
    private FirebasePersistence fbp;
    
    //CN1
    
    public MainForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public MainForm(com.codename1.ui.util.Resources resourceObjectInstance) {
    
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("MainForm");
        setName("MainForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}