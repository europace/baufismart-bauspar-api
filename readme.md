

# Schnittstellenbeschreibung Europace Bausparvertragberechnungsschnittstelle

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

Eine Schnittstelle zur Einbindung von Bausparangeboten als Tilgungsersatzprodukt und zur Zinsabsicherung in eine Finanzierung


## Prozess

**TODO** Detaillieren

EUROPACE schickt den Bausparwunsch an die durch die jeweilige Bausparkasse bereitzustellende Schnittstelle. Die Berechnung des Bausparangebots erfolgt bei der Bausparkasse. An EUROPACE wird das berechnete Bausparangebot inkl. der benötigten ausgefüllten Dokumente zurückgeliefert. EUROPACE fügt das Bausparangebot in die Finanzierung ein.

## Schnittstellendesign

**TODO** Durch echte Schemabeschreibung ersetzen mit Hinweis auf Excel und Swagger in Prototyp

EUROPACE definiert das Schema für die Schnittstelle. Jede Bausparkasse stellt sicher, dass ihre Schnittstelle nach dem definierten  Standard-Schema arbeitet. Die Daten, die über diese Schnittstelle ausgetauscht werden umfassen in der Anfrage Daten zum Bausparwunsch, zum Antragsteller und zum Vertrieb. Die Antwort enthält einen vollständig berechneten Bausparvertrag inkl. Sparplan, sowie die Berechnung des Bauspardarlehens inkl. Tilgungsplan. Eine erste Auflistung der Daten befindet sich im Anhang. Die genannten Datenfelder stellen einen Rahmen, der nach aktueller Einschätzung erforderlichen Datenfelder dar (zum aktuellen Zeitpunkt kann nicht ausgeschlossen werden, dass einzelne Felder im Rahmen der Detaildefinition des Schemas hinzugefügt oder entfernt werden). Feldformate und Details werden im Projektverlauf durch Hypoport/EUROPACE definiert.

## Technik

**TODO** Relevanz prüfen

Hypoport/EUROPACE präferiert für die Implementierung der Schnittstelle das technische Format HTTP/S – REST – Style (JSON). Alternativ ist die Implementierung eines Webservices möglich. Da es sich um einen durch alle Projektbeteiligten zu definierenden Standard handelt, ist es notwendig, dass die beteiligten Bausparkassen sich einigen, welche der beschriebenen technischen Möglichkeiten verwendet wird.
Die Lieferung von Dokumenten zu den berechneten Bausparangeboten erfolgt  asynchron.

## Abwärtskompatiblität

Änderungen an der Schnittstelle bzw. am Schema der Schnittstelle müssen abwärtskompatibel umgesetzt werden. Falls es im Rahmen von Weiterentwicklungen zu Änderungen an der Schnittstelle kommt, sollten diese in einem definierten Zeitraum durch alle Bausparkassen umgesetzt werden.

## Security

**TODO** Reicht das aus?

Die Sicherheitsvorkehrungen entsprechen dem Standard HTTPS, Client- und Server- Zertifikat mit Freischaltung der IP-Adressen.

## Nichtfunktionale Anforderungen
Die Antwortzeiten vom Absenden des Request bis zum Erhalt der Antwort (ausgenommen Dokumente, die asynchron nachgeliefert werden können) liegen unterhalb von 500 ms, damit dem Anwender das Bausparangebot ohne bemerkbare Verzögerung angezeigt werden kann.
Die Schnittstelle muss in der Lage sein eine erwartete Last von bis zu 10 Requests pro Sekunde zu verarbeiten. Die Schnittstelle muss grundsätzlich 24 Stunden an allen Wochentagen verfügbar sein. Ausgenommen hiervon sind Wartungsintervalle die außerhalb der Geschäftszeiten liegen.  Beeinträchtigungen im Betrieb der Plattform durch Wartungsarbeiten können so vermieden werden.

## Systeme

Neben dem Produktivsystem wird ein stabiles Testsystem benötigt. Die Weiterentwicklung sollte auf eigens dafür vorgesehen Entwicklungssystemen erfolgen, um die Stabilität des Testsystems zu gewährleisten.

## Implementierungsphase

**TODO** Relevanz prüfen

In der Implementierungsphase setzt Hypoport/EUROPACE auf ein agiles Vorgehen, welches eine enge Kommunikation der Experten voraussetzt. Die Entwicklung sollte zwischen den Beteiligten so abgestimmt sein, dass frühe Tests eine zielführende Implementierung sicherstellen. Ein „aneinander vorbei Entwicklen“ wird so vermieden.
