package SelectionSort;

public class SelectionSort {
    public void SelectionSort(int A[], int p)
    {
        if(p<A.length)
        {
            int i = MinSearch(A, p, A.length);
            Swap(A, i, p);
            SelectionSort(A, p+1);
        }
    }

    private int MinSearch(int A[], int k, int h)
    {
        int min = A[k];
        int min_pos = k;

        for(int i = k+1; i<h; i++)
        {
            if(A[i]<min)
            {
                min = A[i];
                min_pos = i;
            }
        }
        return min_pos;
    }

    private void Swap(int A[], int k, int h)
    {
        int aux = A[k];
        A[k] = A[h];
        A[h] = aux;
    }

    public static void main(String args[])
    {
        int A[] = {64,25,12,22,11};

        SelectionSort ob = new SelectionSort();
        ob.SelectionSort(A, 0);
    }
}
