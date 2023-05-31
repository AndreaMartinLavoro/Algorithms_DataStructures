# Insertion Sort
L'Insertion sort, in italiano ordinamento a inserimento, è un algoritmo relativamente semplice per ordinare un array. Non è molto diverso dal modo in cui un essere umano, spesso, ordina un mazzo di carte. Esso è un algoritmo in place, cioè ordina l'array senza doverne creare una copia, risparmiando memoria.

## Idea
L'algoritmo solitamente ordina la sequenza sul posto. Si assume che la sequenza da ordinare sia partizionata in una sottosequenza già ordinata, all'inizio composta da un solo elemento, e una ancora da ordinare. 
Alla k-esima iterazione, la sequenza già ordinata contiene k elementi.
In ogni iterazione, viene rimosso un elemento dalla sottosequenza non ordinata (scelto, in generale, arbitrariamente) e inserito (da cui il nome dell'algoritmo) nella posizione corretta della sottosequenza ordinata, estendendola così di un elemento.

Per fare questo, un'implementazione tipica dell'algoritmo utilizza due indici: uno punta all'elemento da ordinare e l'altro all'elemento immediatamente precedente. 
Se l'elemento puntato dal secondo indice è maggiore di quello a cui punta il primo indice, i due elementi vengono scambiati di posto; altrimenti il primo indice avanza. 
Il procedimento è ripetuto finché si trova nel punto in cui il valore del primo indice deve essere inserito. Il primo indice punta inizialmente al secondo elemento dell'array, il secondo inizia dal primo. L'algoritmo così tende a spostare man mano gli elementi maggiori verso destra.

![InsertionSort.InsertionSort.gif](InsertionSort.gif)

## Complessità
1. To(n) = O(n)
2. Tm(n) = O(n)
3. Tp(n) = O(n^2)