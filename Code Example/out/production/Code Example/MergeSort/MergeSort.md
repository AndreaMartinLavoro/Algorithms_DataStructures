# Merge Sort
Il merge sort è un algoritmo di ordinamento basato su confronti che utilizza un processo di risoluzione ricorsivo, sfruttando la tecnica del Divide et Impera, che consiste nella suddivisione del problema in sottoproblemi della stessa natura di dimensione via via più piccola.

## Idea
Concettualmente, l'algoritmo funziona nel seguente modo:
1. Se la sequenza da ordinare ha lunghezza 0 oppure 1, è già ordinata. Altrimenti:
2. La sequenza viene divisa (divide) in due metà (se la sequenza contiene un numero dispari di elementi, viene divisa in due sottosequenze di cui la prima ha un elemento in più della seconda)
3. Ognuna di queste sottosequenze viene ordinata, applicando ricorsivamente l'algoritmo (impera)
4. Le due sottosequenze ordinate vengono fuse (combina). Per fare questo, si estrae ripetutamente il minimo delle due sottosequenze e lo si pone nella sequenza in uscita, che risulterà ordinata

![MergeSort.MergeSort.gif](MergeSort.gif)

La complessità complessiva della fase di fusione nel Merge Sort è O(n).

Va notato che il Merge Sort complessivamente ha una complessità temporale di O(n log n), dato che la fase di fusione viene eseguita ricorsivamente su sottoarray sempre più piccoli. Il codice che hai mostrato rappresenta solo la fase di fusione, che contribuisce con O(n) alla complessità complessiva dell'algoritmo.