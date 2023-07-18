# Bucket Sort
## Ipotesi: 
A è un vettore con elementi [0, 1] uniformemente distribuiti nell'intervallo

## Idea
- Divido [0, 1] in n sottointervalli
- Scandisco A e colloco ogni elemento di nel suo sottointervallo
- Ordino gli elementi di ogni sottointervallo
- Concateno gli elementi di ogni sottointervallo

```
0.3 | 0.1 | 0.8 | 0.5 | 0.79        questo è A

[0, 0.2] [0.2, 0.4] [0.4, 0.6] [0.6, 0.8] [0.8 1]   Bucket(sottointervalli)
Viene realizzato tramite un vettore di puntatori a liste concatenate
Ogni lista contiene gli elementi che corrispondono al sottointervallo (Bucket)
```