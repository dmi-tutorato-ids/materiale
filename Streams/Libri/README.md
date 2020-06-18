# Java 8 Streams: Libri

Il codice di ogni esercizio è definito tramite un test *JUnit*, completo di asserzioni scritte con *AssertJ*, una libreria molto usata per scrivere asserzioni complesse con uno stile fluent.

Il progetto *Maven* contiene:

- *Libro*: una semplice classe usata per gli esercizi sugli stream: ogni libro è caratterizzato da un titolo, un costo e una categoria;

- *Libreria*: una classe composta da metodi statici usata per generare dei libri di vario genere. La generazione avviene in maniera deterministica (non viene usato random()) in modo da permettere di scrivere test con esito prevedibile.

- *TestBasiStream*: file di test in cui vengono mostrati i concetti di interfaccia funzionale ed espressioni lambda;

- *TestLibri*: file di test in cui vengono mostrati diversi esercizi  sull'uso degli stream.
