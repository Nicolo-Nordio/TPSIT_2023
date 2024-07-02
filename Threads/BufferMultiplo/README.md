Riprendendo l'esempio produttore-consumatore, creare un nuovo progetto in cui il buffer ha a sua disposizione 100 celle per conservare i dati. Ogni produttore può scrivere 1 nella cella se è presente 0, ogni consumatore può scrivere 0 nella cella se è presente 1. I metodi load e consume devono ritornare l'indice della posizione dell'array in cui scrivono/leggono.  
Si realizzino le seguenti varianti (in ordine):

- Sono presenti 5 produttori in grado di produrre 20 elementi ciascuno e 5 consumatore in grado di consumare 20 elementi ciascuno. Verificare la corretta sincronizzazione dei metodi.
- I produttori e consumatori non hanno limiti di elementi, ed utilizzano il buffer in modo ciclico.
- I produttori tra un load e un altro necessitano di un tempo tra i 100 e i 200 ms. i consumatori tra un consume e l'altro necessitano di un tempo tra i 50 e i 200 ms. Simulare la situazione con alcuni delay variabili e vedere cosa succede.
