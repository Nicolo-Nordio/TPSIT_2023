# Threads

Dentro lo stesso processo eseguo un'altra linea di esecuzione. 
Fisicamente è un **core multithread**, il singolo core può eseguire 2 thread **contemporaneamente**.

Può entrare in **runnable** e **sleep/wait**

Il thread da **runnable** va in **run**

Per mandare un processo in **sleep** --> **Thread.spleep()**

Da **run** a **runnable** --> **Thread.yeld()** se so di avere una computazione lunga, andando in yeld libero la risorsa fisica che esegue il thread.

**Thread.join()** --> aspetta che questo thread termini l'esecuzione, una volta terminata riprende la sua computazione.

L'istruzione opposta alla join: **fork()** --> permetteva ai processi di lanciare un altro processo a loro parallelo. 
Oggi si usa **start()** che chiama il metodo che implementa l'interfaccia Runnable