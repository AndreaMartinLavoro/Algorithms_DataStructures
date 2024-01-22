## Alberi Binari
Struttura dati gerarchica composta da nodi, in cui ogni nodo ha al massimo due figli, che sono generalmente denominati "figlio sinistro" e "figlio destro". Ogni nodo in un albero binario è collegato a un nodo superiore, noto come "genitore", tranne per il nodo iniziale, chiamato "radice", che non ha genitore, e i nodi finali, chiamati "foglie", che non hanno figli.

### Alberi bilanciati
Un albero è detto bilanciato se la sua altezza è logaritmica rispetto ai nodi -> **h = O(log n)**

### Alberi completi
Un albero è completo se ogni nodo interno ha 2 figli e tutte le foglie dell'albero sono allo stesso livello.

### Visite
1. previsit
2. inorder
3. postorder

## Alberi Binari di Ricerca (BST)
In un albero binario di ricerca, ogni nodo ha un valore associato, e la regola è che **tutti i nodi nel sottoalbero sinistro di un nodo devono avere valori minori o uguali al valore del nodo, mentre tutti i nodi nel sottoalbero destro devono avere valori maggiori o uguali al valore del nodo**.
Questa proprietà rende l'albero binario di ricerca particolarmente utile per operazioni di ricerca efficienti, poiché è possibile eliminare interi sottoalberi durante la ricerca.

## Alberi binari di icerca Rosso-Neri (RBT), o Red-Black Trees
Sono una forma di albero binario di ricerca bilanciato. Questo tipo di albero viene utilizzato per garantire una buona altezza dell'albero in modo da mantenere alte prestazioni nelle operazioni di inserimento, eliminazione e ricerca.

### Le principali caratteristiche sono:
1. **Colorazione dei Nodi:** Ogni nodo nell'albero è associato a un colore, che può essere rosso o nero.
2. **Proprietà delle Impurità Rosse:** In un RBT, non ci possono essere due nodi rossi consecutivi su un percorso dalla radice a una foglia. Questa proprietà garantisce che l'altezza dell'albero rimanga bilanciata.
3. **Nodo Sentinella Nera:** Tutti i nodi null, o foglie, sono considerati nodi sentinella neri. Questi nodi sentinella neri vengono aggiunti per semplificare le regole e mantenere la proprietà dell'altezza bilanciata.
4. **Radice e Foglie Nere:** La radice dell'albero e tutte le foglie (nodi null) sono considerate nere. Questa regola aiuta a garantire che l'albero abbia un'altezza bilanciata.
5. **Proprietà delle Impurità Nere:** Per ogni nodo, il numero di nodi neri lungo qualsiasi percorso che inizia dal nodo e termina in una delle sue foglie deve essere lo stesso. Questa regola assicura che l'albero rimanga bilanciato.

Le operazioni di inserimento, eliminazione e ricerca sono progettate per mantenere queste proprietà, garantendo così un bilanciamento efficiente dell'altezza dell'albero. **L'obiettivo è garantire che l'altezza dell'albero sia logaritmica rispetto al numero di nodi**, il che mantiene le operazioni di base dell'albero efficienti.
**N.B.** Sono ampiamente utilizzati nelle implementazioni di strutture dati nelle librerie standard di molti linguaggi di programmazione.

#### Rotazione a destra
La rotazione a destra viene eseguita quando un nodo diventa il figlio sinistro del suo attuale figlio destro.
```
    A              B
   / \            / \
  B   C    =>    D   A
 / \                / \
D   E              E   C
```

#### Rotazione sinistra
La rotazione a sinistra viene eseguita quando un nodo diventa il figlio destro del suo attuale figlio sinistro.
```
    B              A
   / \            / \
  D   A    <=    B   C
     / \        / \
    E   C      D   E
```

**N.B.** Le rotazioni nei Red-Black Tree sono uno strumento chiave per mantenere la struttura bilanciata dell'albero, garantendo che le sue proprietà siano rispettate dopo le operazioni di inserimento e rimozione.