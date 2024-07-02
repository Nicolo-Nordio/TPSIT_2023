# CONSEGNA

Creare una classe `Counter` con la possibilità di utilizzare i metodi `increase` e `decrease`. I due metodi ritornano il valore del **contatore**. `decrease` può decrementare solo se il contatore è maggiore di 0.

Creare due tipologie di thread una che incrementa e una che decrementa.  
Lanciare i Thread e vedere cosa succede (in particolare un incrementatore e più decrementatori).

Rendere i metodi del Counter `synchronized` e vedere cosa succede.

**Risposta**

L'output potrebbe variare a ogni esecuzione, poiché i thread sono eseguiti in modo concorrente e non c'è una garanzia sull'ordine delle operazioni. Con l'utilizzo del metodo synchronized, viene garantito che solo un thread alla volta possa accedere ai metodi critici del contatore, evitando così eventuali problemi di concorrenza
