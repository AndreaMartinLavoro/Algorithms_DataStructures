package MergeSort;

public class MergeSort {
    private void Merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void MergeSort(int A[], int p, int q)
    {
        if (p < q)
        {
            // Find the middle point
            int r = (p+q)/2;

            // Sort first and second halves
            MergeSort(A, p, r);
            MergeSort(A , r+1, q);

            // Merge the sorted halves
            Merge(A, p, r, q);
        }
    }

    public static void main(String args[])
    {
        int A[] = {12, 11, 13, 5, 6, 7};

        MergeSort ob = new MergeSort();
        ob.MergeSort(A, 0, A.length-1);
    }
}
