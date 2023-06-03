package Select;

import QuickSort.QuickSort;

import java.util.Random;

import static Utils.Utils.print;
import static Utils.Utils.randomArray;

public class Select {

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
     * Algoritmo di selezione che trovare l'i-esimo elemento più piccolo in un array
     *
     * @param A array di interi
     * @param p indice iniziale nell'array
     * @param q indice finale nell'array
     * @param i indice dell'elemento desiderato (all'interno dell'intervallo dell'array)
     *
     * @return l'i-esimo elemento più piccolo nel sottoarray di interesse
     */
    public int Select_naive(int A[], int p, int q, int i){
        if(p==q){
            return A[p];
        } else {
            int r = Partition(A, p, q);
            if(i == r){
                return A[r];
            }

            if(i<r){
                return Select_naive(A, p, r-1, i);
            } else {
                return Select_naive(A, r+1, q, i);
            }
        }
    }
    public static void main(String[] args)
    {
        int A[];

        for(int i=1; i<=4; i++) {
            A = randomArray(10, 1, 100);

            Random random = new Random();
            int indice = random.nextInt((A.length-1) - 0 + 1) + 0;

            System.out.print("Select Test " + i);
            print(A);
            Select ob = new Select();
            int res = ob.Select_naive(A, 0, A.length-1, indice);
            System.out.println("Inidice " + indice + " - Result " + res);
            System.out.println();
        }
    }
}
