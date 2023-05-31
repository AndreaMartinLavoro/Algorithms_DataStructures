package com.company.output;

import com.company.select.MinHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Select {
    //QUICK SELECT
    private static int partition(ArrayList<Integer> input, int first, int last) {
        //viene considerato come pivot l'ultimo elemento dell'array.
        //Gli elementi con un valore minore si aggiungono a sinistra, viceversa quelli con un valore maggiore vengono aggiunti a destra
        int pivot = input.get(last);

        for (int i = first; i <= last; i++)
            if (input.get(i) < pivot) {
                Collections.swap(input, i, first);
                first += 1;
            }

        Collections.swap(input, first, last);

        return first;
    }

    public static int quickSelect(ArrayList<Integer> input, int first, int last, int k) {
        //trova partition
        int partition = partition(input, first, last);
        //System.out.println(input);
        //System.out.println(partition);

        //se il valore di partition è uguale alla k-esima posizione, ritorna il valore di k
        if(partition == k - 1)
            return input.get(partition);
            //se il valore di partition è minore della k-esima posizione, cerca nella parte destra del vettore
        else if(partition < k - 1)
            return quickSelect(input, partition + 1, last, k);
            //se il valore di partition è maggiore della k-esima posizione, cerca nella parte sinistra del vettore
        else
            return quickSelect(input, first, partition - 1, k);
    }

    //----------------------------------------------------------------------------------------------------------------//

    //MEDIAN OF MEDIAN
    public static int medianOfMedian(int arr[], int low, int high, int k) {
        int medOfMed;

        if (k > 0 && k <= high - low + 1) {
            int n = high - low + 1;

            int i, median[] = new int[(n + 4) / 5];

            for (i = 0; i < median.length - 1; i++)
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);

            if (n % 5 == 0) {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
                i++;
            } else {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + (n % 5)), n % 5);
                i++;
            }

            if(i == 1)
                medOfMed = median[i-1];
            else
                medOfMed = medianOfMedian(median, 0, i - 1, i / 2);

            int pos = partitionPractise(arr, low, high, medOfMed);

            if (pos - low == k - 1)
                return arr[pos];
            if (pos - low > k - 1)
                return medianOfMedian(arr, low, pos - 1, k);
            return medianOfMedian(arr, pos + 1, high, k - (pos + 1) + low);
        }
        return -1;
    }

    // MEDIAN OF MEDIAN INPLACE

    public static int meidanOfMedianInplace(int arr[], int low, int high, int k) {
        int medOfMed;

        if (k > 0 && k <= high - low + 1) {
            int n = high - low + 1;
            int medIndex;

            for (medIndex = 0; medIndex < ((n + 4) / 5) - 1; medIndex++)
                swap(arr, medIndex, getMedianIndex(Arrays.copyOfRange(arr, 5 * medIndex + low, 5 * medIndex + low + 4), 5, medIndex));

            if(n % 5 == 0) {
                swap(arr, medIndex, getMedianIndex(Arrays.copyOfRange(arr, 5 * medIndex + low, 5 * medIndex + low + 4), 5, medIndex));
                medIndex++;
            }else{
                swap(arr, medIndex, getMedianIndex(Arrays.copyOfRange(arr, 5 * medIndex + low, 5 * medIndex + low + (n % 5)), n % 5, medIndex));
                medIndex++;
            }

            if(medIndex == 1)
                medOfMed = arr[medIndex - 1];
            else
                medOfMed = medianOfMedian(arr, 0, medIndex - 1, medIndex / 2);

            int pos = partitionPractise(arr, low, high, medOfMed);

            if (pos - low == k - 1)
                return arr[pos];
            if (pos - low > k - 1)
                return medianOfMedian(arr, low, pos - 1, k);
            return medianOfMedian(arr, pos + 1, high, k - (pos + 1) + low);
        }
        return -1;
    }

    private static int getMedian(int arr[], int n) {
        Arrays.sort(arr);

        return arr[n / 2];
    }

    private static int getMedianIndex(int arr[], int n, int medIndex) {
        Arrays.sort(arr);

        return (n/2) + (medIndex*5);
    }

    private static void swap(int[] arr, int i, int index) {
        if (arr[i] == arr[index])
            return;
        int temp = arr[i];

        arr[i] = arr[index];
        arr[index] = temp;
    }

    private static int partitionPractise(int[] arr, int low, int high, int pivot) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                swap(arr, i, high);
                break;
            }
        }

        int index = low - 1;
        int i = low;

        while (i < high) {
            if (arr[i] < pivot) {
                index++;
                swap(arr, i, index);
            }
            i++;
        }

        index++;
        swap(arr, index, high);

        return index;
    }

    //----------------------------------------------------------------------------------------------------------------//

    //HEAP SELECT
    public static int heapSelect(ArrayList<Integer> vett, int pos){
        MinHeap heap1 = new MinHeap(vett);
        MinHeap heap2 = new MinHeap();
        int minIndex = -1;

        heap2.insert(heap1.getRoot());

        for(int i = 0; i < pos - 1; i++){
            int min = heap2.getRoot();
            heap2.deleteMin();
            minIndex = heap1.getMinIndex(min, minIndex);
            int sx = heap1.leftChild(minIndex);
            int dx = heap1.rightChild(minIndex);

            if(sx < heap1.getHeapsize())
                heap2.insert(heap1.ithElem(sx));

            if(dx < heap1.getHeapsize())
                heap2.insert(heap1.ithElem(dx));

            //System.out.print("All'iterazaione " + i + " la heap vale: ");
            //heap2.printVett();
        }

        return heap2.getRoot();
    }
}