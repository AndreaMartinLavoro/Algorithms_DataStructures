public class MergeSort{

    // Combina due array ordinati in un unico array ordinato
    private void Merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++; 
            }
            else 
            {
                A[k] = R[j];
                j++;
            }
        }
    }


    /***
     * Idea: Suddivide ricorsivamente l'array in sotto-array fino a raggiungere sotto-array di dimensione 1; la funzione Merge combina due sotto-array ordinati in un array ordinato.
     * @param A vettore da ordinare
     * @param p primo elemento del vettore da ordinare
     * @param q ultimo elemento del vettore da ordinare
     */
    public void Sort(int[] A, int p, int q){
        if(p < q){
            int r = (p + q)/2;
            Sort(A, p, r);
            Sort(A, r + 1, q);
            Merge(A, p, q, r);
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] A = { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
        mergeSort.Sort(A, 0, A.length - 1);
        
        Print.print(A);
    }
}