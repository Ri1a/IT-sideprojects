# Guestbook

This website was created with JSF. User/pass: benutzer1/123

## Documentation (German)

## Ausgangslage

Im Modul 133 «Web-Applikation mit Session-Handling realisieren» lernten wir Java Server Facelets kennen. Dieses Modul befasst sich hauptsächlich mit Sessions. Unter anderem behandelten wir auch das Thema "XSS" und wie wir bösartigem Javascriptcode keine Chance geben.

Mit diesem Auftrag wurden sozusagen alle Handlungsziele vertieft:

- HZ1: Vorgabe analysieren, Funktionalität entwerfen und Realisierungsschritte festlegen.
- HZ2: Konzept für die Realisierung erarbeiten und für die Tests einen Testplan erstellen.
- HZ3: Formularüberprüfungen mit client- und serverseitigen Scripts realisieren.
- HZ4: Web-Applikation mit einer Scriptsprache (PHP, ASP) und/oder einer Programmiersprache (JAVA) unter Berücksichtigung sicherheitsrelevanter Anforderungen programmieren.
- HZ6: Quellcode zur Gewährleistung der Wartbarkeit kommentieren. 
 

## Aufgabenstellung

Ausgehend von den bisherigen Login-Aufträgen wird die Startseite der Applikation um das Darstellen von Gästebucheinträgen erweitert. Der Auftrag dient der Übung von JDOM und den Zugriff aus der View auf eine Ergebnismenge.

- Erstellen Sie eine wohlgeformte XML-Datei mit Einträgen eines Gästebuchs (ID-Eintrag, Name, Datum & Uhrzeit, Nachricht). Erstellen Sie Daten für mindestens drei Einträge. Legen Sie die Datei im WEB-INF-Order ab.
- Erstellen Sie eine Eintrag-Klasse mit den obengenannten Attributen und passenden settern/gettern.
- Erweitern Sie Ihre LoginDAO-Klasse um die Methode public List getData(). Die Methode liefert eine List<Eintrag> mit allen Einträgen aus dem XML-Dokument.
- Erstellen Sie in der LoginUserBean-Klasse ein Attribut vom Typ List<Eintrag> und einen getter, der auf die DAOLogin-Methode getData() zugreift.
- Erweitern Sie Ihre Start-View insoweit, dass zusätzlich alle Einträge des XML-Dokuments dargestellt werden. Nutzen Sie das dataTable-Tag.

## Reflexion und Validierung

Dieser Auftrag war sehr lehrreich. Auch wenn es nach eher wenig aussieht, musste man vieles beachten. Bei diesem Auftrag habe ich gelernt wie man ein Login erstellt und dieses auch sicher ist (i.e. hardcoded credentials). Ausserdem wurde mit einem XML-file ein Guestbook eingebunden. Einträge kann man im XML selber erstellen und die Klasse LoginDAO kann sich nun die Informationen des XML-files holen. Ich verstehe nun sehr gut wie eine JSF-Webseite aufgebaut ist.

Es gab kleinere Probleme mit der Darstellung des Guestbooks. Im Tag "datatable" musste ich eine Variabel erstellen, um mit dieser auf die anderen Variabeln zugreifen zu können.