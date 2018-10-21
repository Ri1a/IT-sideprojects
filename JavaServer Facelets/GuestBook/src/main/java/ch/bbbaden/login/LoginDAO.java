/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.login;

import ch.bbbaden.eintraege.Eintrag;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author ricky
 */
public class LoginDAO {

    public User check(String user, String password) throws JDOMException, IOException {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        path = path + "WEB-INF\\benutzer.xml";

        Document doc = new SAXBuilder().build(path);
        //Zugriff auf Root
        Element benutzer = doc.getRootElement();

        //Liste der Kindelemente
        List list = benutzer.getChildren("benutzer");
        for (int i = 0; i < list.size(); i++) {

            //Zugriff auf i-tes Element
            Element nodeName = (Element) list.get(i);

            if (user.equals(nodeName.getChildText("benutzerName")) && password.equals(nodeName.getChildText("passwordUser"))) {
                return new User(user, password);
            }

        }
        return null;

    }

    public static List<Eintrag> getData() throws JDOMException, IOException {
        List<Eintrag> eintraege = new ArrayList();
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        path = path + "WEB-INF\\gaestebuch.xml";

        Document doc = new SAXBuilder().build(path);
        //Zugriff auf Root
        Element gaestebuch = doc.getRootElement();

        //Liste der Kindelemente
        List listEintrag = gaestebuch.getChildren("eintrag");

        for (int i = 0; i < listEintrag.size(); i++) {
            Element child = (Element) listEintrag.get(i);
            Eintrag eintrag = new Eintrag(child.getChildText("eintragID"), child.getChildText("eintragName"), child.getChildText("eintragDatum"), child.getChildText("eintragNachricht"));
            eintraege.add(eintrag);

        }

        return eintraege;

    }
}