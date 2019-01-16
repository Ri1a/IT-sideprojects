package com.ims.kurznotizen;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.Resources;


public class NeueNotizForm extends Form  {
    public NeueNotizForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.TextField gui_Text_Field = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea gui_Text_Area = new com.codename1.ui.TextArea();
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
        setTitle("NeueNotizForm");
        setName("NeueNotizForm");
        addComponent(gui_Text_Field);
        addComponent(gui_Text_Area);
        addComponent(gui_Button);
        gui_Text_Field.setPreferredSizeStr("61.11111mm 7.936508mm");
                gui_Text_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field.setName("Text_Field");
        gui_Text_Field.setRows(1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Field.getParent().getLayout()).setInsets(gui_Text_Field, "20.23336% 0.0mm auto 0.0mm").setReferenceComponents(gui_Text_Field, "-1 2 -1 2 ").setReferencePositions(gui_Text_Field, "0.0 0.0 0.0 0.0");
        gui_Text_Area.setPreferredSizeStr("59.52381mm 52.1164mm");
        gui_Text_Area.setText("");
                gui_Text_Area.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area.setInlineAllStyles("bgColor:e2f3fd; fgColor:40001; transparency:255;");
        gui_Text_Area.setName("Text_Area");
        gui_Text_Area.setColumns(8);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Area.getParent().getLayout()).setInsets(gui_Text_Area, "1.8518518mm 0.0mm 36.71642% auto").setReferenceComponents(gui_Text_Area, "0 0 -1 -1").setReferencePositions(gui_Text_Area, "1.0 0.0 0.0 0.0");
        gui_Button.setPreferredSizeStr("60.582012mm 12.698413mm");
        gui_Button.setText("Speichern");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setInlineAllStyles("font:6.0mm;");
        gui_Button.setName("Button");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "3.968254mm auto auto auto").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
