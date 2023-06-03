package SelectionSort;

import static Utils.Utils.print;

public class SelectionSort {
    /**
     * Questo metodo effettua un ordinemento del vettore di interi dato in input
     *
     * @param A il vettore di interi su cui effettuare l'ordinamento
     * @param p rappresenta l'indice di partenza da cui inizia la ricerca del valore minimo
     */
    public void SelectionSort(int A[], int p)
    {
        if(p<A.length)
        {
            int i = MinSearch(A, p, A.length);
            Swap(A, i, p);
            SelectionSort(A, p+1);
        }
    }

    /**
     * Questo metodo effettua la ricerca del valore minimo
     *
     * @param A il vettore di interi su cui cercare il valore minimo
     * @param k rappresenta l'indice di partenza da cui inizia la ricerca del valore minimo
     * @param h rappresenta l'indice finale fino al quale viene effettuata la ricerca del valore minimo
     *
     * @return l'indice intero del valore minimo nell'intervallo specificato
     */
    private int MinSearch(int A[], int k, int h)
    {
        int min = A[k];
        int min_pos = k;

        for(int i = k+1; i<h; i++)
        {
            if(A[i]<min)
            {
                min = A[i];
                min_pos = i;
            }
        }
        return min_pos;
    }

    /**
     * Questo metodo effettua lo scambio di due celle del vettore
     *
     * @param A il vettore di interi su cui scambiare le celle
     * @param k rappresenta l'indice del primo elemento da scambiare
     * @param h rappresenta l'indice del secondo elemento da scambiare
     */
    private void Swap(int A[], int k, int h)
    {
        int aux = A[k];
        A[k] = A[h];
        A[h] = aux;
    }

    public static void main(String args[])
    {
        int A[] = {64,25,12,22,11};

        System.out.println("SelectionSort Test");
        print(A);
        SelectionSort ob = new SelectionSort();
        ob.SelectionSort(A, 0);
        print(A);
    }
}
