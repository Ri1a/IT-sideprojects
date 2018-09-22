# Pokemon Go Avatar Creator

Here's a website created with JavaServer Faces.

#### Note:

You need to open the pokemongo.xhtml in /src/main/webapp and run it with a server (glassfish server approved).

To choose from options we need images. The filename is named like this:

1. d or h.png = skin color
2. b or g.png = eye color
3. s or b.png = hair color

As an example: you choose the skincolor d. The website is using the file d.png. If you now choose the eye color b, the website is using the file bd.png.

## Important Snippets

Snippet from the file "pokemongo.xhtml".

```java
    <h:body>
        <h1>Erstelle deinen eigenen Avatar</h1>
        <p>Wähle deinen Look. Klicke auf eines der Bilder:</p>
        <h:form>
            <h:commandLink action="#{navigationBean.indexPage}" >
                <f:setPropertyActionListener target="#{verwaltungBean.bild}" value="d"/>
                <h:graphicImage library="img" name="d.png"/>
            </h:commandLink>
            <h:commandLink action="#{navigationBean.indexPage}">
                <f:setPropertyActionListener target="#{verwaltungBean.bild}" value="h" />
                <h:graphicImage library="img" name="h.png"/>
            </h:commandLink>
        </h:form>
        <br />
    </h:body>
```

Here the first option from the user is being processed.

Snippet from the file "VerwaltungBean.java".

```java
@Named(value = "verwaltungBean")
@SessionScoped
public class VerwaltungBean implements Serializable {
    
    private String bild = ".png";
    private String farbe;
    private String haare;

    public String getBild() {
        return bild;
    }

    public void setBild(String parameter) {
        this.bild = parameter + bild;
    }
    
    public String getFarbe() {
        return farbe;
    }
    
    public void setFarbe(String farbe) {
        this.farbe = farbe + bild;
    }
    
    public String getHaare() {
        return haare;
    }
    
    public void setHaare(String haare) {
        this.haare = haare + farbe;
    }


}
```

Here are the "dynamic" images created. You can choose with hair and eye color you want, so we need images with one and another option. Here you get the chosen option and create the image.