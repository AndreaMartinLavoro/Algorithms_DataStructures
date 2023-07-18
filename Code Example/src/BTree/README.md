# B Tree
Un ***B Tree*** è una struttura dati ad albero bilanciato che viene utilizzata per organizzare dati in modo efficiente e supportare operazioni come inserimento, ricerca e rimozione.

Un ***B Tree*** di grado ***t >= n*** è un albero che soddisfa le seguenti caratteristiche:
- ogni nodo x ha un vettore di chiavi x.key, un vettore di puntatori ai figli x.c., un campo booleano x.leaf, un campo intero x.n che indica la quantità di chiavi memorizzate in x.
- x.leaf = TRUE se e soltanto se x è una foglia
- tutte le foglie in T si trovano allo stesso livello (albero completo)
- x.key contiene sempre x.n chiavi
- se x non è una foglia, x.c contiene x.n+1 puntatori ai figli di x
- se x non è la radice,x.n è compreso tra t-1<=x.n<=2t-1
- se x è la radice 1<=x.n<=2t-1

Quindi la radice può avere minimo 1 e massimo 2t-1 chiavi.

È una struttura dati molto utilizzata in molti sistemi di database, file system e mappe di di navigatori satellitari.

N.B. solitamente risiedono in memoria secondaria

### Come scegliere il grado?
Il grado del B Tree deve essere calibrato in base al calcolatore che sto utilizzando e all’applicazione che intendo sviluppare.

### Caratteristiche:
1. I nodi hanno un numero variabile di figli
2. C'è un ordinamento tra i figli di un nodo
3. Le foglie sono tutte allo stesso livello

### Complessità Ricerca:
- ***R/W:*** al massimo caricherò in memoria tanti nodi quanta è l’altezza dell’albero, quindi: O(h)=O(logt n),Ω(1)
- ***CPU:*** Il ciclo while viene eseguito O ( t ) volte, le altre operazioni al massimo tante volte quanta è l’altezza dell’albero, quindi:
  O(t⋅h)=O(t⋅logt n),Ω(1)

***IDEA:*** Partendo dalla radice scandisco ogni nodo alla ricerca di k, quando trovo un valore maggiore di k scendo nel sottoalbero i-esimo del nodo che sto scandendo, e ripeto.

### Complessità Split:
#### Nell'inserimento il problema viene quando devo inserire k in una foglia che è piena.
- ***CPU:*** O( t ) dato dal costo dei vari cicli for, se unisco i 2 ultimi cicli for ottengo un miglioramento per quanto riguarda le costanti moltiplicative.
- ***R/W:*** soltanto 3 volte DiskWrite, quindi Θ( 1 )

***IDEA:*** Dato che un nodo pieno ha 2t-1 chiavi, che è sempre dispari, posso dividerlo in 2 porzioni uguali (t-1) e portare la cella centrale nel nodo superiore. Potrei incontrare così facendo altri nodi pieni, e dover fare altri split.

### Complessità Inserimento:
- ***CPU:*** Ad ogni passo della discesa scandisco al massimo tutte le chiavi del nodo, quindi: O(t⋅logt n),Ω(logt n)
- ***R/W:*** Almeno 1 read ogni volta che devo scendere, a volte 2 o 3, in ogni caso: Θ( logt n )

### Complessità Cancellazione:
- ***CPU:*** Su ogni nodo attraversato, al massimo verranno spostate tutte le chiavi e i figli:
  O(t⋅logt n),Ω(logt n)
- ***R/W:*** Al massimo scenderò una volta nell’albero, operando su un nodo per ogni
  livello:
  Θ( logt n )