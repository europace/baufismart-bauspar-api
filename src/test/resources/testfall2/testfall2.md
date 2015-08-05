

# Testfall 2: Integriertes Bausparen Tilgungssaussetzung

Vorlage auf OMC: 9943.0500.0392-I 

In diesem Fall ist ein Vertrieb in einem EUROPACE Vertriebsfrontend eingeloggt und
hat einen Vorgang mit folgendem Finanzierungswunsch eingegeben:

Darlehen 200.000 Euro, Zinsbindung 10 Jahre 6 Monate, tilgungsausgesetzt durch Bausparvertrag.

Es haltet sich um einen Darlehnsnehmer.

Die Tarifschnittstelle gab die Tarifangaben aus der Datei [tarife.json](tarife.json) zurück.

Das Europace System erstellt aus diesen Daten die Anfrage aus der Datei [berechnungsanfrage.json](berechnungsanfrage.json).


