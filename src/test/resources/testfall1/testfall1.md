

#### Testfall 1: Integriertes Bausparen Tilgungssaussetzung

In diesem Fall ist ein Vertrieb in einem EUROPACE Vertriebsfrontend eingeloggt und
hat einen Vorgang mit folgendem Finanzierungswunsch eingegeben:

Darlehen 50000, Zinsbindung 10 Jahre, tilgungsausgesetzt durch Bausparvertrag.

Die Tarifschnittstelle gab die Tarifangaben aus der Datei [tarife.json](tarife.json) zurück.

Das Europace System erstellt aus diesen Daten die Anfrage aus der Datei [berechnungsanfrage.json](berechnungsanfrage.json).

Die Bausparberechnungsschnittstelle anwortet zum Beispiel wie in der Datei [berechnetesbausparangebot.json](berechnetesbausparangebot.json).

Um Dokumente zu generieren schickt EUROPACE die Anfrage aus der Datei [dokumenteanfrage.json](dokumenteanfrage.json).
 
Und bekommt von der Dokumetenschnittstelle zum Beispiel diese Antwort [dokumenteantwort.json](dokumenteantwort.json).