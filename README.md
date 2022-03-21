# EUROPACE Bauspar API Dokumentation


## Beschreibung

Diese Schnittstelle dient der Einbindung von Bausparangeboten als Tilgungsersatzprodukt und zur Zinsabsicherung in einer Finanzierung, sowie als singuläre Bausparangebote in reinen Bausparfrontends. Da sie produktanbieterunabhängig gestaltet ist, ermöglicht sie Angebote von verschiedenen Bausparkassen in Europace anzubieten. Die Schnittstelle wird als REST-Schnittstelle
(Representational State Transfer) realisiert. 

## Technik

Die Kommunikation erfolgt über HTTP/S und REST (Representational State Transfer). Zur Absicherung und Verschlüsselung wird SSL eingesetzt. Die Daten werden im JSON-Format übertragen. Die Lieferung von Dokumenten zu den berechneten Bausparangeboten erfolgt in der ersten Version synchron.

## Prozess

Als ersten Schritt schickt EUROPACE den Bausparwunsch an die durch die jeweilige Bausparkasse bereitzustellende Schnittstelle. Die Berechnung des Bausparangebots erfolgt bei der Bausparkasse.
An EUROPACE wird das berechnete Bausparangebot zurückgeliefert. EUROPACE fügt das Bausparangebot in die Finanzierung ein. In einem zweiten Schritt werden die benötigten ausgefüllten Dokumente über die Schnittstelle angefragt. 

Der Schnittstellenprozess ist zustandslos. Das bedeutet bei jedem Methodenaufruf werden alle relevanten Daten mitgesendet.
Die Schnittstellenimplementierung muss sich keine Zwischenergebnisse merken.

Der Prozess gestaltet sich im Detail wie folgt:

1) Die von der Bausparkasse bereitgestellten Tarife werden von EUROPACE unter der URL `http://host/europace-bausparen/v1/bauspartarife/` mit einem GET Befehl abgefragt. Daraus folgt: Es muss eine REST Resource mit der Tarifliste
bereitgestellt werden.

2) Anhand der Tarifliste und der Finanzierunganfrage werden REST-Anfragen an die Berechnungsschnittstelle unter der URL `http://host/europace-bausparen/v1/bausparangebot/` mit einem POST Befehl gesendet. Es wird erwartet, dass ein Angebot pro Anfrage berechnet wird. Kann kein annehmbares Angebot berechnet werden, so werden dem Angebot Meldungen beigefügt, die es dem Nutzer ermöglichen, die Anfrage so anzupassen, dass ein Angebot berechnet werden kann.

3) Für ein berechnetes Angebot werden über eine weitere REST-Anfrage unter der URL `http://host/europace-bausparen/v1/dokumente/` mit einem POST Befehl die zum Angebot generierten Dokumente geholt. 

Weitere Informationen und eine genauere Beschreibung der REST-Schnittstelle sowie die Beschreibung der Daten werden in Beispiel-Aufrufen und weiteren Tabellen dargestellt.


## Schnittstellenprototyp

In diesem Github Projekt existiert ein minimaler Schnittstellenprototyp, der Anfragen im beschriebenen Schnittstellenformat annimmt und Minimalantworten zurücksendet. Gleichzeitig ist
eine interaktive Dokumentation des Schnittstellenformats über SwaggerUI eingebunden. Voraussetzung zum Übersetzen und Ausführen des Prototyps ist eine Internetverbindung und das Java 8 JDK
( http://www.oracle.com/technetwork/java/javase/downloads/index.html ).

Das Prototyp Projekt ist in Java implementiert. Es benutzt Spring Boot als Container und Gradle als Buildsystem.

Aus dem Projektverzeichnis läßt es sich mit dem Befehl ``$ ./gradlew run`` übersetzen und ausführen.


## Schnittstellendesign

EUROPACE definiert das Schema für die Schnittstelle. Jede Bausparkasse stellt sicher, dass ihre Schnittstelle nach dem definierten
Standard-Schema arbeitet. Die Daten, die über diese Schnittstelle ausgetauscht werden, umfassen in der Anfrage Daten zum Bausparwunsch,
zum Antragsteller und zum Vertrieb. Die Antwort enthält einen vollständig berechneten Bausparvertrag inkl. Sparplan, sowie die Berechnung
des Bauspardarlehens inkl. Tilgungsplan. Eine erste Auflistung der Daten befindet am Ende des Abschnitts. Die genannten Datenfelder stellen einen
Rahmen, der nach aktueller Einschätzung erforderlichen Datenfelder dar (zum aktuellen Zeitpunkt kann nicht ausgeschlossen werden, dass
einzelne Felder im Rahmen der Detaildefinition des Schemas hinzugefügt oder entfernt werden).

Die Schnittstelle wird über REST URLs dargestellt, die Nachrichten im JSON Format empfangen und zurückliefern. Das genaue Format ist in diesem Projekt definiert. Als Encoding für Anfragen und Antworten wird UTF-8 verwendet.

**Festlegungen:**
* Prozentwerte werden 100-basiert übertragen. 1% wird als 1.0 übertragen, 100% als 100,0. Prozentwerte sind am Suffix InProzent am Attributnamen erkennbar.
* Geldbeträge werden als reine Zahlwerte mit 2 Nachkommastellen übertragen. Die Währung ist immer Euro. Alle Geldbetrag-Attribute sind am Suffix InEuro erkennbar.
* Datumsangaben werden als Zeichenketten im Format yyyy-mm-dd übertragen.


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

Die Schnittstellenressource /bausparangebot erlaubt das Berechnen von Bausparangeboten. Vorläufig wird eine 1:1 Berechnung vorgesehen, d.h. eine Anfrage führt zu *einem* berechneten Angebot.
Fehlende Werte in der Anfrage sollten durch die Implementierung durch sinnvolle Standardwerte ergänzt werden. Die Schnittstelle kennt unterschiedliche Berechnungsziele, nach denen sich unterscheidet, welche Inputdaten geliefert werden.

Treten während der Berechnung Unstimmigkeiten auf, weil die Inputdaten nicht zum Tarif passen, z.B. aufgrund einer zu großen Bausparsumme, so soll die Schnittstelle
dies über fachliche Meldungen mitteilen. Hierfür sieht die Antwort das Feld Meldungen vor. Jede Meldung trägt einen Status, der die Auswirkung der Meldung anzeigt.

| Meldungsstatus                                         | Auswirkung                                                                                                                             |
|--------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| HINWEIS                                                | Keine, der Bausparvertrag ist in der berechneten Form abschließbar                                                                     |
| ~~BERECHNUNG_NICHT_MOEGLICH_AUFGRUND_FEHLENDER_DATEN~~ | Es fehlen Daten, um ein vollständiges Angebot zu erstellen. Das Angebot wird nicht angezeigt. ACHTUNG: Dieser Meldungsstatus ist nicht (mehr) zu verwenden, da immer alle für eine Berechnung erforderlichen Daten - ggf. auch Defaultwerte - im Request enthalten sind. |
| VOLLSTAENDIGKEIT_DOKUMENT                              | Nur für /dokumente Schnittstelle relevant.                                                                                             |
| NICHT_MACHBAR                                          | Das Angebot konnte berechnet werden, ist aber aufgrund fachlicher Einschränkungen so nicht abschließbar. Beispiel: Sparrate zu niedrig.|
| ANPASSUNG                                              | Daten aus der Anfrage werden angepasst, um das Angebot zu berechnen (außer Tarif - hierfür siehe TARIF_ANPASSUNG).                     |
| TARIF_ANPASSUNG                                        | Der Tarif aus der Anfrage wird angepasst, um das Angebot zu berechnen. Ist nur bei befülltem Tarif-Wunsch der Anfrage zu erzeugen.     |
| TECHNISCHER_FEHLER                                     | Es ist ein technischer Fehler während der Berechnung aufgetreten. Das Angebot wird verworfen.                                          |

#### Anfrage

      {
        "abschlussgebuehrenbehandlung": "VERRECHNUNG",
        "bausparsummeInEuro": 50000,
        "berechnungsArt": "TILGUNGSAUSSETZUNG",
        "berechnungsZiel": "SPARBEITRAG",
        "darlehensWunsch": "MIT_DARLEHEN",
        "laufzeitBisZuteilungInMonaten": 112,
        "bausparkasseIstDarlehensgeber": true,
        "requestId": "XAJNvEbn",
        "fallNummer": "123-456-789",
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
        "vertragsDatum": "2015-09-01",
        "sparBeginn": "2016-01-01",
        "vertriebsGruppe": "Vertrieb A",
        "zielTarif": "T1",
        "zuteilungstermin": "2026-01-01",
        "riesterDaten": 
          {
           "riesterzulagenVerwendung": "SONDERZAHLUNG",
           "geburtsdatumAntragsteller": "1990-01-01",
           "beschaeftigungAntragsteller": "ANGESTELLTER",
           "einkommenVorjahrAntragsteller": "50000",
           "einkommenAktuellesJahrAntragsteller": "35000",
           "zulagenKinderAntragsteller":
           {
              "geburtsdatum": "2018-01-01"
           },
           "familienstand": "VERHEIRATET",
           "gueterTrennungVereinbart": "false",
           "geburtsdatumEhepartner": "1980-15-02",
           "beschaeftigungEhepartner": "ANGESTELLTER",
           "einkommenVorjahrEhepartner": "30000",
           "einkommenAktuellesJahrEhepartner": "25000",
           "zulagenKinderEhepartner": 
           {
              "geburtsdatum": "2018-01-01"
           },
        }       
      }

| Feld                                                    | Typ           | Beschreibung |
|---------------------------------------------------------|---------------|--------------|
| zielTarif                                               | String        | Die technische Tarif ID, so wie sie von GET /tarife geliefert wird. |
| berechnungsZiel                                         | Aufzählung    | Mögliche Werte: ``SPARBEITRAG``, ``BAUSPARSUMME``, ``ZUTEILUNGSTERMIN``, ``LAUFZEIT_BIS_ZUTEILUNG``, ``BAUSPARDARLEHEN`` |
| berechnungsArt                                          | Aufzählung    | Mögliche Werte: ``TILGUNGSAUSSETZUNG``, ``,ZINSABSICHERUNG``, ``BAUSPAREN_OHNE_IMMOBILIENFINANZIERUNG`` |
| bausparSummeInEuro                                      | Dezimalzahl   | Gewünschte Bausparsumme in Euro |
| laufzeitBisZuteilungInMonaten                           | Ganzzahl      | Die Anzahl Monate zwischen Vertragsdatum und Zuteilungsdatum. Entweder wird dieses Feld oder ``zuteilungstermin`` geliefert.|
| bausparkasseIstDarlehensgeber                           | Boolean       | Ist true, wenn Darlehensgeber und Bausparkasse identisch sind, sonst false
| zuteilungstermin                                        | Datum         | Das gewünschte Zuteilungsdatum. Alternativ kann ``laufzeitBisZuteilungInMonaten`` geliefert werden. |
| vertragsDatum                                           | Datum         | Das gewünschte VertragsDatum. |
| sparBeginn                                              | Datum         | Der gewünschte Sparbeginn. |
| sparBeitraege                                           | Liste         | Ermöglicht die Erfassung mehrerer unterschiedlicher Sparzahlungen oder Einmalzahlungen. |
| sparBeitraege[i].beitrag                                | Dezimalzahl   | Der Sparbeitrag dieser Zahlung ein Euro. |
| sparBeitraege[i].zahlungAb                              | Datum         | Der Startzeitpunkt ab dem dieser Sparbeitrag geleistet wird. |
| sparBeitraege[i].zahlungBis                             | Datum         | Der letzte Zeitpunkt bis zu dem dieser Sparbeitrag geleistet wird. |
| sparBeitraege[i].zahlungsrhythmus                       | Aufzählung    | Legt fest, in welchen Intervallen dieser Sparbeitrag gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| tilgungsBeitrag.rateInEuro                              | Dezimalzahl   | Höhe der Tilgungsrate(Zins und Tilgung des Darlehens)|
| tilgungsBeitrag.zahlungsrhythmus                        | Aufzählung    | Legt fest, in welchen Intervallen die Tilgungsrate gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| abschlussgebuehrenbehandlung                            | Aufzählung    | Wenn nicht vorgegeben, dann gibt die BSK die Abschlussgebührenverrechnung vor. Mögliche Werte sind: ``VERRECHNUNG``, ``SOFORTZAHLUNG``. |
| darlehensWunsch                                         | Aufzählung    | Soll ein Bauspar- oder Zuteilungsdarlehen in Anspruch genommen werden? Mögliche Werte sind: ``MIT_DARLEHEN``, ``OHNE_DARLEHEN``. |
| vermittlerNr                                            | String        | Die ID des Vermittlers im Europace System. |
| requestId                                               | String        | Ordnet die Anfrage einer EUROPACE Anfrage für Loggingzwecke zu. |
| fallNummer                                              | String        | Ordnet die Anfrage einer EUROPACE Fallakte für Loggingzwecke zu. |
| vertriebsGruppe                                         | String        | Vertriebsgruppe des anfragenden Vertriebs zur Bestimmung der Provision. |
| riesterDaten.riesterzulagenVerwendung                   | String        | Legt die Verwendung der Riesterzulagen fest (SONDERZAHLUNG, VERRECHNUNG). |
| riesterDaten.geburtsdatumAntragsteller                  | Datum         | Geburtsdatum des Antragstellers |
| riesterDaten.beschaeftigungAntragsteller                | Aufzählung    | Mögliche Werte: ``ANGESTELLTER``, ``ARBEITER``, ``ARBEITSLOSER``, ``BEAMTER``, ``FREIBERUFLER``, ``HAUSFRAU_HAUSMANN``, ``RENTNER``, ``SELBSTAENDIGER``. | 
| riesterDaten.einkommenVorjahrAntragsteller              | Ganzzahl      | Höhe des Einkommens des vergangenen Jahres des Antragstellers. |
| riesterDaten.einkommenAktuellesJahrAntragsteller        | Ganzzahl      | Höhe des Einkommens des aktuellen Jahres des Antragstellers. |
| riesterDaten.zulagenKinderAntragsteller                 | Liste         | Ermöglicht die Erfassung mehrerer förderfähiger Kinder des Antragstellers.  |
| riesterDaten.zulagenKind[i].geburtsdatum                | Datum         | Geburtsdatum des förderfähigen Kindes des Antragstellers. |
| riesterDaten.familienstand                              | Aufzählung    | Mögliche Werte: ``LEDIG``, ``VERHEIRATET``, ``LEBENSPARTNER``, ``GESCHIEDEN``, ``VERWITWET``, ``HAUSFRAU_HAUSMANN``, ``GETRENNT_LEBEND``. |
| riesterDaten.gueterTrennungVereinbart                   | Boolean       | Ist true, wenn Gütertrennung vereinbart wurde, sonst false. |
| riesterDaten.geburtsdatumEhepartner                     | Datum         | Geburtsdatum des Ehepartners. |
| riesterDaten.beschaeftigungEhepartner                   | Aufzählung    | Mögliche Werte: ``ANGESTELLTER``, ``ARBEITER``, ``ARBEITSLOSER``, ``BEAMTER``, ``FREIBERUFLER``, ``HAUSFRAU_HAUSMANN``, ``RENTNER``, ``SELBSTAENDIGER``. |
| riesterDaten.einkommenVorjahrEhepartner                 | Ganzzahl      | Höhe des Einkommens des vergangenen Jahres des Ehepartners. |
| riesterDaten.einkommenAktuellesJahrEhepartner           | Ganzzahl      | Höhe des Einkommens des aktuellen Jahres des Ehepartners. |
| riesterDaten.zulagenKinderEhepartner                    | Liste         | Ermöglicht die Erfassung mehrerer förderfähiger Kinder des Ehepartners. |
| riesterDaten.zulagenKind[i].geburtsdatum                | Datum         | Geburtsdatum des förderfähigen Kindes des Ehepartners. |


#### Antwort

      {
        "berechnetesBausparAngebot": {
          "abschlussgebuehr": {
            "abschlussgebuehrBetragInEuro": 0,
            "abschlussgebuehrHoeheInProzent": 0,
            "abschlussgebuehrenbehandlung": "VERRECHNUNG"
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
                  "zinsInEuro": 0,
                  "riesterzulageInEuro": 0
                }
              ]
            },
            "tilgungsende": "string",
            "zahlungsBeitragTilgungsRateInEuro": 0,
            "zahlungsrhythmus": "MONATLICH",
            "gesamtleistungDarlehenInEuro": 0
          },
          "bausparsummeInEuro": 0,
          "berechnungsziel": "SPARBEITRAG",
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
                  "datum": "string",
                  "gebuehrenInEuro": 0,
                  "kontofuehrungsGebuehrInEuro": 0,
                  "saldoNachZahlungInEuro": 0,
                  "zahlungInEuro": 0,
                  "zinsInEuro": 0,
                  "riesterzulageInEuro": 0
                }
              ]
            },
            "sparBeitraege": [
              {
                "zahlungsrhythmus": "EINMALIG",
                "beitrag": 0,
                "zahlungAb": "2015-09-30",
                "zahlungBis": "2015-09-30"
              }
            ]
          },
          "tarif": "string",
          "vertragsDatum": "2015-09-01",
          "sparBeginn": "2016-01-01",
          "zuteilungsTermin": "string",
          "provision" : {
            "vertriebsProvisionInEuro": 1000
          }
        }
      }

| Name                                                                  | Typ          | Beschreibung                                                                                                                                                      |
|-----------------------------------------------------------------------|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| tarif                                                                 | String       | der Tarif wird auf Seiten der BSK ermittelt                                                                                                                       |
| berechnungsziel                                                       | Aufzählung   | Mögliche Werte: ``SPARBEITRAG``, ``BAUSPARSUMME``, ``ZUTEILUNGSTERMIN``, ``LAUFZEIT_BIS_ZUTEILUNG``, ``BAUSPARDARLEHEN``                                          |
| bausparsummeInEuro                                                    | Dezimalzahl  | Betrag der Bausparsumme in Euro                                                                                                                                   |
| laufzeitBisZuteilungInMonaten                                         | Ganzzahl     | Anzahl Monate bis zur Zuteilung                                                                                                                                   |
| zuteilungsTermin                                                      | Datum        | Zuteilungstermin                                                                                                                                                  |
| vertragsDatum                                                         | Datum        |                                                                                                                                                                   |
| sparBeginn                                                            | Datum        |                                                                                                                                                                   |
| abschlussgebuehrenbehandlung                                          | Aufzählung   | Mögliche Werte sind: ``VERRECHNUNG``, ``SOFORTZAHLUNG``.                                                                                                           |
| abschlussgebuehrHoeheInProzent                                        | Dezimalzahl  | Abschlussgebühr in Prozent                                                                                                                                        |
| abschlussgebuehrBetragInEuro                                          | Dezimalzahl  | Abschlussgebühr in Euro                                                                                                                                           |
| kontoGebuehrJaehrlichInEuro                                           | Dezimalzahl  |                                                                                                                                                                   |
| gesamtleistungKomplettInEuro                                          | Dezimalzahl  | Summe aller Zahlungen der Sparphase und  Darlehensphase                                                                                                                       |
| gesamtlaufzeitKomplettInMonaten                                       | Ganzzahl     |                                                                                                                                                                   |
| bausparDarlehen.hoeheBauspardarlehenInEuro                            | Dezimalzahl  | Höhe des Bauspardarlehens in Euro.                                                                                                                                |
| bausparDarlehen.zahlungsrhythmus                                      | Aufzählung   | Zahlungsrhythmus für die Tilgungsrate.  Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``.                 |
| bausparDarlehen.zahlungsBeitragTilgungsRateInEuro                     | Dezimalzahl  | Höhe der Tilgungsrate(Zins und Tilgung des Darlehens pro angegebenen Rhythmus)                                                                                    |
| bausparDarlehen.sollzinsInProzent                                     | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.effektiverJahreszinsInProzent                         | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.darlehenslaufzeitInMonaten                            | Ganzzahl     |                                                                                                                                                                   |
| bausparDarlehen.tilgungsende                                          | Datum        |                                                                                                                                                                   |
| bausparDarlehen.gesamtleistungDarlehenInEuro                          | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen                                | Liste        | Jede einzelne Zahlung des Bauspardarlehens bis zur Vollablösung.                                                                                                  |
| bausparDarlehen.tilgungsPlan.zahlungen[i].datum                       | Datum        |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].gebuehrenInEuro             | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].kontofuehrungsGebuehrInEuro | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].saldoNachZahlungInEuro      | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].tilgungInEuro               | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].zahlungInEuro               | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].zinsInEuro                  | Dezimalzahl  |                                                                                                                                                                   |
| bausparDarlehen.tilgungsPlan.zahlungen[i].riesterzulageInEuro         | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.guthabenzinsInProzent                                       | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.guthabenzinsBetragInEuro                                    | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.bonuszinsInProzent                                          | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.bonuszinsBetragInEuro                                       | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.guthabenBeiZuteilungInEuro                                  | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.regelsparbeitragInEuro                                      | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.gesamtleistungSparphaseInEuro                               | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.sparBeitraege                                               | Liste        | Stellt die Abfolge unterschiedlich hoher Sparbeiträge in der Sparphase dar. Auch Einmalzahlungen werden über diesen Mechanismus abgebildet. Sie Biespiel 2.       |
| sparPhase.sparBeitraege[i].beitrag                                    | Dezimalzahl  | Der Sparbeitrag dieser Zahlung ein Euro. |
| sparPhase.sparBeitraege[i].zahlungAb                                  | Datum        | Der Startzeitpunkt ab dem dieser Sparbeitrag geleistet wird. |
| sparPhase.sparBeitraege[i].zahlungBis                                 | Datum        | Der letzte Zeitpunkt bis zu dem dieser Sparbeitrag geleistet wird. |
| sparPhase.sparBeitraege[i].zahlungsrhythmus                           | Aufzählung   | Legt fest, in welchen Intervallen dieser Sparbeitrag gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| sparPhase.sparPlan.zahlungen                                          | Liste        | Jede Zahlung in das Bausparkonto in der Sparphase.                                                                                                                |
| sparPhase.sparPlan.zahlungen[i].datum                                 | Datum        |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[i].gebuehrenInEuro                       | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[i].kontofuehrungsGebuehrInEuro           | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[i].saldoNachZahlungInEuro                | Dezimalzahl  |                                                                                                                                                                   |
| sparPhase.sparPlan.zahlungen[i].zahlungInEuro                         | Dezimalzahl  | Die Sparrate                                                                                                                                                      |
| sparPhase.sparPlan.zahlungen[i].zinsInEuro                            | Dezimalzahl  | Der Betrag an Guthabenzinsen der zu diesem Datum mit dem Bausparvertrag verrechnet wird.                                                                          |
| sparPhase.sparPlan.zahlungen[i].riesterzulageInEuro                   | Dezimalzahl  |                                                                           |
| meldungen                                                             | Liste        |                                         |                                                                                                                         |
| meldungen[i].text                                                     | String       | menschlich lesbare Fehlerbeschreibung   |                                                                                                                         |
| meldungen[i].status                                                   | Aufzählung   | Auswirkung der Meldung auf die Annehmbarkeit des Bausparantrags. Mögliche Werte: ``HINWEIS``, ``BERECHNUNG_NICHT_MOEGLICH_AUFGRUND_FEHLENDER_DATEN``, ``VOLLSTAENDIGKEIT_DOKUMENT``, ``NICHT_MACHBAR``, ``ANPASSUNG``, ``TECHNISCHER_FEHLER``.                                                                                       |
| meldungen[i].zuordnung                                                | Aufzählung   | Zuordnung der Meldung zum Datenhaushalt des Frontends. Mögliche Werte: ``DARLEHENSNEHMER1``, ``DARLEHENSNEHMER2``, ``VORHABEN``.                                                  |
| provision.vertriebsProvisionInEuro                                    | Dezimalzahl  | Die Komplette Provision die die Bausparkasse an den Vermittler und die Vertriebsorganisation auszahlt. |


### Schnittstellenressource POST /dokumente/

Die Schnittstellenressource /dokumente erlaubt, die für den Abschluss des Bausparvertrages notwendigen Dokumente im PDF Format zu generieren und mit den Feldern aus der Anfrage automatisch vorauszufüllen.
Die automatische Feldausfüllung funktioniert nach dem best-effort Prinzip: Für den Fall, dass nicht alle zum Ausfüllen benötigten Felder mitgeliefert werden, wird ein teilausgefülltes Dokument geliefert.
Über das Feld "vollstaendigkeitsMeldungen" besteht die Möglichkeit, Nutzerfeedback über fehlende Angaben zu geben.  Das Feld zuordnung erlaubt es dabei, die fehlenden Daten grob dem Datenhaushalt des Frontends zuzuordnen.


##### Anfrage

    {
        "tarif": "T1",
        "berechnungsArt": "TILGUNGSAUSSETZUNG",
        "bausparSummeInEuro": 50000,
        "sparphaseDokument":
        {
            "regelsparbeitragInEuro": 168.33,
            "sparBeitraege": [
              {
                "zahlungsrhythmus": "EINMALIG",
                "beitrag": 10000.0,
                "zahlungAb": "2015-09-30",
                "zahlungBis": "2015-09-30"
              }
            ]
        },
        "abschlussgebuehrenbehandlung": "SOFORTZAHLUNG",
        "abschlussgebuehrHoeheInEuro": 500,
        "bausparkasseIstDarlehensgeber": true,
        "antragsteller": [
        {
            "anrede": "HERR",
            "titel": 
            {
                "doktor": true,
                "professor": false
            },
            "vorname": "Max",
            "nachName": "Muster",
            "geburtsDatum": null,
            "geburtsName": null,
            "geburtsOrt": null,
            "staatsangehoerigkeit": "DE",
            "steuerId":"75041163828"
            "einkommenssteuerpflichtigInUsa":null,
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
           },
           "beschaeftigungsVerhaeltnis": "ANGESTELLTER",
           "legitimation":
           {
               "ausweisArt": "REISEPASS",
               "ausweisNummer": null,
               "austellendeBehoerde": null,
               "ausstellungsDatum": "2010-01-01"
           },
           "todesfallBeguenstigter":
           {
               "anrede": "HERR",
               "vorname": null,
               "nachname": null,
               "geburtsdatum": null,
               "adresse.strasse": null,
               "adresse.hausNummer": null,
               "adresse.postleitzahl": null,
               "adresse.wohnOrt": null,
               "adresse.landWohnsitz": null
           },
            "vermoegenswirksameLeistungenBetragInEuro": null,
            "vermoegenswirksameLeistungenZahlungsrhythmus": "MONATLICH",
            "bruttoEinkommenVorjahr": null,
            "bruttoEinkommenAktuellesJahr": null,
            "guetertrennungVereinbart": null
       }],
       "vermittlerDaten": 
       {
           "nachName": null,
           "ort": null,
           "postleitzahl": null,
           "strasseHausnummer": null,
           "vorname": null,
           "firma": null,
           "telefonNummer": null,
           "eMailAdresse": null,
           "vermittlerNr": "A123456"
       },
       "fallNummer":"123-456-789",
       "requestId":"87e6rt5",
       "fallAuswahl": false,
       "vertragsDatum":"2015-09-30",
       "sparBeginn":"2016-01-01",
       "berechnungsZiel": "SPARBEITRAG",
       "darlehensWunsch": "MIT_DARLEHEN",
       "vertriebsGruppe": "Vertrieb A",
       "laufzeitBisZuteilungInMonaten": 120,
       "zielTarif": "T1",
       "zuteilungstermin": "2025-09-01",
       "tilgungsBeitrag":
       {
           "rateInEuro": 100,
           "zahlungsrhythmus": "MONATLICH"
       },
       "riesterDaten": 
       {
            "riesterzulagenVerwendung": "SOFORTZAHLUNG",
            "geburtsdatumAntragsteller": "1990-01-01",
            "beschaeftigungAntragsteller": "ANGESTELLTER",
            "einkommenVorjahrAntragsteller": "50000",
            "einkommenAktuellesJahrAntragsteller": "35000",
            "zulagenKinderAntragsteller":
                {
                   "geburtsdatum": "2018-01-01"
                },
            "familienstand": "VERHEIRATET",
            "gueterTrennungVereinbart": "false",
            "geburtsdatumEhepartner": "1983-23-09",
            "beschaeftigungEhepartner": "ANGESTELLTER",
            "einkommenVorjahrEhepartner": "35000",
            "einkommenAktuellesJahrEhepartner": "25000",
            "zulagenKinderEhepartner": 
                {
                   "geburtsdatum": "2018-01-01"
                },
        }       
    }


| Name                                                                  | Typ                    | Beschreibung                                                                                                                                                                 |
|-----------------------------------------------------------------------|------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| tarif                                                                 | String                 | der Tarif wird auf Seiten der BSK ermittelt                                                                                                                                  |
| berechnungsArt                                                        | Aufzählung             | Mögliche Werte: ``TILGUNGSAUSSETZUNG``, ``,ZINSABSICHERUNG``, ``BAUSPAREN_OHNE_IMMOBILIENFINANZIERUNG``                                                                      |
| bausparsummeInEuro                                                    | Dezimalzahl            | Betrag der Bausparsumme in Euro                                                                                                                                              |
| sparphaseDokument.regelsparbeitragInEuro                              | Dezimalzahl            | Sparbeitrag                                                                                                                                                                  |
| sparphaseDokument.sparBeitraege                                       | Liste                  | Stellt die Abfolge unterschiedlich hoher Sparbeiträge in der Sparphase dar. Auch Einmalzahlungen werden über diesen Mechanismus abgebildet. Sie Biespiel 2.                  |
| sparphaseDokument.sparBeitraege[i].beitrag                            | Dezimalzahl            | Der Sparbeitrag dieser Zahlung ein Euro.                                                                                                                                     |
| sparphaseDokument.sparBeitraege[i].zahlungAb                          | Datum                  | Der Startzeitpunkt ab dem dieser Sparbeitrag geleistet wird.                                                                                                                 |
| sparphaseDokument.sparBeitraege[i].zahlungBis                         | Datum                  | Der letzte Zeitpunkt bis zu dem dieser Sparbeitrag geleistet wird.                                                                                                           |
| sparphaseDokument.sparBeitraege[i].zahlungsrhythmus                   | Aufzählung             | Legt fest, in welchen Intervallen dieser Sparbeitrag gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| abschlussgebuehrenbehandlung                                          | Aufzählung             | Mögliche Werte sind: ``VERRECHNUNG``, ``SOFORTZAHLUNG``.                                                                                                                     |
| abschlussgebuehrHoeheInEuro                                           | Dezimalzahl            | Abschlußgebühr                                                                                                                                                               |
| bausparkasseIstDarlehensgeber                                         | Boolean                | Ist true, wenn Darlehensgeber und Bausparkasse identisch sind, sonst false                                                                                                                                                              |
| antragsteller                                                         | Liste                  |                                                                                                                                                                              |
| antragsteller[i].anrede                                               | Aufzählung             | Mögliche Werte sind: ``HERR``, ``FRAU``.                                                                                                                                     |
| antragsteller[i].titel.doktor                                         | Boolean                | Doktor                                                                                                                                                                       |
| antragsteller[i].titel.professor                                      | Boolean                | Professor                                                                                                                                                                    |
| antragsteller[i].vorname                                              | String                 | Vorname                                                                                                                                                                      |
| antragsteller[i].nachname                                             | String                 | Nachname                                                                                                                                                                     |
| antragsteller[i].geburtsDatum                                         | Datum                  |                                                                                                                                                                              |
| antragsteller[i].geburtsName                                          | String                 |                                                                                                                                                                              |
| antragsteller[i].geburtsOrt                                           | String                 | Dieses Feld ist über Zusatzangeben im Frontend enthalten. Bitte wenden Sie sich an Europace, um eine Bank hierfür freizuschalten.                                                                                                                           |
| antragsteller[i].staatsangehoerigkeit                                 | String                 | 2-stelliger ISO 3166 Code                                                                                                                                                    |
| antragsteller[i].steuerId                                             | String                 |                                                                                                                                                                              |
| antragsteller[i].adresse.strasse                                      | String                 |                                                                                                                                                                              |
| antragsteller[i].adresse.hausNummer                                   | String                 |                                                                                                                                                                              |
| antragsteller[i].adresse.postleitzahl                                 | String                 |                                                                                                                                                                              |
| antragsteller[i].adresse.wohnOrt                                      | String                 |                                                                                                                                                                              |
| antragsteller[i].adresse.landWohnsitz                                 | String                 | 2-stelliger ISO 3166 Code                                                                                                                                                    |
| antragsteller[i].kontakt.telefonNummer                                | String                 |                                                                                                                                                                              |
| antragsteller[i].kontakt.mobilNummer                                  | String                 |                                                                                                                                                                              |
| antragsteller[i].kontakt.eMailAdresse                                 | String                 |                                                                                                                                                                              |
| antragsteller[i].familienStand                                        | Aufzählung             | Mögliche Werte sind: ``LEDIG``, ``VERHEIRATET``,  ``LEBENSPARTNER``, ``GESCHIEDEN``, ``VERWITWET``, ``GETRENNT_LEBEND``.                                                     |
| antragsteller[i].zahlungsDaten.iban                                   | String                 |                                                                                                                                                                              |
| antragsteller[i].zahlungsDaten.nameKreditInstitut                     | String                 |                                                                                                                                                                              |
| antragsteller[i].zahlungsDaten.zahlungsForm                           | Aufzählung             | Mögliche Werte sind: ``LASTSCHRIFT``, ``UEBERWEISUNG``. Aktuell wird nur ``LASTSCHRIFT`` verwendet.                                                                                                                      |
| antragsteller[i].beschaeftigungsVerhaeltnis                           | Aufzählung             | Mögliche Werte sind: ``ANGESTELLTER``, ``ARBEITER``, ``ARBEITSLOSER``, ``BEAMTER``, ``FREIBERUFLER``, ``HAUSFRAU_HAUSMANN``,``RENTNER``,``SELBSTAENDIGER``.                  |
| antragsteller[i].legitimation.ausweisArt                              | Aufzählung             | Mögliche Werte sind: ``PERSONALAUSWEIS``, ``REISEPASS``. Dieses Feld ist noch nicht im Frontend enthalten.                                                                   |
| antragsteller[i].legitimation.ausweisNummer                           | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].legitimation.austellendeBehoerde                     | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].legitimation.ausstellungsDatum                       | Datum                  | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].einkommenssteuerpflichtigInUsa                       | Boolean                | Gibt an, ob der Antragsteller nach dem _Foreign Account Tax Compliance Act_ (FATCA) in den USA steuerpflichtig ist.  Dieses Feld ist noch nicht im Frontend enthalten.       |
| antragsteller[i].todesfallBeguenstigter.anrede                        | Aufzählung             | Mögliche Werte sind: ``HERR``, ``FRAU``.   Dieses Feld ist noch nicht im Frontend enthalten.                                                                                 |
| antragsteller[i].todesfallBeguenstigter.vorname                       | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.nachname                      | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.geburtsdatum                  | Datum                  | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.adresse.strasse               | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.adresse.hausNummer            | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.adresse.postleitzahl          | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.adresse.wohnOrt               | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].todesfallBeguenstigter.adresse.landWohnsitz          | String                 | Dieses Feld ist noch nicht im Frontend enthalten.                                                                                                                            |
| antragsteller[i].vermoegenswirksameLeistungenBetragInEuro             | Dezimalzahl            | Der Betrag der vermögenswirksamen Leistungen, die der Arbeitgeber des Antragstellers in diesen Bausparvertrag einzahlt. Es werden immer die VL Beträge aller Antragsteller eingezahlt. Dieses Feld ist noch nicht im Frontend enthalten.|
| antragsteller[i].vermoegenswirksameLeistungenZahlungsrhythmus         | Aufzählung             | Legt fest, in welchen Intervallen die vermögenswirksamen Leistungen gezahlt werden. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``.  Dieses Feld ist noch nicht im Frontend enthalten.|
| antragsteller[i].bruttoEinkommenVorjahr                               | Dezimalzahl            | Vorjahreseinkommen des Antragstellers.|
| antragsteller[i].bruttoEinkommenAktuellesJahr                         | Dezimalzahl            | Aktuelles Jahreseinkommen des Antragstellers.|
| antragsteller[i].guetertrennungVereinbart                             | Boolean                | Ist true, wenn Gütertrennung vereinbart wurde, sonst false. |
| vermittlerDaten.nachName                                              | String                 |                                                                                                                                                                              |
| vermittlerDaten.ort                                                   | String                 |                                                                                                                                                                              |
| vermittlerDaten.postleitzahl                                          | String                 |                                                                                                                                                                              |
| vermittlerDaten.strasseHausnummer                                     | String                 |                                                                                                                                                                              |
| vermittlerDaten.vorname                                               | String                 |                                                                                                                                                                              |
| vermittlerDaten.firma                                                 | String                 |                                                                                                                                                                              |
| vermittlerDaten.telefonNummer                                         | String                 |                                                                                                                                                                              |
| vermittlerDaten.eMailAdresse                                          | String                 |                                                                                                                                                                              |
| vermittlerDaten.vermittlerNr                                          | String                 | Die ID des Vermittlers im Europace System.                                                                                                                                   |
| fallAuswahl                                                           | Boolean                | True, wenn der Fall mit kostenpflichtigen Diensten angenommen wird. False, in allen anderen Fällen (z.B. bei Angebotsermittlung)                                             |
| requestId                                                             | String                 | Ordnet die Anfrage einer EUROPACE Anfrage für Loggingzwecke zu.                                                                                                              |
| fallNummer                                                            | String                 | Ordnet die Anfrage einer EUROPACE Fallakte für Loggingzwecke zu.                                                                                                             |
| vertragsDatum                                                         | Datum                  |                                                                                                                                                                              |
| sparBeginn                                                            | Datum                  |                                                                                                                                                                              |
| berechnungsZiel                                                       | Aufzählung             | Mögliche Werte: ``SPARBEITRAG``, ``BAUSPARSUMME``, ``ZUTEILUNGSTERMIN``, ``LAUFZEIT_BIS_ZUTEILUNG``, ``BAUSPARDARLEHEN`` |
| darlehensWunsch                                                       | Aufzählung             | Soll ein Bauspar- oder Zuteilungsdarlehen in Anspruch genommen werden? Mögliche Werte sind: ``MIT_DARLEHEN``, ``OHNE_DARLEHEN``. |
| vertriebsGruppe                                                       | String                 | Vertriebsgruppe des anfragenden Vertriebs zur Bestimmung der Provision. |
| laufzeitBisZuteilungInMonaten                                         | Ganzzahl               | Die Anzahl Monate zwischen Vertragsdatum und Zuteilungsdatum. Entweder wird dieses Feld oder ``zuteilungstermin`` geliefert.|
| zielTarif                                                             | String                 | Die technische Tarif ID, so wie sie von GET /tarife geliefert wird. |
| zuteilungstermin                                                      | Datum                  | Das gewünschte Zuteilungsdatum. Alternativ kann ``laufzeitBisZuteilungInMonaten`` geliefert werden. |
| tilgungsBeitrag.rateInEuro                                            | Dezimalzahl            | Höhe der Tilgungsrate(Zins und Tilgung des Darlehens)|
| tilgungsBeitrag.zahlungsrhythmus                                      | Aufzählung             | Legt fest, in welchen Intervallen die Tilgungsrate gezahlt wird. Mögliche Werte sind: ``MONATLICH``, ``VIERTELJAEHRLICH``, ``HALBJAEHRLICH``, ``JAEHRLICH``, ``EINMALIG``. |
| riesterDaten.riesterzulagenVerwendung                                 | String                 | Legt die Verwendung der Riesterzulagen fest (SONDERZAHLUNG, VERRECHNUNG). |
| riesterDaten.geburtsdatumAntragsteller                                | Datum                  | Geburtsdatum des Antragstellers |
| riesterDaten.beschaeftigungAntragsteller                              | Aufzählung             | Mögliche Werte: ``ANGESTELLTER``, ``ARBEITER``, ``ARBEITSLOSER``, ``BEAMTER``, ``FREIBERUFLER``, ``HAUSFRAU_HAUSMANN``, ``RENTNER``, ``SELBSTAENDIGER``. | 
| riesterDaten.einkommenVorjahrAntragsteller                            | Ganzzahl               | Höhe des Einkommens des vergangenen Jahres des Antragstellers. |
| riesterDaten.einkommenAktuellesJahrAntragsteller                      | Ganzzahl               | Höhe des Einkommens des aktuellen Jahres des Antragstellers. |
| riesterDaten.zulagenKinderAntragsteller                               | Liste                  | Ermöglicht die Erfassung mehrerer förderfähiger Kinder des Antragstellers.  |
| riesterDaten.zulagenKind[i].geburtsdatum                              | Datum                  | Geburtsdatum des förderfähigen Kindes des Antragstellers. |
| riesterDaten.familienstand                                            | Aufzählung             | Mögliche Werte: ``LEDIG``, ``VERHEIRATET``, ``LEBENSPARTNER``, ``GESCHIEDEN``, ``VERWITWET``, ``HAUSFRAU_HAUSMANN``, ``GETRENNT_LEBEND``. |
| riesterDaten.gueterTrennungVereinbart                                 | Boolean                | Ist true, wenn Gütertrennung vereinbart wurde, sonst false. |
| riesterDaten.geburtsdatumEhepartner                                   | Datum                  | Geburtsdatum des Ehepartners. |
| riesterDaten.beschaeftigungEhepartner                                 | Aufzählung             | Mögliche Werte: ``ANGESTELLTER``, ``ARBEITER``, ``ARBEITSLOSER``, ``BEAMTER``, ``FREIBERUFLER``, ``HAUSFRAU_HAUSMANN``, ``RENTNER``, ``SELBSTAENDIGER``. |
| riesterDaten.einkommenVorjahrEhepartner                               | Ganzzahl               | Höhe des Einkommens des vergangenen Jahres des Ehepartners. |
| riesterDaten.einkommenAktuellesJahrEhepartner                         | Ganzzahl               | Höhe des Einkommens des aktuellen Jahres des Ehepartners. |
| riesterDaten.zulagenKinderEhepartner                                  | Liste                  | Ermöglicht die Erfassung mehrerer förderfähiger Kinder des Ehepartners. |
| riesterDaten.zulagenKind[i].geburtsdatum                              | Datum                  | Geburtsdatum des förderfähigen Kindes des Ehepartners. |


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
| erzeugteDokumente[i].dokumentBase64Encoded                            | String       | Der Inhalt des Dokuments als Base64 kodierter String.                                                                                                             |
| erzeugteDokumente[i].dokumentName                                     | String       | Der Name des Dokuments zur Anzeige im Frontend.                                                                                                                   |
| erzeugteDokumente[i].vollstaendigkeitsMeldungen                       | Liste        | Alle Meldungen zu nicht automatisch ausfüllbaren Feldern in diesem Dokument.                                                                                      |
| erzeugteDokumente[i].vollstaendigkeitsMeldungen[j].status             | Aufzählung   | Immer ``VOLLSTAENDIGKEIT_DOKUMENT``.                                                                                                                              |
| erzeugteDokumente[i].vollstaendigkeitsMeldungen[j].text               | String       | Beschreibung des fehlenden Feldes.                                                                                                                                |
| erzeugteDokumente[i].vollstaendigkeitsMeldungen[j].zuordnung          | Aufzählug    | Beschreibung welcher Anfrageteil betroffen ist: ``DARLEHENSNEHMER1``, ``DARLEHENSNEHMER2``, ``VORHABEN``.                                                         |


### Fachliche Beispiele für Anfragen und Antworten

Die folgenden 2 Beispielen zeigen wie die Kommunikation zwischen EUROPACE und den Schnittstellen erfolgt.

  1. [testfall1.md](src/test/resources/testfall1/testfall1.md)
  2. [testfall2.md](src/test/resources/testfall2/testfall2.md)

## Fehlerbehandlung

Solange die Schnittstelle eine gültige Antwort erstellen kann, wird HTTP Statuscode 200 geliefert. Ein gültige Antwort 
kann dabei auch fachliche Fehlermeldungen enthalten, dass bspw. mit den Eingabedaten nicht gerechnet werden kann.
 
Liegt ein technischer Fehler vor und kann die Schnittstellenimplementierung nicht mit einem gültigen JSON Dokument antworten, so wird HTTP Statuscode 500
 geliefert ggf. mit einer Fehlermeldung.

## Abwärtskompatiblität

Änderungen an der Schnittstelle bzw. am Schema der Schnittstelle müssen abwärtskompatibel umgesetzt werden. Falls es im Rahmen von Weiterentwicklungen zu Änderungen an der Schnittstelle kommt, sollten diese in einem definierten Zeitraum durch alle Bausparkassen umgesetzt werden.

### Umgang mit alten Tarifen

Wird ein Tarif ab einem bestimmten Zeitpunkt nicht mehr angeboten, kann es dennoch sein, dass z.B. im Rahmen von Angebotsaktualisierungen ein veralteter Tarif über die Schnittstelle angefragt wird.
Beispiele zum Umgang hiermit können sein:
- eine NICHT_MACHBAR - Meldung, wenn der alte Tarif keine Entsprechung in den neuen Tarifen findet (z.B. ein alter Aktionstarif)
- eine ANPASSUNG - Meldung und Anpassung auf einen neuen Tarif, falls die Änderungen ausreichend gering sind (z.B. alter Standard-Tarif auf neuen Standard-Tarif)

## Versionierung

Die Version der Schnittstelle wird durch das Versionspräfix in der URL (aktuell v1) kenntlich gemacht. Zusätzlich zur aktuellen Version sollte mindestens die Version davor ebenfalls verfügbar sein um API Upgrades zu erleichtern.


## Security

Die Sicherheitsvorkehrungen entsprechen dem Standard SSL über HTTPS unter Verwendung von Client- und Server- Zertifikaten mit Freischaltung der IP-Adressen.

## Nichtfunktionale Anforderungen

Die Antwortzeiten vom Absenden des Request bis zum Erhalt der Antwort (ausgenommen Dokumente, die asynchron nachgeliefert werden können) sollten als Richtwert unterhalb von 500 ms liegen, damit dem Anwender das Bausparangebot ohne bemerkbare Verzögerung angezeigt werden kann.
Die Schnittstelle muss in der Lage sein, eine erwartete Last von bis zu 10 Requests pro Sekunde innerhalb dieser Zeitvorgabe zu verarbeiten.
Nach spätestens 5 Sekunden wird der Request mit einem technischen Timeout abgebrochen.
Tritt der Timeout häufiger auf, kann die Schnittstelle zur Sicherung der Systemstabilität für eine bestimmten Zeitraum "abgeklemmt" werden, was zur Folge hat, dass innerhalb dieses Zeitraums keine Bauspar-Angebote der jeweiligen Bausparkasse auf der Plattform angeboten werden.

Die Schnittstelle muss grundsätzlich 24 Stunden an allen Wochentagen verfügbar sein. 
Ausgenommen hiervon sind Wartungsintervalle die außerhalb der Geschäftszeiten liegen. 
Beeinträchtigungen im Betrieb der Plattform durch Wartungsarbeiten können so vermieden werden.





