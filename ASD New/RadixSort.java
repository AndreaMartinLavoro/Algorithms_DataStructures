public class RadixSort {

    public void sort(int[] A, int[] B) {
        CountingSort countingSort = new CountingSort();
        int max = countingSort.findMax(A);

        // Esegui il counting sort per ogni cifra
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort.sort(A, exp, B);
        }
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] sortedArray = new int[array.length];

        System.out.println("Array prima del radix sort: ");
        Print.print(array);

        radixSort.sort(array, sortedArray);

        System.out.println("\nArray dopo il radix sort: ");
        Print.print(sortedArray);
    }
}