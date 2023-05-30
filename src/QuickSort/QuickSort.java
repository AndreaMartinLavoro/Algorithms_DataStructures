package QuickSort;

public class QuickSort {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int Partition(int A[], int p, int q)
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

    public void QuickSort(int A[], int p, int q)
    {
        if (p < q)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int r = Partition(A, p, q);

            // Recursively sort elements before
            // partition and after partition
            QuickSort(A, p, r-1);
            QuickSort(A, r+1, q);
        }
    }

    public static void main(String args[])
    {
        int A[] = {10, 7, 8, 9, 1, 5};

        QuickSort ob = new QuickSort();
        ob.QuickSort(A, 0, A.length-1);

        System.out.println("Ciao");
    }
}
