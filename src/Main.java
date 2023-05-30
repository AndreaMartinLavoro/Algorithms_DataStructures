import Fibonacci.Fibonacci;
import InsertionSort.InsertionSort;
import MergeSort.MergeSort;
import QuickSort.QuickSort;
import SelectionSort.SelectionSort;

public class Main {
    public static void main(String[] args) {

        //Selection Sort
        int A[] = {64,25,12,22,11};
        SelectionSort ob = new SelectionSort();
        ob.SelectionSort(A, 0);
        printArray(A, "Array Ordinato con Selection Sort");


        //Insertion Sort
        int B[] = { 12, 11, 13, 5, 6 };
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.InsertionSort(B);
        printArray(B, "Array Ordinato con Insertion Sort");


        //Merge Sort
        int C[] = {12, 11, 13, 5, 6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.MergeSort(C, 0, C.length-1);
        printArray(C, "Array Ordinato con Merge Sort");


        //Fibonacci
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Iterative version:");
        System.out.println(fibonacci.fibonacciIterative(5));
        System.out.println(fibonacci.fibonacciIterative(10));
        System.out.println(fibonacci.fibonacciIterative(20));
        System.out.println(fibonacci.fibonacciIterative(30));
        System.out.println("Recursive version:");
        System.out.println(fibonacci.fibonacciRecursive(5));
        System.out.println(fibonacci.fibonacciRecursive(10));
        System.out.println(fibonacci.fibonacciRecursive(20));
        System.out.println(fibonacci.fibonacciRecursive(30));


        //Quick Sort
        int D[] = {10, 7, 8, 9, 1, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.QuickSort(D, 0, D.length-1);
        printArray(D, "Array Ordinato con Quick Sort");

    }

    public static void printArray(int A[], String description)
    {
        System.out.println(description);

        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");

        System.out.println();
    }
}