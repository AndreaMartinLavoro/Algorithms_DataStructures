# Grafi
I grafi sono una struttura dati molto utilizzata in informatica e matematica per rappresentare le relazioni tra oggetti. Sono costituiti da un insieme di nodi (o vertici) e da un insieme di archi (o spigoli) che collegano i nodi. I nodi rappresentano gli oggetti, mentre gli archi rappresentano le relazioni tra di essi.

### Tipologie di Grafi
- Pesati / Non Pesati
- Orientati / Non Orientati

### Argomenti Grafi NON Pesati
- visite BFS (visita in ampiezza)
- visite DFS (visita in profondità)

### Argomenti Grafi Pesati
- calcolo albero minimo di copertura MST
- cammini di peso minimo SSSP
- cammini di peso minimo APSP

### Grafo Orientato
Un grafo orientato è una struttura dati in cui ho 2 insiemi G = (V, E), dove:
- V è un insieme finito di nodi (vertici)
- E ⊆ VxR insieme finito di archi

### Grafo NON Orientato
E’ un insieme finito di coppie di nodi della forma { u,v } V={1,2,3,4,...,|V|}alloraEpotrebbeessereE={(1,2),(3,4),...,(|V|-1,|V|-1) }

(|V|-1, |V|-1) è un self loop in quanto punta a se stesso.

### Come memorizzare i grafi
- matrice di adiacenza
- liste di adiacenza
  ***N.B.*** E’ preferibile utilizzare liste di adiacenza per grafi sparsi, e matrici di adiacenza per grafi densi.

### Cammini
Una sequenza finita di archi.

### Alberi liberi
Sono alberi in cui ogni nodo ha un numero arbitrario di figli e i nodi non hanno un ordinamento specifico.

G=(V, E) non orientato è un albero libero sse è connesso e aciclico.

### Visita BFS: in ampiezza
La BFS (visita in ampiezza) esplora il grafo a partire da un nodo iniziale e visita tutti i nodi adiacenti di livello immediatamente successivo prima di passare ai nodi adiacenti di livello successivo.

In altre parole, la BFS esplora il grafo a "ampiezza", visitando prima tutti i nodi a distanza 1 dal nodo iniziale, poi quelli a distanza 2, e così via.

### Visita DFS: in profondità
La DFS (visita in profondità) esplora il grafo a partire da un nodo iniziale e prosegue fino a quando non si raggiunge un nodo foglia (un nodo senza nodi adiacenti non visitati) e quindi torna indietro.

L'algoritmo esplora il grafo a "profondità", visitando un percorso fino a quando non raggiunge un punto di arresto e quindi tornando indietro per esplorare altri percorsi.

### MST: Minimum Spanning Tree
Il calcolo dell'albero di copertura minimo (Minimum Spanning Tree, MST) è un problema classico nell'ambito della teoria dei grafi. 
Esistono diversi algoritmi che possono essere utilizzati per calcolare l'MST di un grafo, tra cui l'algoritmo di Prim e l'algoritmo di Kruskal.

- L'***algoritmo di Prim*** parte da un nodo arbitrario e aggiunge iterativamente l'arco di peso minimo che collega il sottoinsieme di nodi già visitati con il sottoinsieme di nodi non ancora visitati. Continua ad aggiungere archi fino a quando tutti i nodi sono inclusi nell'albero di copertura. L'algoritmo termina quando tutti i nodi sono visitati o quando non ci sono più archi disponibili per collegare il sottoinsieme di nodi.
- L'***algoritmo di Kruskal***, d'altra parte, costruisce l'albero di copertura minimo aggiungendo iterativamente l'arco di peso minimo tra quelli disponibili, a condizione che non crei un ciclo nel grafo parziale. L'algoritmo continua ad aggiungere archi fino a quando tutti i nodi sono inclusi nell'albero di copertura.

### SSSP: Single-Source Shortest Path
Il calcolo dei cammini di peso minimo, noto anche come Single-Source Shortest Path (SSSP), è un altro problema classico nella teoria dei grafi. 
Esistono diversi algoritmi noti per risolvere questo problema, tra cui l'algoritmo di Dijkstra e l'algoritmo di Bellman-Ford.

- L'***algoritmo di Dijkstra*** trova il cammino di peso minimo da un nodo sorgente a tutti gli altri nodi nel grafo, assumendo che tutti i pesi degli archi siano non negativi. Inizia selezionando il nodo sorgente e assegna un valore di distanza iniziale di 0 a quel nodo. Successivamente, si espande in modo greedy selezionando il nodo con la distanza minima non ancora visitato e aggiornando le distanze dei suoi vicini se si trova un percorso più breve. L'algoritmo continua fino a quando tutti i nodi sono stati visitati o fino a quando il nodo di destinazione è stato raggiunto.
- L'***algoritmo di Bellman-Ford***, d'altra parte, funziona anche con pesi negativi sugli archi, ma può gestire anche grafi con cicli negativi raggiungibili dalla sorgente. Parte assegnando una distanza infinita a tutti i nodi tranne alla sorgente, a cui assegna una distanza di 0. Successivamente, rilassa iterativamente tutti gli archi del grafo, cercando di migliorare le distanze dei nodi raggiunti fino a quel punto. L'algoritmo esegue questa iterazione V-1 volte, dove V è il numero di nodi nel grafo. Se al termine delle V-1 iterazioni si verificano ancora miglioramenti, allora il grafo contiene un ciclo di peso negativo.

### APSP: All-Pairs Shortest Path
Il calcolo di tutti i cammini di peso minimo, noto come All-Pairs Shortest Path (APSP), è un problema che richiede di determinare il cammino di peso minimo tra ogni coppia di nodi in un grafo. 
Esistono diveersi algoritmi che possono essere utilizzati per risolvere questo problema, tra cui l'algoritmo di Floyd-Warshall e l'algoritmo di Johnson.

- L'algoritmo di Floyd-Warshall è un algoritmo di programmazione dinamica che calcola la distanza minima tra tutti i nodi del grafo. Crea una matrice delle distanze inizializzata con i pesi degli archi noti e successivamente esegue un processo iterativo per aggiornare le distanze minime tra i nodi. L'algoritmo considera ogni nodo come un possibile nodo intermedio nel calcolo del cammino di peso minimo tra due nodi e utilizza la tecnica della programmazione dinamica per calcolare le distanze minime.
- L'algoritmo di Johnson è un'altra alternativa per calcolare tutti i cammini di peso minimo in un grafo. Questo algoritmo è basato sull'algoritmo di Dijkstra ed è particolarmente efficiente per grafi con pesi negativi. L'algoritmo di Johnson aggiunge un passo iniziale per trasformare il grafo in un grafo senza pesi negativi utilizzando una tecnica chiamata rilassamento degli archi. Dopo la trasformazione, l'algoritmo di Dijkstra viene applicato a ciascun nodo del grafo trasformato per calcolare i cammini di peso minimo.