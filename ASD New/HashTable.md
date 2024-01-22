# Hash Table
Struttura dati usata per mettere in corrispondenza una data chiave con un dato valore.
Utilizza nei metodi di ricerca chiamati hashing; tecnica totalmente diversa dalla ricerca basata su confronti: invece di muoversi nella struttura in funzione dell'esito dei confronti tra chiavi, si cerca di accedere agli elementi nella tabella tramite operazioni aritmetiche che trasformano le chiavi in indirizzi della tabella.

**N.B.** in una tabella di hashing ben dimensionata il costo medio di ricerca di ogni elemento è indipendente dal numero di elementi.

## Funzioni di hash
- BucketSort
- Metodo della divisione
- Metodo della moltiplicazione

Il primo passo per realizzare algoritmi di ricerca tramite hashing è quello di determinare la funzione di hash: il dato da indicizzare viene trasformato da un'apposita funzione di hash in un intero compreso tra 0 ed m-1 che viene utilizzato come indice in un array di lunghezza m.

**COLLISIONE** -> Poiché non esiste la funzione di hash perfetta, ovvero totalmente iniettiva, è possibile che due o più chiavi diverse siano convertite nello stesso indirizzo.
La scelta di una buona funzione di hash è indispensabile per ridurre al minimo le collisioni. Il risultato migliore si ha con funzioni pseudo-casuali che distribuiscono i dati in input in modo uniforme.

**LOAD FACTOR** -> il fattore di carico dice quanta probabilità ha un nuovo elemento di collidere con uno già presente nella tabella.
[cardinalità insieme di chiavi da inserire / dimensione massima della struttura]

**N.B.** probabilità più alta di quanto si possa pensare, come dimostra il paradosso del compleanno.

## Gestione delle collisioni
1. Hashing con Open Addressing
2. Hash con chaining *(propedeutico)*

### Hash con chaining
Affronta le collisioni consentendo a più elementi di occupare la stessa posizione, creando una lista concatenata (chiamata "lista di collisione") in ogni cella della tabella hash.

### Hashing con Open Addressing
Tutti gli elementi sono memorizzati nella tavola hash stessa; ovvero ogni cella della tavola contiene un elemento dell'insieme dinamico o la costante NULL. Quando cerchiamo un elemento, esaminiamo sistematicamente le celle della tavola finché non troviamo l'elemento desiderato o finché non ci accorgiamo che l'elemento non si trova nella tavola.
**N.B.** la tavola hash può "riempirsi" al punto tale che non possono essere effettuati altri inserimenti.
Il vantaggio dell'indirizzamento aperto sta nel fatto che esclude completamente i puntatori, calcoliamo la sequenza delle celle da esaminare (**ispezione**).

Un concetto importante al riguardo è il cosiddetto **hashing uniforme**. Rappresenta l'hashing ideale, ovvero ogni cella della tabella ha la stessa probabilità di contenere un dato elemento.

## Tecniche di ispezione
1. ispezione lineare
2. ispezione quadratica
3. doppio hashing

**N.B.** nessuna di queste tecniche soddisfa l'ipotesi di hashing uniforme, in quanto nessuna di esse è in grado di generare più di **m^2** sequenze di ispezione differenti (anziché **m!**, come richiede l'hashing uniforme).

### Ispezione lineare
Quando si incontra una collisione non si fa altro che utilizzare l'indice successivo a quello che collide, sino a che non si trovi una casella libera.

### Ispezione quadratica
Quando si incontra una collisione non si fa altro che utilizzare l'indice che collide elevato al quadrato con normalizzazione rispetto alla grandezza della tabella dell'indice ottenuto, sino a che non si trovi una casella libera.

### Doppio hashing
Se facendo l'hash di una chiave si incontra una collisione, allora si somma all'indice ottenuto il risultato di una nuova funzione hash (generalmente diversa dalla prima e che ha come parametro l'indice ottenuto precedentemente), e si tenta l'inserimento nel nuovo indice così ottenuto, riapplicando la seconda funzione sino a che non si trovi una casella libera.