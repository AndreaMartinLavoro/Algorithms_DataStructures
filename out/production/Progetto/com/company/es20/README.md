# ALBERI BINARI DI RICERCA AVL

----
Si richiede l'implementazione di un albero binario di ricerca di tipo AVL, in cui ciascun nodo contiene una chiave numerica 
(di tipo intero) e un valore alfanumerico (di tipo stringa). Un albero binario di ricerca di tipo AVL supporta le classiche 
operazioni di inserimento, ricerca, e rimozione di nodi, garantendo allo stesso tempo la proprietà di bilanciamento seguente: 
per ogni nodo 𝑥, le altezze dei sotto-alberi di sinistra e di destra nel nodo 𝑥 differiscono al più di 1. Tale proprietà 
viene garantita eseguendo opportune rotazioni sui nodi sbilanciati, partendo dal nodo sbilanciato più profondo (ad esempio, 
il "nonno" del nodo appena inserito) e procedendo risalendo lungo il cammino di accesso a quel nodo. Per le operazioni di 
ribilanciamento sarà necessario mantenere l'informazione relativa all'altezza di ciascun nodo, in modo da evitare il calcolo 
diretto di essa (tale calcolo prenderebbe tempo lineare nella dimensione del sotto-albero).

Più precisamente, il ribilanciamento di un nodo 𝑥 avviene nell'ipotesi che le altezze dei figli di 𝑥 siano note e differiscano 
esattamente di 2 unità, e che entrambi i sotto-alberi radicati nei figli di 𝑥 soddisfino la proprietà di bilanciamento. 
L'effetto dell'operazione di ribilanciamento su 𝑥 sarà che l'intero sotto-albero radicato in 𝑥 soddisfa la proprietà di 
bilanciamento. L'operazione di ribilanciamento su 𝑥 effettua una distinzione di casi, a seconda di quale figlio di 𝑥 abbia 
il sotto-albero più alto. Si consideri il caso in cui il sotto-albero del figlio sinistro di 𝑥 abbia altezza maggiore di
quello del figlio destro (il caso simmetrico può essere trattato in modo del tutto analogo). Sia 𝑦 il figlio sinistro 
di 𝑥 e siano 𝑧1 e 𝑧2 i figli sinistro e destro di 𝑦 (quindi due "nipoti" di 𝑥). Se il sotto-albero radicato in 𝑧1 ha altezza 
maggiore o uguale a quella del sotto-albero radicato in 𝑧2, allora basterà effettuare una rotazione verso destra sul nodo 𝑥. 
Altrimenti, se il sotto-albero radicato in 𝑧1 ha altezza minore di quella del sotto-albero radicato in 𝑧1, allora, prima di 
effettuare una rotazione verso destra sul nodo 𝑥, sarà opportuno effettuare una rotazione verso sinistra sul nodo 𝑦, in 
modo da riportarsi al caso analizzato precedentemente.

A seguito delle operazioni di ribilanciamento, un albero di ricerca di tipo AVL mantiene un'altezza proporzionale al logaritmo 
del numero dei suoi nodi. In particolare, tutte le operazioni supportate da un albero di ricerca di tipo AVL avranno complessità 
logaritmica rispetto al numero di nodi.