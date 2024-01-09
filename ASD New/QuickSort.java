public class QuickSort {
    /***
     * Trova l'indice di partizione e successivamente ordina ricorsivamente gli elementi prima e dopo la partizione.
     * @param A vettore da ordinare
     * @param l posizione del primo elemento del vettore da ordinare
     * @param h posizione dell'ultimo elemento del vettore da ordinare
     */
    public void Sort(int[] A, int l, int h){
        if(l < h){
            int partitionIndex = Partition(A, l, h);

            // Ordina ricorsivamente gli elementi prima e dopo la partizione
            Sort(A, l, partitionIndex - 1);
            Sort(A, partitionIndex + 1, h);
        }
    }

    // Suddivide l'array in due parti, in modo che gli elementi minori o uguali
    // a un "pivot" siano a sinistra del pivot, e gli elementi maggiori siano a destra.
    private int Partition(int[] A, int l, int h) {
        int pivot = A[h]; // Seleziono il pivot (prendo l'elemento + a destra - casualità)
        int i = l - 1;

        for (int j = l; j < h; j++){ // Viene eseguito un loop da l a (h -1)
            if(A[j] <= pivot) { // Sposta gli elementi minori a sinistra del pivot
                i++;
                Swap(A, i, j);
            }
        }
        Swap(A, i + 1, h); // Posiziona il pivot nella sua posizione finale

        return i + 1; // Indice del pivot dopo la suddivisione
    }

    // Scambuia di posizione due elementi nel vettore
    private void Swap(int A[], int p, int q){
        int temp = A[p];
        A[p] = A[q];
        A[q] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
        quickSort.Sort(A, 0, A.length-1);

        Print.print(A);
    }
}