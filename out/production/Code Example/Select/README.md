# Select

Problema di selezione; dato un vettore A di n interi, dato un indice k (1 <= k <= n) determinare il k-esimo elemento più piccolo del vettore, ovvero determinare l'elemento che finirebbe in posizione k se ordinassi il vettore.
### C'è un algoritmo che funziona con complessità Θ( n ) in qualsiasi caso e sfrutta Partition

## Idea
- divido in blocchi da 5
- trovo n/5 mediani dei blocchi e li copio nel vettore b
- richiamo Select su b: Select( B, 1⁄2(n/5), 1, (n/5) ) e ottengo M
- Partition( A, p, q, M ) mi ritorna la posizione in cui è finito il perno
  - sek=rritornoM
  - sek<ralloraSelect(A,k,p,r-1) 
  - sek>rSelect(A,r+1,q)

### Quindi Select: T( n ) = T( n/5 ) + T( 3⁄4 n ) + bn, ha soluzione Θ( n )
Nota importante: noi abbiamo scelto 1⁄5 e 3⁄4 come coefficienti. Ma la situazione non cambiava se avessi scelto delle costanti diverse a patto che la somma sia < 1.
Siccome 1⁄5 + 3⁄4 < 1 va bene. Questo perché alla fine viene sempre una serie geometrica di ragione < 1 che permette la convergenza ad una costante e rende l’equazione lineare.