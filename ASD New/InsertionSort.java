public class InsertionSort {

    /***
     * Idea: mantenere una porzione dell'array ordinata e successivamente inserire ogni elemento non ordinato nella porzione ordinata.
     * @param A vettore da ordinare
     */
    public void Sort(int[] A){
        // sposto da sinistra verso destra k (key)
        for (int i = 1; i < A.length; i++){ // INVARIANTE: da 0 a (i - 1) il sottovettore è ordinato
            int k = A[i];
            int j = i - 1;
            // sposto da destra verso sinistra j e la confronto con k
            while(j >= 0 && A[j] > k){ // INVARIANTE: da 0 a j il sottovettore è ordinato
                // se j è maggiore di k -> j si sposta di una casella verso destra
                A[j + 1] = A[j];
                j --;
            }
            // copio k nella sua nuova cella
            A[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] A = { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
        insertionSort.Sort(A);

        Print.print(A);
    }
}
