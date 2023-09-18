#  VERIFICA ALBERI BINARI DI RICERCA

----
Scrivere un programma che riceva in input un albero binario in cui ogni nodo è etichettato da un intero (denominato chiave) 
e decida se questo sia o meno un albero binario di ricerca, vale a dire soddisfi o meno la seguente proprietà: se 𝑥 è 
un nodo dell'albero e 𝑦 è un suo discendente nel sotto-albero di sinistra (rispettivamente, di destra), allora la chiave 
di 𝑥 deve essere strettamente maggiore (rispettivamente, minore) di quella di 𝑦. In particolare, in un albero binario di 
ricerca i nodi hanno sempre chiavi distinte.

Ogni albero binario fornito in input al programma sarà presentato in forma polacca, vale a dire attraverso una sequenza 
che comincia con la chiave associata al nodo radice e continua con la sequenza corrispondente al sotto-albero sinistro, 
seguita dalla sequenza corrispondente al sotto-albero destro. Qualora l'albero (o il sotto-albero) fosse vuoto, la sequenza 
corrispondente sarà denotata dalla stringa "NULL". Ad esempio, l'albero binario che contiene un nodo radice etichettato 
con la chiave 1 e due figli, sinistro e destro, etichettati rispettivamente con 2 e 3, sarà presentato in forma polacca 
inversa dalla sequenza 1 2 NULL NULL 3 NULL NULL. 

L'output del programma dovrà essere uno fra i seguenti valori, a seconda del tipo di albero binario ricevuto in input:
- 1 se l'input è un albero binario di ricerca
- 0 se l'input non è un albero binario di ricerca.

Esempi:

input=1 2 3 NULL NULL 4 NULL 5 NULL NULL 6 NULL NULL <br>
output=0

input=1 NULL 2 NULL 3 NULL 4 NULL NULL <br>
output=1