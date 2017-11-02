# Klassifikator

Dynamische Klassifizierung von Gesten mit einem TensorFlow-RNN mit CTC-Outputlayer. 

* Training und Server können über die Console direkt angesteuert werden oder (bei Windows) über die enthaltenen bacth-Files gestartet werden

### was wird benötigt?
* python (v2.* oder v3.*)
* numpy
* pandas
* tensorflow

am einfachsten ist die Installation über pip3

## Funktionen:
* Auslesen der RNN-Parameter aus der preferences.xml
* Auslesen der Trainings- und Testdaten aus /Import_Data/Test.csv und .../Train.csv (Umstellung auf DB-Auslese noch nicht umgesetzt)
* Optionale Wiederverwendung von alten Modellparametern als Intialgewichtungen der Zellen
* Jedes Modell wird über eine UUID und einen Modellnamen identifiziert (dieser wird auch zur Wiederverwendung alter Modelle benötigt)
* Jede Trainingsepoche besteht aus einer vorwärts- und rückwärts-Propagierung aller Trainingsdaten, sowie einer anschließenden formellen Evaluierung auf Basis der Testdaten.
   * Je Epoche werden einige Werte, die Rückschluss über die Güte des Modells geben berechnet
   * Je Epoche werden die Ergebnisse in eine Excel-Tabelle geschrieben, die unter /Results/ und dem Modellnamen+UUID abgelegt wird
   * zusätzlich werden die Ergebnisse per Konsole ausgegeben
   * Bei Abbruch durch Strg + C oder Erfüllung von Abbruchkritereien werden die aktuellen Modellparameter (Neuronengewichte) unter /Model_Export/ in einem Ordner [Modellnamen+UUID] gesichert.
   * Bei Abbruch wird außerdem eine Klassifikationsmatrix in die Excel geschrieben

#### Klassifizierung:
* zur Online-Klassifizierung werden bestehende Modelle geladen
* es wird eine WS-Verbindung zur Verwaltungskomponente aufgebaut
   * die Verwaltungskomponente sendet Merkmalsvektoren an die Klassifizierungskomponente
   * sofern diese das richtige JSON-Format haben werden die Merkmalsvektoren klassifiziert
   * das Ergebnis der Klassifikation wird an die Verwaltungskomponente zurückgesendet
   
   
### Das neuronale Netz
* grundlegende Parameter wie die Anzahl an Layern, die Neuronenanzahl, die Abbruchkriterien und zahlreiche andere Funktionen können über die preferences.xml agepasst werden (Die Verwaltungskomponente enthält eine GUI zur Anpassung dieser Parameter).
* jedes ANN besteht aus LSTM-Neuronen

![LSTM-Zelle](https://github.com/larsbadde/NUI_4.0/blob/master/img/LSTM_AND_BASIC_with_gates.png)

* jedes Netz besitzt einen CTC-Output-Layer zur Herstellung der temporalen Zusammenhänge

(für nähere Informationen wird auf die schriftliche Ausarbeitung verwiesen)