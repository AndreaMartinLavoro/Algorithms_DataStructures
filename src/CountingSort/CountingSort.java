package CountingSort;

import InsertionSort.InsertionSort;

public class CountingSort {
    public void CountingSort(int A[], int B[], int k)
    {
        int C[] = new int[k+1];

        //Inizializzo il vettore con tutti elementi a 0
        for(int j=0; j<k; j++){
            C[j] = 0;
        }

        for(int i=0; i<A.length; i++){
            C[A[i]] = C[A[i]]+1;
        }

        for(int j=0; j<k; j++){
            C[j] = C[j] + C[j-1];
        }

        //Stabile
        for(int i=A.length; i>=0; i--){
            B[C[A[i]]] = A[i];
            C[A[i]] = C[A[i]] - 1;
        }
    }

    public static void main(String args[])
    {
        int A[] = { 12, 11, 13, 5, 6 };
        int B[] = new int[A.length];
        int k = 13;

        CountingSort ob = new CountingSort();
        ob.CountingSort(A, B, k);
    }
}
