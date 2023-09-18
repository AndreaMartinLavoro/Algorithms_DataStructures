package InsertionSort;

import SelectionSort.SelectionSort;

import static Utils.Utils.print;
import static Utils.Utils.randomArray;

public class InsertionSort {
    /**
     * Questo metodo effettua l'ordinamento di un vettore di interi.
     *
     * @param A il vettore di interi da ordinare
     */
    public void InsertionSort(int A[])
    {
        for (int j = 1; j < A.length; ++j) {
            int key = A[j];
            int i = j - 1;

            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    public static void main(String args[])
    {
        int A[];

        for(int i=1; i<=4; i++) {
            A = randomArray(10, 1, 100);
            System.out.print("InsertionSort Test " + i);
            print(A);
            InsertionSort ob = new InsertionSort();
            ob.InsertionSort(A);
            print(A);
            System.out.println();
        }
    }
}
