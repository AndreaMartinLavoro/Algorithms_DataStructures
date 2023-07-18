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