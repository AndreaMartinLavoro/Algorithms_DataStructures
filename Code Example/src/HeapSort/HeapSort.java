package HeapSort;

public class HeapSort {
    private MaxHeap BuildHeap(int A[]){

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

    public void HeapSort(int A[]){
        BuildHeap(A);
        for(int i = A.length - 1; i >= 2; i--){
            Swap(A, 1, i);
            A.heapsize
        }
    }
    public static void main(String[] args) {

    }
}
