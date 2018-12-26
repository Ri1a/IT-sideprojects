/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.kurznotizen;

import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * GUI builder created Form
 *
 * @author ricky
 */
public class MainForm extends com.codename1.ui.Form {

    Form notizen = new Form("Notizen", new BoxLayout(BoxLayout.Y_AXIS));

    public MainForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public MainForm(com.codename1.ui.util.Resources resourceObjectInstance) {

        Toolbar.setGlobalToolbar(true);
        notizen.getToolbar().addCommandToRightBar("+", null, e -> {
            TextField tf = new TextField("", "Titel", 20, TextField.ANY);
            TextArea body = new TextArea(5, 20);
            body.setHint("Notiz");
            Command ok = new Command("OK");
            Command cancel = new Command("Abbrechen");
            Command result = Dialog.show("Neue Notiz", BorderLayout.north(tf).add(BorderLayout.CENTER, body), ok, cancel);
            if (ok == result) {
                try (OutputStream os = Storage.getInstance().createOutputStream(tf.getText());) {
                    os.write(body.getText().getBytes("UTF-8"));
                    createFileEntry(notizen, tf.getText());
                    notizen.getContentPane().animateLayout(250);
                } catch (IOException err) {
                    Log.e(err);
                }
            }
        });
        for (String file : Storage.getInstance().listEntries()) {
            createFileEntry(notizen, file);
        }

        initGuiBuilderComponents(resourceObjectInstance);

    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("MainForm");
        setName("MainForm");
        addComponent(gui_Button);
        gui_Button.setPreferredSizeStr("52.910053mm 16.137566mm");
        gui_Button.setText("Notizen anzeigen");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineAllStyles("font:6.0mm;");
        gui_Button.setName("Button");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "14.348463% auto auto auto").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    private void createFileEntry(Form notizen, String file) {
        Label fileField = new Label(file);
        Button delete = new Button();
        Button view = new Button();
        FontImage.setMaterialIcon(delete, FontImage.MATERIAL_DELETE);
        FontImage.setMaterialIcon(view, FontImage.MATERIAL_OPEN_IN_NEW);
        Container content = BorderLayout.center(fileField);
        int size = Storage.getInstance().entrySize(file);
        content.add(BorderLayout.EAST, BoxLayout.encloseX(new Label(size + "bytes"), delete, view));
        delete.addActionListener(e -> {
            Storage.getInstance().deleteStorageFile(file);
            content.setY(notizen.getWidth());
            notizen.getContentPane().animateUnlayoutAndWait(150, 255);
            notizen.removeComponent(content);
            notizen.getContentPane().animateLayout(150);
        });
        view.addActionListener(e -> {
            try (InputStream is = Storage.getInstance().createInputStream(file);) {
                String s = Util.readToString(is, "UTF-8");
                Dialog.show(file, s, "OK", null);
            } catch (IOException err) {
                Log.e(err);
            }
        });
        notizen.add(content);
    }

    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        notizen.show();
    }

}
