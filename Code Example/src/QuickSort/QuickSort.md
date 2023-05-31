# QuickSort.QuickSort
## Idea
Supponiamo di avere un array A.
Il quicksort opera scegliendo un indice casuale, chiamato pivot (o perno, in italiano), così da dividire il vettore in due parti. Successivamente si occupa di portare alla sinistra del pivot gli elementi minori o uguali ad esso e a destra quelli maggiori. Infine chiama ricorsivamente i due sottoarray e vi esegue le medesime operazioni.
Il passaggio “combina” in questo algoritmo non è necessario, perché dopo tutte le chiamate ricorsive, l’array è ordinato.

![QuickSort1.gif](QuickSort1.gif)

![QuickSort2.gif](QuickSort2.gif)

## Pseudocodice e descrizione

Il quicksort comprende una procedura chiamata partition, che si occupa di spostare gli elementi e di ritornare il valore dell’indice di mezzo, e poi due chiamate ricorsive sui due sottoarray.

## Calcolo della Complessità

## Dimostrazione di Correttezza

## Info
non in-place
una ricorsione e una ricorsione di coda (entrambe eliminabili ma con difficoltà)
la piazza sceglie sempre l'ultimo elemento come perno (pivot).

[Sito Web](https://ifif.altervista.org/quicksort-come-funziona-esempio/?doing_wp_cron=1683362475.6059339046478271484375)