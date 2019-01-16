package com.ims.pendenzen;

import com.codename1.components.MultiButton;
import com.codename1.io.Preferences;
import com.codename1.io.Storage;
import com.codename1.location.Location;
import com.codename1.location.LocationListener;
import com.codename1.location.LocationManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.ims.entity.Entry;
import com.ims.firebase.FirebaseAuth;
import com.ims.firebase.FirebasePersistence;
import com.ims.firebase.FirebaseRest;
import com.ims.firebase.FirebaseStorage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class LoginForm extends com.codename1.ui.Form {

    private final static String FB_PORJECT_ID = "pendenzenverwaltung-ee6d2";
    private final static String FB_API_KEY = "AIzaSyCCIQxVgs-SM6xLKbMuiqZ5mAqGXlG7M3k";

    private final static String FB_PORJECT_URL = "https://" + FB_PORJECT_ID + ".firebaseio.com/entries.json";

    private FirebaseAuth auth;
    private FirebasePersistence fbp;
    
    private String strGPS = "";

    Container conTodos = new Container(new BoxLayout(BoxLayout.Y_AXIS));

    public LoginForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public LoginForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        auth = new FirebaseAuth(FB_API_KEY, new FirebaseRest());

        Container conLogin = new Container(BoxLayout.y());
        TextComponent txtcEmail = new TextComponent().label("Email:");
        TextComponent txtcPass = new TextComponent().label("Passwort:");
        Label lblError = new Label("");
        Button btnLogin = new Button("Login");
        btnLogin.addActionListener(e -> {
            String email = txtcEmail.getText();
            String password = txtcPass.getText();
            if (auth.signIn(email, password)) {
                showToDosForm();
            } else {
                lblError.setText(auth.getErrorMessage());
            }
        });
        Button btnRegister = new Button("Registieren");
        btnRegister.addActionListener(e -> {
            String email = txtcEmail.getText();
            String password = txtcPass.getText();
            if (auth.signUp(email, password)) {
                showToDosForm();
            } else {
                lblError.setText(auth.getErrorMessage());
            }
        });
        Label lblUser = new Label("Testbenutzer: test@test.ch");
        Label lblPass = new Label("Passwort: 123456");
        conLogin.add(txtcEmail);
        conLogin.add(txtcPass);
        conLogin.add(btnRegister);
        conLogin.add(btnLogin);
        conLogin.add(lblError);
        conLogin.add(lblUser);
        conLogin.add(lblPass);

        this.add(conLogin);

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
    public void showToDosForm() {
        ToDosForm todosForm = new ToDosForm();

        Container conAll = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        TextComponent txtcTitel = new TextComponent().label("Titel:");
        TextComponent txtcText = new TextComponent().label("Text:");
        TextComponent txtcKategorie = new TextComponent().label("Kategorie:");
        Button btnSave = new Button("Speichern");
        Button btnReload = new Button("Reload");
        conAll.add(txtcTitel);
        conAll.add(txtcText);
        conAll.add(txtcKategorie);
        conAll.add(btnSave);
        
        btnSave.addActionListener(e -> {
            if ("".equals(txtcTitel.getText()) || "".equals(txtcText.getText()) || "".equals(txtcKategorie.getText())) {
                Dialog.show("Eingabe ungültig", "Ihre Eingabe ist leider ungültig", "OK", null);
            } else {
                Entry newEntry = new Entry(txtcTitel.getText(), txtcKategorie.getText(), txtcText.getText());

                fbp.post(newEntry);
                updateList();
            }
        });
        btnReload.addActionListener(e -> {
            updateList();
        });
        conAll.add(btnReload);
        conAll.add(conTodos);
        todosForm.add(conAll);

        if (auth.getUser() != null) {
            fbp = new FirebasePersistence(new FirebaseRest(), FB_PORJECT_URL + "?auth=" + auth.getTokenId());
            updateList();
        } else {
            new LoginForm().show();
        }

        todosForm.show();
    }

    //Lists for Todos
    private Map<String, Object> createListEntry(String title, String kategorie, String text) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("title", title);
        entry.put("kategorie", kategorie);
        entry.put("text", text);

        return entry;
    }

    private void updateList() {
        int mm = Display.getInstance().convertToPixels(3);

        FirebaseStorage gd = new FirebaseStorage(FB_PORJECT_ID, auth.getTokenId());
        Storage.getInstance().clearStorage();
        Map<String, Entry> loadedData = fbp.loadAll();
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        for (Entry entry : loadedData.values()) {
            data.add(createListEntry(entry.getTitle(), entry.getKategorie(), entry.getText()));
        }
        Collections.reverse(data);
        for (Map<String, Object> entry : data) {
            MultiButton mb = new MultiButton(entry.get("title").toString());
            String erledigt = Preferences.get("tk_erledigt", null);
            mb.setTextLine2(erledigt);
            mb.addActionListener((ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (Dialog.show("Titel: " + entry.get("title").toString(), "Kategorie: " + entry.get("kategorie").toString() + "\n" + entry.get("text").toString() + "\nGPS: " + initGps(), "Erledigt!", "OK")) {
                        if (Dialog.show("Löschen?", "Möchten Sie das ToDo löschen?", "Ja", "Nein")) {
                            fbp.delete();
                        } else {
                            String str_erledigt = "Erledigt";
                            setLine2Color(mb, 0x4BA42F);
                            mb.setTextLine2(str_erledigt);
                            Preferences.set("tk_erledigt", str_erledigt);
                        }
                    }
                }
            });
            conTodos.add(mb);
        }
    }

    //Colors of Multibutton
    private void setLine2Color(MultiButton multiButton, int color) {
        List<Component> childsLevel1 = multiButton.getChildrenAsList(false);
        Container firstContainerLevel1 = (Container) childsLevel1.get(0);
        List<Component> childsLevel2 = firstContainerLevel1.getChildrenAsList(false);
        Container targetContainerLevel2 = (Container) childsLevel2.get(multiButton.isHorizontalLayout() ? 2 : 0);
        List<Component> childsLevel3 = targetContainerLevel2.getChildrenAsList(false);
        Label firstLabelLevel3 = (Label) childsLevel3.get(0);
        firstLabelLevel3.getAllStyles().setFgColor(color);
    }

    //GPS sensor
    private String initGps() {
        
        LocationManager.getLocationManager().setLocationListener(new LocationListener() {
            @Override
            public void locationUpdated(Location location) {
                strGPS = UiHelper.getInstance().getNumberFormated(location.getAltitude(), 1) + " / " + UiHelper.getInstance().getNumberFormated(location.getLongitude(), 1);
            }

            @Override
            public void providerStateChanged(int newState) {

            }

        });
        return strGPS;
    }
}
