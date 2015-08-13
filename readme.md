# EUROPACE Bauspar API Dokumentation
============================

## Offene fachliche Fragen aus Entwicklersicht

* Warum wird beim Zuteilungsdatum (Anfrage und Antwort) zwischen Laufzeit und Termin differenziert? Reicht nicht Termin als Feld?

## TODO

* Beispielkommunikation einbinden
* Schnittstellenversionierung definieren und beschreiben


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

1) Die von der Bausparkasse bereitgestellten Tarife werden von EUROPACE unter der URL `http://host//europace-bausparen/v1/bauspartarife/` mit einem GET Befehl abgefragt. Daraus folgt: Es muss eine REST Resource mit der Tarifliste
bereitgestellt werden.

2) Anhand der Tarifliste und der Finanzierunganfrage werden REST-Anfragen an die Berechnungsschnittstelle unter der URL `http://host/europace-bausparen/v1/bausparangebot/` mit einem POST Befehl gesendet. Es wird erwartet, dass ein Angebot pro Anfrage berechnet wird. Kann kein annehmbares Angebot berechnet werden, so werden dem Angebot Meldungen beigefügt, die es dem Nutzer ermöglichen, die Anfrage so anzupassen, dass ein Angebot berechnet werden kann.

3) Für ein berechnetes Angebot werden über eine weitere REST-Anfrage unter der URL `http://host/europace-bausparen/v1/dokumente/` mit einem GET Befehl die zum Angebot generierten Dokumente geholt. 

Weitere Informationen und eine genauere Beschreibung der REST-Schnittstelle sowie die Beschreibung der Daten werden in Beispiel Aufrufen und weiteren Tabellen dargestellt.


## Schnittstellenprototyp

In diesem Github Projekt existiert ein minimaler Schnittstellenprototyp, der Anfragen im beschriebenen Schnittstellenformat annimmt und Minimalantworten zurücksendet. Gleichzeitig ist
eine interaktive Dokumentation des Schnittstellenformats über SwaggerUI eingebunden. Voraussetzung zum Übersetzen und Ausführen des Prototyps ist eine Internetverbindung und das Java 8 JDK
( http://www.oracle.com/technetwork/java/javase/downloads/index.html ).

Das Prototyp Projekt ist in Java implementiert. Es benutzt Spring Boot als Container und Gradle als Buildsystem.

Aus dem Projektverzeichnis läßt es sich mit dem Befehl ``$ ./gradlew run`` übersetzen und ausführen.


## Schnittstellendesign

EUROPACE definiert das Schema für die Schnittstelle. Jede Bausparkasse stellt sicher, dass ihre Schnittstelle nach dem definierten
Standard-Schema arbeitet. Die Daten, die über diese Schnittstelle ausgetauscht werden umfassen in der Anfrage Daten zum Bausparwunsch,
zum Antragsteller und zum Vertrieb. Die Antwort enthält einen vollständig berechneten Bausparvertrag inkl. Sparplan, sowie die Berechnung
des Bauspardarlehens inkl. Tilgungsplan. Eine erste Auflistung der Daten befindet sich im Anhang. Die genannten Datenfelder stellen einen
Rahmen, der nach aktueller Einschätzung erforderlichen Datenfelder dar (zum aktuellen Zeitpunkt kann nicht ausgeschlossen werden, dass
einzelne Felder im Rahmen der Detaildefinition des Schemas hinzugefügt oder entfernt werden).

Die Schnittstelle wird über REST URLs dargestellt, die Nachrichten im JSON Format empfangen und zurückliefern. Das genaue Format ist in diesem Projekt definiert.

**Festlegungen:**
Prozentwerte werden 100-basiert übertragen. 1% wird als 1.0 übertragen, 100% als 100,0. Prozentwerte sind am Suffix InProzent am Attributnamen erkennbar.
Geldbeträge werden als reine Zahlwerte mit 2 Nachkommastellen übertragen. Die Währung ist immer Euro. Alle Geldbetrag-Attribute sind am Suffix InEuro erkennbar.
Datumsangaben werden als Zeichenketten im Format yyyy-mm-dd übertragen.


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

| Feld   | Typ    | Beschreibung 																	  |
|--------|--------|-----------------------------------------------------------------------------------|
| id     | String | Eine innerhalb der Schnittstelle eindeutige technische Id des Tarifs 			  |
| name   | String | Der Name des Tarifs so wie er auf Nutzerfrontends und in Dokumenten verwendet wird|

### Schnittstellenressource POST /bausparangebot/

Die Schnittstellenressource /bausparangebot erlaubt das Berechnen von Bausparangeboten. Vorläufig wird eine 1:1 Berechnung vorgesehen, d.h. eine Anfrage führt zu einem berechneten Angebot.
Fehlende Werte in der Anfrage sollten durch die Implementierung durch sinnvolle Standardwerte ergänzt werden. Die Schnittstelle kennt unterschiedliche Berechnungsziele, nach denen sich unterscheidet,
welche Inputdaten geliefert werden.

| Berechnungsziel        | Inputwerte                                                                        | Ergebniswerte                 |
|------------------------|-----------------------------------------------------------------------------------|-------------------------------|
| SPARBEITRAG_INKL_VL    | laufzeitBisZuteilungInMonaten oder zuteilungstermin, bausparsumme                 | Sparbeitrag, Tilgungsbeitrag  |
| BAUSPARSUMME           | laufzeitBisZuteilungInMonaten oder zuteilungstermin, Sparbeitrag, Tilgungsbeitrag | Bausparsumme                  |
| ZUTEILUNGSTERMIN       | Sparbeitrag, Bausparsumme                                                         | zuteilungstermin              |
| LAUFZEIT_BIS_ZUTEILUNG | Sparbeitrag, Bausparsumme                                                         | laufzeitBisZuteilungInMonaten |


Treten während der Berechnung Unstimmigkeiten auf, weil die Inputdaten nicht zum Tarif passen, z.B. aufgrund einer zu großen Bausparsumme, so soll die Schnittstelle
dies über fachliche Meldungen mitteilen. Hierfür sieht die Antwort das Feld Meldungen vor. Jede Meldung trägt einen Status, der die Auswirkung der Meldung anzeigt.

| Meldungsstatus                                     | Auswirkung                                                                                                                              |
|----------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| HINWEIS                                            | Keine, der Bausparvertrag ist in der berechneten Form abschließbar                                                                      |
| BERECHNUNG_NICHT_MOEGLICH_AUFGRUND_FEHLENDER_DATEN | Es fehlen Daten, um ein vollständiges Angebot zu erstellen. Nicht abschließbar. Berechnete Angebotsdaten u.U. nicht vollständig.        |
| VOLLSTAENDIGKEIT_DOKUMENT                          | Nur für /dokumente Schnittstelle relevant.                                                                                              |
| NICHT_MACHBAR                                      | Das Angebot konnte berechnet werden, ist aber aufgrund fachlicher Einschränkungen so nicht abschließbar. Beispiel: Sparrate zu niedrig. |
| TECHNISCHER_FEHLER                                 | Es ist ein technischer Fehler während der Berechnung aufgetreten. Das Angebot wird verworfen.                                           |




#### Anfrage

      {
        "abschlussgebuehrenbehandlung": "VERRECHUNG",
        "auszahlungsbetragBeiZuteilung": 50000,
        "bausparsummeInEuro": 50000,
        "berechnungsZiel": "SPARBEITRAG_INKL_VL",
        "darlehensWunsch": "MIT_DARLEHEN",
        "laufzeitBisZuteilungInMonaten": 112,
        "requestId": "XAJNvEbn",
        "sparBeitraege": [
          {
           "beitrag": 150,
            "zahlungAb": "2015-09-01",
            "zahlungBis": "2025-12-31",
            "zahlungsrhythmus": "MONATLICH"
          }
        ],
        "tilgungsBeitrag": {
          "rateInEuro": 150,
          "zahlungsrhythmus": "MONATLICH"
        },
        "vermittlerNr": "A123456",
        "zielTarif": "T1",
        "zuteilungstermin": "2026-01-01"
      }

| Feld                               | Typ           | Beschreibung |
|------------------------------------|---------------|--------------|
| zielTarif                          | String        | Die technische Tarif ID, so wie sie von GET /tarife geliefert wird. |
| berechnungsZiel                    | Auflistung    | Mögliche Werte: ``SPARBEITRAG_INKL_VL``, ``BAUSPARSUMME``, ``ZUTEILUNGSTERMIN``, ``LAUFZEIT_BIS_ZUTEILUNG`` |
| bausparSummeInEuro                 | Zahl          | Gewünschte Bausparsumme in Euro |
| auszahlungsbetragBeiZuteilung      | Zahl          | Der Betrag des Bausparvertrags der bei Zuteilung ausgezahlt wird in Euro |
| laufzeitBisZuteilungInMonaten      | Zahl          | Die Anzahl Monate zwischen Vertragsbeginn und Zuteilungsdatum. Entweder wird dieses Feld oder ``zuteilungstermin`` geliefert.|
| zuteilungstermin                   | Datum         | Das gewünschte Zuteilungsdatum. Alternativ kann ``laufzeitBisZuteilungInMonaten`` geliefert werden. |
| sparBeitraege                      | Liste         | Ermöglicht die Erfassung mehrerer unterschiedlicher Sparzahlungen oder Einmalzahlungen. |
| sparBeitraege[i].beitrag           | Zahl          | Der Sparbeitrag dieser Zahlung ein Euro. |
| sparBeitraege[i].zahlungAb         | Datum         | Der Startzeitpunkt ab dem dieser Sparbeitrag geleistet wird. |
| sparBeitraege[i].zahlungBis        | Datum         | Der letzte Zeitpunkt bis zu dem dieser Sparbeitrag geleistet wird. |
| sparBeitraege[i].zahlungsrhythmus  | Auflistung    | Legt fest, in welchen Intervallen dieser Sparbeitrag gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| tilgungsBeitrag.rateInEuro         | Zahl          | Höhe der Tilgungsrate(Zins und Tilgung des Darlehens)|
| tilgungsBeitrag.zahlungsrhythmus   | Auflistung    | Legt fest, in welchen Intervallen die Tilgungsrate gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| abschlussgebuehrenbehandlung       | Auflistung    | Wenn nicht vorgegeben, dann gibt die BSK die Abschlussgebührenverrechnung vor. Mögliche Werte sind: ``VERRECHUNG``, ``SOFORTZAHLUNG``. |
| darlehensWunsch                    | Auflistung    | Soll ein Bauspar- oder Zuteilungsdarlehen in Anspruch genommen werden? Mögliche Werte sind: ``MIT_DARLEHEN``, ``OHNE_DARLEHEN``. |
| vermittlerNr                       | String        | Die ID des Vermittlers im Europace System. |
| requestId                          | String        | Ordnet die Anfrage einer EUROPACE Anfrage für Loggingzwecke zu. |


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
          "vertragsBeginn": "2015-09-01",
          "zahlungsbetragEinmalzahlungInEuro": 0,
          "zuteilungsTermin": "string"
        }
      }

| Name                                                                  | Typ          | Beschreibung                                                                                                                                                      |
|-----------------------------------------------------------------------|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| tarif                                                                 | String       | der Tarif wird auf Seiten der BSK ermittelt                                                                                                                       |
| berechnungsZiel                                                       | Aufzählung   | Mögliche Werte: ``SPARBEITRAG_INKL_VL``, ``BAUSPARSUMME``, ``ZUTEILUNGSTERMIN``, ``LAUFZEIT_BIS_ZUTEILUNG``                                                       |
| bausparsummeInEuro                                                    | Zahl         | Betrag der Bausparsumme in Euro                                                                                                                                   |
| sparbeitragInEuro                                                     | Zahl         | Sparbeitrag                                                                                                                                                       |
| laufzeitBisZuteilungInMonaten                                         | Zahl         | Anzahl Monate bis zur Zuteilung                                                                                                                                   |
| zuteilungsTermin                                                      | Datum        | Zuteilungstermin                                                                                                                                                  |
| bausparDarlehen.hoeheBauspardarlehenInEuro                            | Zahl         | Höhe des Bauspardarlehens in Euro.                                                                                                                                |
| bausparDarlehen.zahlungsRhythmus                                      | Aufzählung   | Zahlungsrhythmus für die Tilgungsrate.  Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``.                 |
| bauparDarlehen.zahlungsBeitragTilgungsRateInEuro                     | Euro         | Höhe der Tilgungsrate(Zins und Tilgung des Darlehens pro angegebenen Rhythmus)                                                                                    |
| zahlungsbetragEinmalzahlungInEuro                                     | Zahl         | Einmalzahlung in Euro                                                                                                                                             |
| sparPhase.zahlungsRhythmus                                            | Aufzählung   | Zahlungsrhytmus für den Sparbeitrag.  Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``.                   |
| vertragsBeginn                                                        | Datum        |                                                                                                                                                                   |
| abschlussgebuehrenbehandlung                                          | Aufzählung   | Mögliche Werte sind: ``VERRECHUNG``, ``SOFORTZAHLUNG``.                                                                                                           |
| abschlussgebuehrHoeheInProzent                                        | Zahl         | Abschlussgebühr in Prozent                                                                                                                                        |
| abschlussgebuehrBetragInEuro                                          | Zahl         | Abschlussgebühr in Euro                                                                                                                                           |
| kontoGebuehrJaehrlichInEuro                                           | Zahl         |                                                                                                                                                                   |
| sparPhase.guthabenzinsInProzent                                       | Zahl         |                                                                                                                                                                   |
| sparPhase.guthabenzinsBetragInEuro                                    | Zahl         |                                                                                                                                                                   |
| sparPhase.bonuszinsInProzent                                          | Zahl         |                                                                                                                                                                   |
| sparPhase.bonuszinsBetragInEuro                                       | Zahl         |                                                                                                                                                                   |
| sparPhase.guthabenBeiZuteilungInEuro                                  | Zahl         |                                                                                                                                                                   |
| sparPhase.regelsparbeitragInEuro                                      | Zahl         |                                                                                                                                                                   |
| sparPhase.gesamtleistungSparphaseInEuro                               | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.sollzinsInProzent                                     | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.effektiverJahreszinsInProzent                         | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.darlehenslaufzeitInMonaten                            | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsende                                          | Datum        |                                                                                                                                                                   |
| gesamtleistungKomplettInEuro                                          | Euro         |                                                                                                                                                                   |
| gesamtlaufzeitKomplettInMonaten                                       | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan                                          | TILGUNGSPLAN | Jede einzelne Zahlung des Bauspardarlehens bis zur Vollablösung.                                                                                                  |
| bausparDarlehen.tilgungsPlan.zahlungen[].datum                        | Datum        |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[].gebuehrenInEuro              | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[].kontofuehrungsGebuehrInEuro  | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[].saldoNachZahlungInEuro       | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[].tilgungInEuro                | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[].zahlungInEuro                | Zahl         |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[].zinsInEuro                   | Zahl         |                                                                                                                                                                   |
| sparPhase.sparPlan                                                    | SPARPLAN     | Jede Zahlung in das Bausparkonto in der Sparphase.                                                                                                                |
| sparPhase.sparPlan.zahlungen[].datum                                  | Zahl         |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[].abgeltungsSteuerInEuro                 | Zahl         |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[].gebuehrenInEuro                        | Zahl         |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[].kontofuehrungsGebuehrInEuro            | Zahl         |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[].saldoNachZahlungInEuro                 | Zahl         |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[].zahlungInEuro                          | Zahl         | Die Sparrate                                                                                                                                                      |
| sparPhase.sparPlan.zahlungen[].zinsInEuro                             | Zahl         | Der Betrag an Guthabenzinsen der zu diesem Datum mit dem Bausparvertrag verrechnet wird.                                                                          |
| meldungen.text                                                        | STRING       | menschlich lesbare Fehlerbeschreibung   |                                                                                                                         |
| meldungen.status                                                      | Aufzählung   | Auswirkung der Meldung auf die Annehmbarkeit des Bausparantrags. Mögliche Werte: ``HINWEIS``, ``BERECHNUNG_NICHT_MOEGLICH_AUFGRUND_FEHLENDER_DATEN``, ``VOLLSTAENDIGKEIT_DOKUMENT``, ``NICHT_MACHBAR``, ``TECHNISCHER_FEHLER``.                                                                                       |
| meldungen.zuordnung                                                   | Aufzählung   | Zuordnung der Meldung zum Datenhaushalt des Frontends. Mögliche Werte: ``DARLEHENSNEHMER1``, ``DARLEHENSNEHMER2``, ``VORHABEN``.                                                  |


### Schnittstellenressource POST /dokumente/

Die Schnittstellenressource /dokumente erlaubt, die für den Abschluss des Bausparvertrages notwendigen Dokumente im PDF Format zu generieren und mit den Feldern aus der Anfrage automatisch vorauszufüllen.
Die automatische Feldausfüllung funktioniert nach dem best-effort Prinzip: Für den Fall, dass nicht alle zum Ausfüllen benötigten Felder mitgeliefert werden, wird ein teilausgefülltes Dokument geliefert.
Über das Feld "vollstaendigkeitsMeldungen" besteht die Möglichkeit, Nutzerfeedback über fehlende Angaben zu geben. Dies ist über das Feld "meldungen" auch bereits in der Berechnungsantwort möglich. Das Feld zuordnung erlaubt es dabei,
die fehlenden Daten grob dem Datenhaushalt des Frontends zuzuordnen.


##### Anfrage

    {
        "tarif": "T1",
        "bausparSummeInEuro": 50000,
        "auszahlungsbetragBeiZuteilung": 50000,
        "sparphaseDokument":
        {
            "regelsparbeitragInEuro": 168.33,
            "sparBeginnAb": "2015-09-30",
            "sparEnde": "2025-08-31",
            "zahlungsRhythmus": "MONATLICH"
        },
        "abschlussgebuehrenbehandlung": "SOFORTZAHLUNG",
        "abschlussgebuehrHoeheInEuro": 500,
        "zahlungsbetragEinmalzahlungInEuro" : 0,
        "antragsteller": [
        {
            "anrede": "HERR",
            "titel": null,
            "vorname": "Max",
            "nachName": "Muster",
            "geburtsDatum": null,
            "geburtsName": null,
            "staatsangehoerigkeit": "Deutsch",
            "adresse": 
            {
                "strasse": "Steinweg.",
                "hausNummer": "8",
                "wohnOrt": "Garmisch-Partenkirchen",
                "postleitzahl": "82475",
                "landWohnsitz": "DE"
            },
       "kontakt": 
       {
           "telefonNummer": null,
           "mobilNummer": null,
           "eMailAdresse": null
       },
       "familienStand": "LEDIG",
       "zahlungsDaten": 
           {
               "iban": null,
               "nameKreditInstitut": null,
               "zahlungsForm": "LASTSCHRIFT"
           }
       }],
       "vermittlerDaten": 
       {
           "nachName": null,
           "ort": null,
           "postleitzahl": null,
           "strasseHausnummer": null,
           "vorname": null
       }
    }


| Name                                                                  | Typ          | Beschreibung                                                                                                                                                      |
|-----------------------------------------------------------------------|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| tarif                                                                 | String       | der Tarif wird auf Seiten der BSK ermittelt                                                                                                                       |
| bausparsummeInEuro                                                    | Zahl         | Betrag der Bausparsumme in Euro                                                                                                                                   |
| auszahlungsbetragBeiZuteilung                                         | Zahl         | Auszahlungssumme                                                                                                                                                  |
| sparphaseDokument.regelsparbeitragInEuro                              | Zahl         | Sparbeitrag                                                                                                                                                       |
| sparphaseDokument.sparBeginnAb                                        | Datum        | Sparbeginn                                                                                                                                                        |
| sparphaseDokument.sparEnde                                            | Datum        | Ende Sparphase                                                                                                                                                    |
| sparphaseDokument.sparBeginnAb                                        | Datum        | Sparbeginn                                                                                                                                                        |
| abschlussgebuehrenbehandlung                                          | Aufzählung   | Mögliche Werte sind: ``VERRECHUNG``, ``SOFORTZAHLUNG``.                                                                                                           |
| abschlussgebuehrHoeheInEuro                                           | Zahl         | Abschlußgebühr                                                                                                                                                    |
| zahlungsbetragEinmalzahlungInEuro                                     | Zahl         | Einmalzahlung in Euro                                                                                                                                             |
| antragsteller.anrede                                                  | Aufzählung   | Mögliche Werte sind: ``HERR``, ``FRAU``.                                                                                                                          |
| antragsteller.titel                                                   | String       | Titel                                                                                                                                                             |
| antragsteller.vorname                                                 | String       | Vorname                                                                                                                                                           |
| antragsteller.nachname                                                | String       | Nachname                                                                                                                                                          |
| antragsteller.geburtsDatum                                            | Datum        |                                                                                                                                                                   |
| antragsteller.geburtsName                                             | String       |                                                                                                                                                                   |
| antragsteller.staatsangehoerigkeit                                    | String       |                                                                                                                                                                   |
| antragsteller.adresse.strasse                                         | String       |                                                                                                                                                                   |
| antragsteller.adresse.hausNummer                                      | String       |                                                                                                                                                                   |
| antragsteller.adresse.postleitzahl                                    | String       |                                                                                                                                                                   |
| antragsteller.adresse.wohnOrt                                         | String       |                                                                                                                                                                   |
| antragsteller.adresse.landWohnsitz                                    | String       |                                                                                                                                                                   |
| antragsteller.kontakt.telefonNummer                                   | String       |                                                                                                                                                                   |
| antragsteller.kontakt.mobilNummer                                     | String       |                                                                                                                                                                   |
| antragsteller.kontakt.eMailAdresse                                    | String       |                                                                                                                                                                   |
| antragsteller.familienStand                                           | Aufzählung   | Mögliche Werte sind: ``LEDIG``, ``VERHEIRATET``,  ``LEBENSPARTNER``, ``GESCHIEDEN``, ``VERWITWET``, ``GETRENNT_LEBEND``.                                          |
| antragsteller.zahlungsDaten.iban                                      | String       |                                                                                                                                                                   |
| antragsteller.zahlungsDaten.nameKreditInstitut                        | String       |                                                                                                                                                                   |
| antragsteller.zahlungsDaten.zahlungsForm                              | Aufzählung   | Mögliche Werte sind: ``LASTSCHRIFT``, ``UEBERWEISUNG``.                                                                                                           |
| vermittlerDaten.nachName                                              | String       |                                                                                                                                                                   |
| vermittlerDaten.ort                                                   | String       |                                                                                                                                                                   |
| vermittlerDaten.postleitzahl                                          | String       |                                                                                                                                                                   |
| vermittlerDaten.strasseHausnummer                                     | String       |                                                                                                                                                                   |
| vermittlerDaten.vorname                                               | String       |                                                                                                                                                                   |
                                                                                                                                                                                                                                                           

#### Antwort
    {
      "erzeugteDokumente": [
        {
          "dokumentBase64Encoded": "string",
          "dokumentName": "string",
          "vollstaendigkeitsMeldungen": [
            {
              "status": "HINWEIS",
              "text": "string",
              "zuordnung": "DARLEHENSNEHMER1"
            }
          ]
        }
      ]
    }

| Name                                                                  | Typ          | Beschreibung                                                                                                                                                      |
|-----------------------------------------------------------------------|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| erzeugteDokumente[].dokumentBase64Encoded                             | String       | Der Inhalt des Dokuments als Base64 kodierter String.                                                                                                             |
| erzeugteDokumente[].dokumentName                                      | String       | Der Name des Dokuments zur Anzeige im Frontend.                                                                                                                   |
| erzeugteDokumente[].vollstaendigkeitsMeldungen                        | Liste        | Alle Meldungen zu nicht automatisch ausfüllbaren Feldern in diesem Dokument.                                                                                      |
| erzeugteDokumente[].vollstaendigkeitsMeldungen[].status               | Aufzählung   | Immer ``VOLLSTAENDIGKEIT_DOKUMENT``.                                                                                                                              |
| erzeugteDokumente[].vollstaendigkeitsMeldungen[].text                 | String       | Beschreibung des fehlenden Feldes.                                                                                                                                |
| erzeugteDokumente[].vollstaendigkeitsMeldungen[].zuordnung            | Aufzählug    | Beschreibung welcher Anfrageteil betroffen ist: ``DARLEHENSNEHMER1``, ``DARLEHENSNEHMER2``, ``VORHABEN``.                                                         |


### Fachliche Beispiele für Anfragen und Antworten

Die folgenden 2 Beispielen zeigen wie die Kommunikation zwischen EUROPACE und den Schnittstellen erfolgt.

#### Testfall 1: Integriertes Bausparen Tilgungssaussetzung

In diesem Fall ist ein Vertrieb in einem EUROPACE Vertriebsfrontend eingeloggt und
hat einen Vorgang mit folgendem Finanzierungswunsch eingegeben:

Darlehen 50000, Zinsbindung 10 Jahre, tilgungsausgesetzt durch Bausparvertrag.

Die Tarifschnittstelle gab die Tarifangaben aus der Datei [tarife.json](tarife.json) zurück.

Das Europace System erstellt aus diesen Daten die Anfrage aus der Datei [berechnungsanfrage.json](berechnungsanfrage.json).

Die Bausparberechnungsschnittstelle anwortet zum Beispiel wie in der Datei [berechnetesbausparangebot.json](berechnetesbausparangebot.json).

Um Dokumente zu generieren schickt EUROPACE die Anfrage aus der Datei [dokumentenanfrage.json](dokumentenanfrage.json).
 
Und bekommt von der Dokumetenschnittstelle zum Beispiel diese Antwort [dokumentenantwort.json](dokumentenantwort.json).

#### Testfall 2: Integriertes Bausparen Tilgungssaussetzung

  
In diesem Fall ist ein Vertrieb in einem EUROPACE Vertriebsfrontend eingeloggt und
hat einen Vorgang mit folgendem Finanzierungswunsch eingegeben:

Darlehen 150.000 Euro, Zinsbindung 20 Jahre, tilgungsausgesetzt durch Bausparvertrag.

Es handelt sich um zwei Darlehnsnehmer.

Die Tarifschnittstelle gab die Tarifangaben aus der Datei [tarife.json](tarife.json) zurück.

Das Europace System erstellt aus diesen Daten die Anfrage aus der Datei [berechnungsanfrage.json](berechnungsanfrage.json).

Die Bausparberechnungsschnittstelle anwortet zum Beispiel wie in der Datei [berechnetesbausparangebot.json](berechnetesbausparangebot.json).

Um Dokumente zu generieren schickt EUROPACE die Anfrage aus der Datei [dokumentenanfrage.json](dokumentenanfrage.json).
 
Und bekommt von der Dokumetenschnittstelle zum Beispiel diese Antwort [dokumentenantwort.json](dokumentenantwort.json).

## Abwärtskompatiblität

Änderungen an der Schnittstelle bzw. am Schema der Schnittstelle müssen abwärtskompatibel umgesetzt werden. Falls es im Rahmen von Weiterentwicklungen zu Änderungen an der Schnittstelle kommt, sollten diese in einem definierten Zeitraum durch alle Bausparkassen umgesetzt werden.

## Versionierung

Die Version der Schnittstelle wird durch das Versionspräfix in der URL (aktuell v1) kenntlich gemacht. Zusätzlich zur aktuellen Version sollte mindestens die Version davor ebenfalls verfügbar sein um API Upgrades zu erleichtern.
TODO spezifizieren, wann Versionspräfix geändert wird.


## Security

Die Sicherheitsvorkehrungen entsprechen dem Standard SSL über HTTPS unter Verwendung von Client- und Server- Zertifikaten mit Freischaltung der IP-Adressen.

## Nichtfunktionale Anforderungen

Die Antwortzeiten vom Absenden des Request bis zum Erhalt der Antwort (ausgenommen Dokumente, die asynchron nachgeliefert werden können) liegen unterhalb von 500 ms, damit dem Anwender das Bausparangebot ohne bemerkbare Verzögerung angezeigt werden kann.
Die Schnittstelle muss in der Lage sein eine erwartete Last von bis zu 10 Requests pro Sekunde zu verarbeiten. Die Schnittstelle muss grundsätzlich 24 Stunden an allen Wochentagen verfügbar sein. Ausgenommen hiervon sind Wartungsintervalle die außerhalb der Geschäftszeiten liegen. Beeinträchtigungen im Betrieb der Plattform durch Wartungsarbeiten können so vermieden werden.



