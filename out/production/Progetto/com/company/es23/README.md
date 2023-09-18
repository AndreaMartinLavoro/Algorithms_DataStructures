# DISTANZA DI EDITING

----
Si richiede di implementare un algoritmo polinomiale per calcolare la distanza di editing (nota anche come distanza di Levenshtein) 
fra due stringhe fornite in input.

Date due stringhe 𝑥 e 𝑦, la distanza di editing fra 𝑥 e 𝑦 è definita come il numero minimo di modifiche elementari (inserimento,
cancellazione, o sostituzione di un carattere) che consentono di trasformare 𝑥 in 𝑦. <br>
Ad esempio, la distanza di editing fra "bar" e "biro" è 2: per trasformare "bar" in "biro" è sufficiente sostituire 
l'occorrenza del carattere "a" con il carattere "i" e inserire il carattere "o" alla fine.

L'algoritmo che calcola la distanza di editing fra due stringhe 𝑥 e 𝑦 date dovrà prendere tempo al più **quadratico** nelle 
lunghezze di 𝑥 e 𝑦, precisamente tempo O(|𝑥|⋅|𝑦|). Il programma che implementa tale algoritmo dovrà ricevere le stringhe 𝑥 e 𝑦 
su due righe di input (è anche possibile assumere che le stringhe non contengano spazi) e dovrà stampare in output il 
valore della distanza di editing.

Esempio:

input: bar
biro <br>
output: 2


