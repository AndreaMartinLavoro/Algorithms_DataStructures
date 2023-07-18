
# Red-Black Tree (RBT)
I **Red-Black Tree (RBT)** sono un tipo di albero di ricerca binario bilanciato che utilizza un insieme specifico di regole per garantire che l'albero sia sempre bilanciato.
Questo saldo garantisce che la complessità temporale per operazioni come inserimento, eliminazione e ricerca sia sempre **O(log n)**, indipendentemente dalla forma iniziale dell'albero.

Gli **RBT** sono autobilanciati, il che significa che l'albero si regola automaticamente dopo ogni operazione di inserimento o cancellazione.
Utilizza un meccanismo semplice ma potente per mantenere l'equilibrio, colorando ogni nodo dell'albero di rosso o nero.

## Proprietà dell'albero rosso nero:
L'**RBT** soddisfa tutte le proprietà dell'albero di ricerca binario oltre a soddisfare le seguenti proprietà aggiuntive –
1. **Proprietà di ricerca binaria**: Ogni nodo dell'albero ha al massimo due figli (uno sinistro e uno destro). I valori del sottoalbero sinistro sono inferiori o uguali al valore del nodo, mentre i valori del sottoalbero destro sono maggiori.
2. **Proprietà dei colori**: Ogni nodo dell'albero è colorato di rosso o nero. L'attributo di colore è utilizzato per bilanciare l'albero.
3. **Proprietà di radice e foglia nera**: La radice dell'albero e ogni nodo foglia (cioè senza figli) devono essere neri. Le foglie possono essere rappresentate da nodi "sentinella" (solitamente noti come NIL) con colore nero (**LE FOGLIE SONO O NILL O BLACK**).
4. **Proprietà dei figli rossi**: Se un nodo è rosso, entrambi i suoi figli devono essere neri. Questo impedisce che ci siano due nodi rossi consecutivi lungo qualsiasi percorso dall'albero (**OGNI NODO RED HA 2 FIGLI BLACK**).
5. **Proprietà dell'altezza nera**: Ogni percorso dalla radice alle foglie deve avere lo stesso numero di nodi neri. Questo garantisce che l'altezza dell'albero sia bilanciata e non cresca in modo eccessivo (**PER OGNI NODO x LUNGO OGNI CAMMINO x-foglia SI TROVA SEMPRE LO STESSO NUMERO DI BLACK**).
6. **La radice è Black** (non è indispensabile!)

## Regole che ogni albero rosso-nero segue:
1. Ogni nodo ha un colore rosso o nero.
2. La radice dell'albero è sempre nera.
3. Non ci sono due nodi rossi adiacenti (un nodo rosso non può avere un genitore rosso o un figlio rosso).
4. Ogni percorso da un nodo (compresa la radice) a uno qualsiasi dei suoi nodi NULL discendenti ha lo stesso numero di nodi neri.
5. Ogni foglia (e.i. nodo NULL) deve essere colorato NERO.

## Punti interessanti sull'albero rosso-nero:
1. L'altezza nera dell'albero rosso-nero è il numero di nodi neri su un percorso dal nodo radice a un nodo foglia. Anche i nodi fogliari sono contati come nodi neri. Quindi, un albero rosso-nero di altezza h ha altezza nera >= h/2.
2. L'altezza di un albero rosso-nero con n nodi è h<= 2 log2(n + 1).
3. Tutte le foglie (NIL) sono nere.
4. La profondità nera di un nodo è definita come il numero di nodi neri dalla radice a quel nodo, cioè il numero di antenati neri.
5. Ogni albero rosso-nero è un caso speciale di un albero binario.

## Altezza nera di un albero rosso-nero:
L'altezza nera è il numero di nodi neri su un percorso dalla radice a una foglia. Anche i nodi foglia sono contati nodi neri. Dalle proprietà di cui sopra 3 e 4, possiamo derivare, **un albero rosso-nero di altezza h ha altezza nera >= h/2**.

**Ogni albero nero rosso con n nodi ha altezza** <= 2Log2(n+1)

## La ricolorazione
Nel contesto dei Red-Black Tree, la ricolorazione è un'operazione che viene eseguita per mantenere le proprietà dell'albero dopo l'inserimento o la cancellazione di un nodo. La ricolorazione coinvolge la modifica dei colori dei nodi dell'albero per soddisfare le regole dei Red-Black Tree.

## La rotazione
La **rotazione** è un'operazione fondamentale nei Red-Black Tree che viene utilizzata per mantenere le proprietà dei nodi durante l'inserimento o la cancellazione di un nodo.

Esistono due tipi di rotazioni nei Red-Black Tree:
- la rotazione a sinistra (left rotation)
- la rotazione a destra (right rotation).

Entrambe le rotazioni vengono eseguite attorno a un nodo specifico per modificare la struttura dell'albero e mantenere l'equilibrio.

**Per comprendere meglio le rotazioni**, consideriamo un Red-Black Tree con un nodo di esempio chiamato "x".
Possiamo effettuare una rotazione a sinistra o a destra attorno al nodo "x".

## Vediamo i passaggi per entrambe le rotazioni:

### Rotazione a sinistra (Left Rotation):

Per eseguire una rotazione a sinistra attorno al nodo "x":

Prendiamo il figlio destro di "x" chiamato "y" e lo impostiamo come il nuovo nodo radice dell'albero.
Il figlio sinistro di "y" diventa il nuovo figlio destro di "x".
Il vecchio padre di "y" diventa il nuovo padre di "x".
"x" diventa il nuovo figlio sinistro del vecchio padre di "y".
Questa rotazione viene spesso utilizzata per bilanciare l'albero quando un nodo viene inserito come figlio destro di un nodo già esistente, creando una situazione di "violazione" delle proprietà dei Red-Black Tree.

### Rotazione a destra (Right Rotation):
Per eseguire una rotazione a destra attorno al nodo "x":

Prendiamo il figlio sinistro di "x" chiamato "y" e lo impostiamo come il nuovo nodo radice dell'albero.
Il figlio destro di "y" diventa il nuovo figlio sinistro di "x".
Il vecchio padre di "y" diventa il nuovo padre di "x".
"x" diventa il nuovo figlio destro del vecchio padre di "y".
Questa rotazione viene utilizzata per bilanciare l'albero quando un nodo viene inserito come figlio sinistro di un nodo già esistente, generando una violazione delle proprietà dei Red-Black Tree.

**L'obiettivo principale delle rotazioni** è mantenere le seguenti proprietà dei Red-Black Tree:
- Ogni nodo è rosso o nero.
- La radice è sempre nera.
- Ogni foglia (NIL) è nera.
- Se un nodo è rosso, entrambi i suoi figli sono neri.
- Per ogni nodo, tutti i cammini dal nodo alle foglie contenenti lo stesso numero di nodi neri.

Effettuando le rotazioni in modo appropriato, l'albero può essere bilanciato e queste proprietà vengono preservate. Ciò garantisce che l'albero rimanga approssimativamente bilanciato e che le operazioni di inserimento, cancellazione e ricerca siano efficienti con una complesslessità di tempo garantita (O(log n), dove "n" è il numero di nodi nell'albero).

Le rotazioni nei Red-Black Tree sono un concetto chiave per mantenere la struttura e l'equilibrio dell'albero durante le operazioni di inserimento e cancellazione. Spero che questa spiegazione ti abbia aiutato a comprendere il concetto di rotazione nei Red-Black Tree.
