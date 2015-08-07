# Testfall 2: Integriertes Bausparen Tilgungssaussetzung

Vorlage auf EP2 Fall: 613090   

In diesem Fall ist ein Vertrieb in einem EUROPACE Vertriebsfrontend eingeloggt und
hat einen Vorgang mit folgendem Finanzierungswunsch eingegeben:

Darlehen 150.000 Euro, Zinsbindung 20 Jahre, tilgungsausgesetzt durch Bausparvertrag.

Es haltet sich um zwei Darlehnsnehmer.

Die Tarifschnittstelle gab die Tarifangaben aus der Datei [tarife.json](tarife.json) zurück.

Das Europace System erstellt aus diesen Daten die Anfrage aus der Datei [berechnungsanfrage.json](berechnungsanfrage.json).


