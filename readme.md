# EUROPACE Bausspar API Dokumentation
============================

## Offene fachliche Fragen aus Entwicklersicht

* Warum wird beim Zuteilungsdatum (Anfrage und Antwort) zwischen Laufzeit und Termin differenziert? Reicht nicht Termin als Feld?

## TODO

* Excel Feldbeschreibung einbinden
* Schnittstellen -usecases/-interaktionen beschreiben
* REST Messages und URLs beschreiben
* Beispielkommunikation einbinden
* Entscheiden, ob und wie Default Impl Teil der Schnittstellenbeschreibung wird
* Technikdokument unten anpassen für Schnittstellenbeschreibung
* Schnittstellenversionierung definieren und beschreiben



## Beschreibung.
Eine Schnittstelle zur Einbindung von Bausparangeboten als Tilgungsersatzprodukt und zur Zinsabsicherung in eine Finanzierung.
Ziel der Schnittstelle ist es Angebote von verschiedenen Bausparkasse in Europace anzubieten. Die Schnittstelle wird als REST-Schnittstelle 
(Representational State Transfer) realisiert. Die Schnittstelle beschreibt eine standardisierte Prozess zur Berechnung und Integration von 
Bausparprodukten in EUROPACE.  

## Prozess

Schritt EUROPACE schickt den Bausparwunsch an die durch die jeweilige Bausparkasse bereitzustellende Schnittstelle. Die Berechnung des Bausparangebots erfolgt bei der Bausparkasse. 
An EUROPACE wird das berechnete Bausparangebot inkl. der benötigten ausgefüllten Dokumente zurückgeliefert. EUROPACE fügt das Bausparangebot in die Finanzierung ein.

Der Schnittstellen Prozess ist Zustandslos, dass bedeutet bei jedem Methodenaufruf werden alle relevanten Daten mitgesendet.
Die Schnittstellen Implementierung muss sich keine Zwischenergebnisse merken.

Der Prozess gestaltet sich im Detail wie folgt:

1) Die von der Bausparkasse bereitgestellten Tarife werden von EUROPACE abgefragt. Daraus folgt es muss eine REST Resource mit der Tarifliste 
bereitgestellt werden.

2) Anhand der Tarifliste und der Finanazierunganfrage werden Rest-Anfragen an die Berechnungsschnittstelle gesendet. Es wird erwartet, das ein Angebot pro Anfrage berechnet wird. Kann kein Angebot berechnet werden gibt es die Möglichkeit 
einfach keine Antwort zu senden. Oder ein Angebot mit Meldungen die es dem Nutzer ermöglichen die Anfrage so anzupassen, das ein Angebit berechnet werden kann. 

3) Für ein berechnetes Angebot werden über eine weitere REST-Anfrage die Dokumente zum Angebot generiert. 

Weitere Information und genauer Beschreibung der REST-Schnittstelle so wie die Beschreibung der Daten werden in Beispiel Aufrufen und weiteren Tabellen dargetsellt.
  
## Schnittstellendesign

**TODO** Durch echte Schemabeschreibung ersetzen mit Hinweis auf Excel und Swagger in Prototyp

EUROPACE definiert das Schema für die Schnittstelle. Jede Bausparkasse stellt sicher, dass ihre Schnittstelle nach dem definierten  Standard-Schema arbeitet. Die Daten, die über diese Schnittstelle ausgetauscht werden umfassen in der Anfrage Daten zum Bausparwunsch, zum Antragsteller und zum Vertrieb. Die Antwort enthält einen vollständig berechneten Bausparvertrag inkl. Sparplan, sowie die Berechnung des Bauspardarlehens inkl. Tilgungsplan. Eine erste Auflistung der Daten befindet sich im Anhang. Die genannten Datenfelder stellen einen Rahmen, der nach aktueller Einschätzung erforderlichen Datenfelder dar (zum aktuellen Zeitpunkt kann nicht ausgeschlossen werden, dass einzelne Felder im Rahmen der Detaildefinition des Schemas hinzugefügt oder entfernt werden). Feldformate und Details werden im Projektverlauf durch Hypoport/EUROPACE definiert.

**Festlegungen:**

Prozentwerte werden 100-basiert übertragen. 1% wird als 1.0 übertragen, 100% als 100,0. Prozentwerte sind am Suffix InProzent am Attributnamen erkennbar.
Geldbeträge werden als reine Zahlwerte mit 2 Nachkommastellen übertragen. Die Währung ist immer Euro. Am Geldbeträge sind am Suffix InEuro erkennbar.

## Technik

Die Kommunikation erfolgt über HTTP/S und REST (Representational State Transfer). Zur Absicherung und Verschlüsselung wird SSL eingesetzt. Die Daten werden im JSON-Format übertragen. Die Lieferung von Dokumenten zu den berechneten Bausparangeboten erfolgt asynchron.

## Abwärtskompatiblität

Änderungen an der Schnittstelle bzw. am Schema der Schnittstelle müssen abwärtskompatibel umgesetzt werden. Falls es im Rahmen von Weiterentwicklungen zu Änderungen an der Schnittstelle kommt, sollten diese in einem definierten Zeitraum durch alle Bausparkassen umgesetzt werden.

## Security

Die Sicherheitsvorkehrungen entsprechen dem Standard SSL über HTTPS, Client- und Server- Zertifikate mit Freischaltung der IP-Adressen.

## Nichtfunktionale Anforderungen

Die Antwortzeiten vom Absenden des Request bis zum Erhalt der Antwort (ausgenommen Dokumente, die asynchron nachgeliefert werden können) liegen unterhalb von 500 ms, damit dem Anwender das Bausparangebot ohne bemerkbare Verzögerung angezeigt werden kann.
Die Schnittstelle muss in der Lage sein eine erwartete Last von bis zu 10 Requests pro Sekunde zu verarbeiten. Die Schnittstelle muss grundsätzlich 24 Stunden an allen Wochentagen verfügbar sein. Ausgenommen hiervon sind Wartungsintervalle die außerhalb der Geschäftszeiten liegen. Beeinträchtigungen im Betrieb der Plattform durch Wartungsarbeiten können so vermieden werden.


