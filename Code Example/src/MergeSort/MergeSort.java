package MergeSort;

import static Utils.Utils.print;

public class MergeSort {
    public void Merge(int arr[], int l, int m, int r)
    {
        // Trova le dimensioni dei due sottoarray da unire
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Crea gli array temporanei */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /* Copia i dati negli array temporanei */
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Unisce gli array temporanei */

        // Indici iniziali dei primi e secondi sottoarray
        int i = 0, j = 0;

        // Indice iniziale dell'array unito
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                // Se il valore nell'array L è minore o uguale al valore nell'array R
                // lo inserisce nell'array principale arr e incrementa l'indice di L
                arr[k] = L[i];
                i++;
            }
            else
            {
                // Se il valore nell'array R è minore del valore nell'array L
                // lo inserisce nell'array principale arr e incrementa l'indice di R
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copia gli elementi rimanenti dell'array L se presenti */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copia gli elementi rimanenti dell'array R se presenti */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void MergeSort(int A[], int p, int q)
    {
        if (p < q)
        {
            // Verifica se l'indice di inizio (p) è minore dell'indice di fine (q)
            // Questo implica che ci sono almeno due elementi da ordinare

            // Trova il punto medio dell'array
            int r = (p+q)/2;

            // Ordina la prima e la seconda metà dell'array ricorsivamente
            MergeSort(A, p, r);
            MergeSort(A , r+1, q);

            // Fonde (unisce) le due metà dell'array ordinate
            Merge(A, p, r, q);
        }
    }

    public static void main(String args[])
    {
        int A[] = {12, 11, 13, 5, 6, 7};

        print(A);
        MergeSort ob = new MergeSort();
        ob.MergeSort(A, 0, A.length-1);
        print(A);
    }
}
