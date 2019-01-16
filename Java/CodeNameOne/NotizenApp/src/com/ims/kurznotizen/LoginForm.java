/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.kurznotizen;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class LoginForm extends com.codename1.ui.Form {

    public LoginForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public LoginForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        LoginForm loginForm = new LoginForm();
        
        Container conLogin = new Container(BoxLayout.y());
        TextComponent txtcEmail = new TextComponent().label("Email:");
        TextComponent txtcPass = new TextComponent().label("Passwort:");
        
        conLogin.add(txtcEmail);
        conLogin.add(txtcPass);
        
        Container conBtn = new Container(BoxLayout.x());
        Button btnLogin = new Button();
        Button btnRegister = new Button();
        
        conBtn.add(btnLogin);
        conBtn.add(btnRegister);
        
        loginForm.add(conLogin);
        loginForm.add(conBtn);
        
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("LoginForm");
        setName("LoginForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
