# Alberi Binari di Ricerca

I ***BST (Binary Search Trees)***, alberi di ricerca binari in italiano, sono una struttura dati utilizzata per organizzare un insieme di dati in modo efficiente per le operazioni di ricerca, inserimento e cancellazione.

Un ***BST*** è costituito da nodi collegati in modo gerarchico. Ogni nodo ha un valore associato e due puntatori, uno che punta al figlio sinistro e uno che punta al figlio destro. I valori dei nodi nel sottoalbero sinistro sono minori o uguali al valore del nodo padre, mentre i valori dei nodi nel sottoalbero destro sono maggiori del valore del nodo padre.

Questa caratteristica, chiamata "proprietà del BST", consente di eseguire ricerche efficienti all'interno dell'albero.

### Inserimento
L'inserimento di un nuovo valore in un BST avviene confrontando il valore da inserire con il valore dei nodi correnti e scegliendo il percorso corretto verso il basso dell'albero fino a trovare una posizione vuota dove inserire il nuovo nodo.

### Ricerca
La ricerca in un BST segue lo stesso principio: confrontando il valore da cercare con il valore dei nodi correnti, si può decidere di continuare la ricerca nel sottoalbero sinistro o destro fino a trovare il nodo desiderato o determinare che il valore cercato non è presente nell'albero.

### Cancellazione
La cancellazione di un nodo da un BST può avvenire in diverse modalità, a seconda dei casi: se il nodo da eliminare non ha figli, viene semplicemente rimosso; se ha un solo figlio, il figlio viene collegato al padre del nodo da eliminare; se ha due figli, si cerca il successore o il predecessore del nodo da eliminare e si sostituisce il nodo da eliminare con il successore o il predecessore, mantenendo la proprietà del BST.

#### Costo Medio: O(ln n)
Grazie alla sua struttura gerarchica e alla proprietà del BST, questa struttura dati offre una ***buona efficienza per le operazioni di ricerca, inserimento e cancellazione, con un tempo di esecuzione medio di O(log n) per operazioni bilanciate***, ma può degenerare in un albero non bilanciato con un tempo di esecuzione peggiore nel caso peggiore di O(n). 