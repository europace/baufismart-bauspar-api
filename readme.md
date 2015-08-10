# EUROPACE Bauspar API Dokumentation
============================

## Offene fachliche Fragen aus Entwicklersicht

* Warum wird beim Zuteilungsdatum (Anfrage und Antwort) zwischen Laufzeit und Termin differenziert? Reicht nicht Termin als Feld?

## TODO

* Excel Feldbeschreibung einbinden
* REST Messages und URLs beschreiben
* Beispielkommunikation einbinden
* Schnittstellenversionierung definieren und beschreiben
* Dokumente-SST muss Angebotsdaten mitgeliefert bekommen
* Dokumente Antwort um Unvollständigkeits Meldung (für Loggingzwecke) ergänzen


## Beschreibung.

Eine Schnittstelle zur Einbindung von Bausparangeboten als Tilgungsersatzprodukt und zur Zinsabsicherung in eine Finanzierung.
Ziel der Schnittstelle ist es, Angebote von verschiedenen Bausparkassen in Europace anzubieten. Die Schnittstelle wird als REST-Schnittstelle
(Representational State Transfer) realisiert. Die Schnittstelle beschreibt einen standardisierten Prozess zur Berechnung und Integration von
Bausparprodukten in EUROPACE.  

## Technik

Die Kommunikation erfolgt über HTTP/S und REST (Representational State Transfer). Zur Absicherung und Verschlüsselung wird SSL eingesetzt. Die Daten werden im JSON-Format übertragen. Die Lieferung von Dokumenten zu den berechneten Bausparangeboten erfolgt asynchron.

## Prozess

Als ersten Schritt schickt EUROPACE den Bausparwunsch an die durch die jeweilige Bausparkasse bereitzustellende Schnittstelle. Die Berechnung des Bausparangebots erfolgt bei der Bausparkasse.
An EUROPACE wird das berechnete Bausparangebot inkl. der benötigten ausgefüllten Dokumente zurückgeliefert. EUROPACE fügt das Bausparangebot in die Finanzierung ein.

Der Schnittstellenprozess ist zustandslos, das bedeutet bei jedem Methodenaufruf werden alle relevanten Daten mitgesendet.
Die Schnittstellenimplementierung muss sich keine Zwischenergebnisse merken.

Der Prozess gestaltet sich im Detail wie folgt:

1) Die von der Bausparkasse bereitgestellten Tarife werden von EUROPACE unter der URL `http://host/europace/v1/bauspartarife/` mit einem GET Befehl abgefragt. Daraus folgt: Es muss eine REST Resource mit der Tarifliste
bereitgestellt werden.

2) Anhand der Tarifliste und der Finanzierunganfrage werden REST-Anfragen an die Berechnungsschnittstelle unter der URL `http://host/europace/v1/bausparangebot/` mit einem POST Befehl gesendet. Es wird erwartet, dass ein Angebot pro Anfrage berechnet wird. Kann kein annehmbares Angebot berechnet werden, so werden dem Angebot Meldungen beigefügt, die es dem Nutzer ermöglichen, die Anfrage so anzupassen, dass ein Angebot berechnet werden kann.

3) Für ein berechnetes Angebot werden über eine weitere REST-Anfrage unter der URL `http://host/europace/v1/dokumente/` mit einem GET Befehl die zum Angebot generierten Dokumente geholt. 

Weitere Informationen und eine genauere Beschreibung der REST-Schnittstelle sowie die Beschreibung der Daten werden in Beispiel Aufrufen und weiteren Tabellen dargestellt.
  
## Schnittstellendesign

**TODO** Durch echte Schemabeschreibung ersetzen mit Hinweis auf Excel und Swagger in Prototyp

Die Schnittstelle wird über REST URLs dargestellt, die Nachrichten im JSON Format empfangen und zurückliefern. Das genaue Format ist in diesem Projekt definiert.

### Schnittstellenresource GET /bauspartarife/

    {
       "tarife": [
         {
           "id": "string",
           "name": "string"
         }
      ]
    }


#### Felder Antwort

| Feld   | Typ    | Beschreibung |
| id     | String | Eine innerhalb der Schnittstelle eindeutige technische Id des Tarifs |
| name   | String | Der Name des Tarifs so wie er auf Nutzerfrontends und in Dokumenten verwendet wird|

### Schnittstellenressource POST /bausparangebot/


#### Anfrage

      {
        "abschlussgebuehrenbehandlung": "VERRECHUNG",
x        "auszahlungsbetragBeiZuteilung": 50000,
x        "bausparsummeInEuro": 50000,
x        "berechnungsZiel": "SPARBEITRAG_INKL_VL",
        "darlehensWunsch": "MIT_DARLEHEN",
        "laufzeitBisZuteilungInMonaten": 112,
        "requestId": "XAJNvEbn",
x        "sparBeitraege": [
x          {
x            "beitrag": 150,
x            "zahlungAb": "2015-09-01",
x            "zahlungBis": "2025-12-31",
x            "zahlungsrhythmus": "MONATLICH"
x          }
x        ],
        "tilgungsBeitrag": {
          "rateInEuro": 150,
          "zahlungsrhythmus": "MONATLICH"
        },
        "vermittlerNr": "A123456",
x        "zielTarif": "T1",
x        "zuteilungstermin": "2026-01-01"
      }

| Feld                          | Typ           | Beschreibung |
| zielTarif                     | String        | Die technische Tarif ID, so wie sie von GET /tarife geliefert wird. |
| berechnungsZiel               | Auflistung    | Mögliche Werte: ``SPARBEITRAG_INKL_VL``, ``BAUSPARSUMME``, ``ZUTEILUNGSTERMIN``, ``LAUFZEIT_BIS_ZUTEILUNG`` |
| bausparSummeInEuro            | Zahl          | Gewünschte Bausparsumme in Euro |
| auszahlungsbetragBeiZuteilung | Zahl          | Der Betrag des Bausparvertrags der bei Zuteilung ausgezahlt wird in Euro |
| laufzeitBisZuteilungInMonaten | Zahl          | Die Anzahl Monate zwischen Vertragsbeginn und Zuteilungsdatum. Entweder wird dieses Feld oder ``zuteilungstermin`` geliefert.|
| zuteilungstermin              | Datum         | Das gewünschte Zuteilungsdatum. Alternativ kann ``aufzeitBisZuteilungInMonaten`` geliefert werden. |
| sparBeitraege                 | Liste         | Ermöglicht die Erfassung mehrerer unterschiedlicher Sparzahlungen oder Einmalzahlungen. |
| sparBeitraege[i].beitrag      | Zahl          | Der Sparbeitrag dieser Zahlung ein Euro. |
| sparBeitraege[i].zahlungAb    | Datum         | Der Startzeitpunkt ab dem dieser Sparbeitrag geleistet wird. |
| sparBeitraege[i].zahlungBis   | Datum         | Der letzte Zeitpunkt bis zu dem dieser Sparbeitrag geleistet wird. |
| sparBeitraege[i].zahlungsrhythmus | Auflistung | Legt fest, in welchen Intervallen dieser Sparbeitrag gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |

#### Antwort

      {
        "berechnetesBausparAngebot": {
          "abschlussgebuehr": {
            "abschlussgebuehrBetragInEuro": 0,
            "abschlussgebuehrHoeheInProzent": 0,
            "abschlussgebuehrenbehandlung": "VERRECHUNG"
          },
          "bausparDarlehen": {
            "darlehenslaufzeitInMonaten": 0,
            "effektiverJahreszinsInProzent": 0,
            "hoeheBauspardarlehenInEuro": 0,
            "sollzinsInProzent": 0,
            "tilgungsPlan": {
              "zahlungen": [
                {
                  "datum": "string",
                  "gebuehrenInEuro": 0,
                  "kontofuehrungsGebuehrInEuro": 0,
                  "saldoNachZahlungInEuro": 0,
                  "tilgungInEuro": 0,
                  "zahlungInEuro": 0,
                  "zinsInEuro": 0
                }
              ]
            },
            "tilgungsende": "string",
            "zahlungsBeitragTilgungsRateInEuro": 0,
            "zahlungsrhythmus": "MONATLICH"
          },
          "bausparsummeInEuro": 0,
          "berechnungsziel": "SPARBEITRAG_INKL_VL",
          "gesamtlaufzeitKomplettInMonaten": 0,
          "gesamtleistungKomplettInEuro": 0,
          "kontogebuehrJaehrlichInEuro": 0,
          "laufzeitBisZuteilungInMonaten": 0,
          "meldungen": [
            {
              "status": "HINWEIS",
              "text": "string",
              "zuordnung": "DARLEHENSNEHMER1"
            }
          ],
          "sparPhase": {
            "bonuszinsBetragInEuro": 0,
            "bonuszinsInProzent": 0,
            "gesamtleistungSparphaseInEuro": 0,
            "guthabenBeiZuteilungInEuro": 0,
            "guthabenzinsBetragInEuro": 0,
            "guthabenzinsInProzent": 0,
            "regelsparbeitragInEuro": 0,
            "sparPlan": {
              "zahlungen": [
                {
                  "abgeltungsSteuerInEuro": 0,
                  "datum": "string",
                  "gebuehrenInEuro": 0,
                  "kontofuehrungsGebuehrInEuro": 0,
                  "saldoNachZahlungInEuro": 0,
                  "zahlungInEuro": 0,
                  "zinsInEuro": 0
                }
              ]
            },
            "zahlungsrhythmus": "MONATLICH"
          },
          "sparbeitragInEuro": 0,
          "tarif": "string",
          "vertragsBeginn": "string",
          "zahlungsbetragEinmalzahlungInEuro": 0,
          "zuteilungsTermin": "string"
        }
      }

EUROPACE definiert das Schema für die Schnittstelle. Jede Bausparkasse stellt sicher, dass ihre Schnittstelle nach dem definierten
Standard-Schema arbeitet. Die Daten, die über diese Schnittstelle ausgetauscht werden umfassen in der Anfrage Daten zum Bausparwunsch,
zum Antragsteller und zum Vertrieb. Die Antwort enthält einen vollständig berechneten Bausparvertrag inkl. Sparplan, sowie die Berechnung
des Bauspardarlehens inkl. Tilgungsplan. Eine erste Auflistung der Daten befindet sich im Anhang. Die genannten Datenfelder stellen einen
Rahmen, der nach aktueller Einschätzung erforderlichen Datenfelder dar (zum aktuellen Zeitpunkt kann nicht ausgeschlossen werden, dass
einzelne Felder im Rahmen der Detaildefinition des Schemas hinzugefügt oder entfernt werden). Feldformate und Details werden im
Projektverlauf durch Hypoport/EUROPACE definiert.


EUROPACE definiert das Schema für die Schnittstelle. Jede Bausparkasse stellt sicher, dass ihre Schnittstelle nach dem definierten
Standard-Schema arbeitet. Die Daten, die über diese Schnittstelle ausgetauscht werden umfassen in der Anfrage Daten zum Bausparwunsch,
zum Antragsteller und zum Vertrieb. Die Antwort enthält einen vollständig berechneten Bausparvertrag inkl. Sparplan, sowie die Berechnung
des Bauspardarlehens inkl. Tilgungsplan. Eine erste Auflistung der Daten befindet sich im Anhang. Die genannten Datenfelder stellen einen
Rahmen, der nach aktueller Einschätzung erforderlichen Datenfelder dar (zum aktuellen Zeitpunkt kann nicht ausgeschlossen werden, dass
einzelne Felder im Rahmen der Detaildefinition des Schemas hinzugefügt oder entfernt werden). Feldformate und Details werden im
Projektverlauf durch Hypoport/EUROPACE definiert.

**Festlegungen:**

Prozentwerte werden 100-basiert übertragen. 1% wird als 1.0 übertragen, 100% als 100,0. Prozentwerte sind am Suffix InProzent am Attributnamen erkennbar.
Geldbeträge werden als reine Zahlwerte mit 2 Nachkommastellen übertragen. Die Währung ist immer Euro. Am Geldbeträge sind am Suffix InEuro erkennbar.


## Abwärtskompatiblität

Änderungen an der Schnittstelle bzw. am Schema der Schnittstelle müssen abwärtskompatibel umgesetzt werden. Falls es im Rahmen von Weiterentwicklungen zu Änderungen an der Schnittstelle kommt, sollten diese in einem definierten Zeitraum durch alle Bausparkassen umgesetzt werden.

## Security

Die Sicherheitsvorkehrungen entsprechen dem Standard SSL über HTTPS unter Verwendung von Client- und Server- Zertifikaten mit Freischaltung der IP-Adressen.

## Nichtfunktionale Anforderungen

Die Antwortzeiten vom Absenden des Request bis zum Erhalt der Antwort (ausgenommen Dokumente, die asynchron nachgeliefert werden können) liegen unterhalb von 500 ms, damit dem Anwender das Bausparangebot ohne bemerkbare Verzögerung angezeigt werden kann.
Die Schnittstelle muss in der Lage sein eine erwartete Last von bis zu 10 Requests pro Sekunde zu verarbeiten. Die Schnittstelle muss grundsätzlich 24 Stunden an allen Wochentagen verfügbar sein. Ausgenommen hiervon sind Wartungsintervalle die außerhalb der Geschäftszeiten liegen. Beeinträchtigungen im Betrieb der Plattform durch Wartungsarbeiten können so vermieden werden.


