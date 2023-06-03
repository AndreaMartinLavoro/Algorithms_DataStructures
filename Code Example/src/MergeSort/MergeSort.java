package MergeSort;

import SelectionSort.SelectionSort;

import static Utils.Utils.print;
import static Utils.Utils.randomArray;

public class MergeSort {
    /**
     * Questo metodo unisce due array ordinati (mantendendo lo stato di ordinamento anche nel vettore di output)
     *
     * @param A array di interi
     * @param l indice di inizio del primo sottoarray
     * @param m indice di fine del primo sottoarray
     * @param r indice di fine del secondo sottoarray
     */
    public void Merge(int A[], int l, int m, int r)
    {
        // Trova le dimensioni dei due sottoarray da unire
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Crea gli array temporanei */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /* Copia i dati negli array temporanei */
        for (int i=0; i<n1; ++i)
            L[i] = A[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = A[m + 1+ j];


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
                A[k] = L[i];
                i++;
            }
            else
            {
                // Se il valore nell'array R è minore del valore nell'array L
                // lo inserisce nell'array principale arr e incrementa l'indice di R
                A[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copia gli elementi rimanenti dell'array L se presenti */
        while (i < n1)
        {
            A[k] = L[i];
            i++;
            k++;
        }

        /* Copia gli elementi rimanenti dell'array R se presenti */
        while (j < n2)
        {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Questo metodo effettua un ordinemento del vettore di interi dato in input
     *
     * @param A il vettore di interi su cui effettuare l'ordinamento
     * @param p rappresenta l'indice di inizio
     * @param q rappresenta l'indice di fine
     */
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
        int A[];

        for(int i=1; i<=4; i++) {
            A = randomArray(10, 1, 100);
            System.out.print("MergeSort Test " + i);
            print(A);
            MergeSort ob = new MergeSort();
            ob.MergeSort(A, 0, A.length-1);
            print(A);
            System.out.println();
        }
    }
}
