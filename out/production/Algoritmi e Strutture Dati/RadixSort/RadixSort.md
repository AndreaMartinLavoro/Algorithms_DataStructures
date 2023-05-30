# Radix Sort
### Devo ordinare un vettore di lunghezza n contente interi aventi d digit (cifre)
```
109 | 095 | 085 | 082 | 003     con d=3 ed n=5
```

## Idea
- Utilizzo CountingSort sulla singola digit
- Partendo dalla meno Significativa (funziona perchè CountingSort è Stabile)
  - Ordine per l'ultima cifra a DX
    - ```082 | 003 | 095 | 085 | 109```
  - Ordino per la cifra al Centro
    - ```003 | 109 | 082 | 085 | 095```
  - Ordino per la prima cifra a SX
    - ```003 | 082 | 085 | 095 | 109```

### Radix Sort è Corretto solamente perchè Counting Sort è **Stabile**!

