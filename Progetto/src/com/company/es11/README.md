# PERIODO FRAZIONARIO

------

Scrivere un programma che riceva su una riga di input una stringa 𝑠 di lunghezza 𝑛 e restituisca in output il suo periodo 
frazionario 𝑝<sub>𝑠</sub>, ovvero il più piccolo numero 𝑝 positivo (0 < 𝑝 ≤ 𝑛) tale che 𝑠[𝑖] = 𝑠[𝑖mod𝑝] per ogni 0 ≤ 𝑖 < 𝑛.

Esempi: <br>
input = abcabcab <br>
output = 3

input = aba <br>
output = 2

input = abca <br>
output = 3

Provare a implementare 2 versioni dell'algoritmo che abbiano i seguenti tempi asintotici di esecuzione:
- Θ(𝑛2),
- Θ(𝑛).

**Suggerimento per l'algoritmo in tempo lineare.** <br>
Si consideri la seguente definizione: un bordo si una stringa 𝑠 è una qualunque stringa 𝑡 che sia, allo stesso tempo, 
prefisso proprio di 𝑠 e suffisso proprio di 𝑠. Ad esempio, 𝑡=𝑎𝑏𝑎𝑏 è un bordo di 𝑠 = 𝑎𝑏𝑎𝑏𝑎𝑎𝑏𝑎𝑏𝑎𝑏𝑎𝑏, ed è anche il bordo di 𝑠 di 
lunghezza massima.
Si osservi quindi che 𝑝 è il periodo frazionario di 𝑠 se e solo se 𝑝 = 𝑛 − 𝑟, dove 𝑛 è la lunghezza della stringa 𝑠 ed 𝑟 è la 
lunghezza massima di un bordo di 𝑠. Ciò permette di ridurre il problema del calcolo del periodo frazionario di 𝑠 al problema
del calcolo della lunghezza massima di un bordo di 𝑠.

Per risolvere quest'ultimo problema si proceda per induzione, calcolando per ogni prefisso 𝑠[0...𝑖−1], dal più corto (𝑖 = 1) 
al più lungo (𝑖 = 𝑛), la lunghezza massima 𝑟(𝑖) di un bordo di 𝑠[1...𝑖−1]. Si noti che 𝑟(1) = 0 e 𝑟(0) non è definito. 
Il calcolo di 𝑟(𝑖) per 𝑖 ≥ 2 avviene utilizzando un'induzione completa, nel modo seguente. Si consideri la sequenza 
𝑟(𝑖−1) > 𝑟(𝑟(𝑖−1))>𝑟(𝑟(𝑟(𝑖−1))) > ... > 𝑟𝑘(𝑖−1) = 0 e si osservi che nel calcolo di 𝑟(𝑖) solamente i due casi seguenti possono darsi:

- per qualche indice 𝑗 (1 ≤ 𝑗 ≤ 𝑘) vale l'uguaglianza 𝑠[𝑖−1] = 𝑠[𝑟𝑗(𝑖−1)]; in tal caso, prendendo il primo indice 𝑗 per cui vale 
la suddetta uguaglianza, avremmo che 𝑟(𝑖) = 𝑟𝑗(𝑖−1)+1;
- non esiste alcun indice 𝑗 (1 ≤ 𝑗 ≤ 𝑘) che soddisfi l'uguaglianza 𝑠[𝑖−1] = 𝑠[𝑟𝑗(𝑖−1)]; in tal caso avremmo 𝑟(𝑖) = 0.

Per calcolare la lunghezza massima di un bordo di 𝑠 si consiglia quindi di usare una procedura iterativa con un array di 
supporto che raccolga i valori 𝑟(𝑖) calcolati progressivamente e in modo induttivo, per ogni 𝑖 = 1...𝑛.
Una volta implementato l'algoritmo, si proceda ad analizzarne la complessità, dimostrando la terminazione in tempo lineare.



