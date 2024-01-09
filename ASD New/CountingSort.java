public class CountingSort {

    /**
     * 
     * @param A vattore iniziale non ordinato
     * @param k valora massimo presente nel vettore A
     * @param B vettore finale ordinato
     */
    public void sort(int[] A, int k, int[] B) {

        int[] C = new int[k + 1];

        for(int i = 0; i < k; i++) { // Azzero
            C[i] = 0;
        }

        for(int i = 0; i < A.length; i++) { // Conto le occorrenze
            C[A[i]]++;
        }

        for(int i = 1; i <= k; i++) { // Accumulo le occorrenze
            C[i] = C[i] + C[i - 1];
        }

        for (int i = A.length-1; i >= 0; i-- ) { // fondamentale scorrere da destra a sinistra per mantenere stabile
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
    }

    public int findMax(int[] A) {
        int max = A[0];
        for (int item : A) {
            if(item > max) {
                max = item;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        int[] sortedArray = new int[array.length];
        
        System.out.println("Array prima del counting sort: ");
        Print.print(array);

        int max = countingSort.findMax(array);
        countingSort.sort(array, max, sortedArray);

        System.out.println("\nArray dopo il counting sort: ");
        Print.print(sortedArray);
    }
}