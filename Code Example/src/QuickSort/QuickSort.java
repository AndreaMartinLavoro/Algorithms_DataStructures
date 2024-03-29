package QuickSort;

import InsertionSort.InsertionSort;

import static Utils.Utils.print;
import static Utils.Utils.randomArray;

public class QuickSort {
    /**
     * Questa funzione prende l'ultimo elemento come pivot,
     * posiziona l'elemento pivot nella sua posizione corretta
     * nell'array ordinato e posiziona tutti gli elementi più piccoli
     * (più piccoli del pivot) a sinistra del pivot e tutti
     * gli elementi più grandi a destra del pivot.
     *
     * @param A array di interi
     * @param p indice iniziale del sottoarray su cui effettuare il partizionamento
     * @param q indice finale del sottoarray su cui effettuare il partizionamento
     *
     * @return l'indice che rappresenta la posizione corretta del pivot nell'array
     */
    public int Partition(int A[], int p, int q)
    {
        int i = (p-1);
        int pivot = A[q];

        for (int j=p; j<q; j++)
        {
            if (A[j] <= pivot)
            {
                i++;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return i;
    }

    /**
     * Questo metodo effettua l'ordinamento di un vettore di interi.
     *
     * @param A array di interi
     * @param p indice iniziale che specificano il range dell'array su cui eseguire l'ordinamento
     * @param q indice finale che specificano il range dell'array su cui eseguire l'ordinamento
     */
    public void QuickSort(int A[], int p, int q)
    {
        if (p < q)
        {
            int r = Partition(A, p, q);
            QuickSort(A, p, r-1);
            QuickSort(A, r+1, q);
        }
    }

    public static void main(String args[])
    {
        int A[];

        for(int i=1; i<=4; i++) {
            A = randomArray(10, 1, 100);
            System.out.print("QuickSort Test " + i);
            print(A);
            QuickSort ob = new QuickSort();
            ob.QuickSort(A, 0, A.length-1);
            print(A);
            System.out.println();
        }
    }
}
