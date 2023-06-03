package InsertionSort;

import static Utils.Utils.print;

public class InsertionSort {
    /**
     * Questo metodo effettua l'ordinamento di un vttore di interi.
     *
     * @param A il vettore di interi da ordinare
     */
    public void InsertionSort(int A[])
    {
        for (int j = 2; j < A.length; ++j) {
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
        int A[] = { 12, 11, 13, 5, 6 };

        System.out.println("InsertionSort Test");
        print(A);
        InsertionSort ob = new InsertionSort();
        ob.InsertionSort(A);
        print(A);
    }
}
