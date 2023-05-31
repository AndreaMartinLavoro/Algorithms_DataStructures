package com.company.select;

import java.util.Arrays;
import java.util.Scanner;

class MedianOfMedian {
    public static int medianOfMedianInplaceC(int arr[], int low, int high, int k) {
        int n, numero_gruppi_completi, numero_elemnti_non_completi, ultimiElementi,posizione_mediano_del_gruppo, lun, pivot, mom;

        while (true) {
            n = high - low + 1;
            numero_gruppi_completi = (int)Math.floor(n / 5);
            numero_elemnti_non_completi = n - (numero_gruppi_completi * 5);
            ultimiElementi = (numero_gruppi_completi * 5);

            while (true) {
                for (int gruppo_completo = 0; gruppo_completo < numero_gruppi_completi; gruppo_completo++) {
                    Arrays.sort (arr, gruppo_completo * 5, (gruppo_completo * 5) + 5);
                    posizione_mediano_del_gruppo = (gruppo_completo * 5) + 2;
                    swap (arr, gruppo_completo, posizione_mediano_del_gruppo);
                }

                //Elementi non completi
                if (numero_elemnti_non_completi != 0) {
                    Arrays.sort (arr, ultimiElementi, (numero_gruppi_completi * 5) + numero_elemnti_non_completi);
                    posizione_mediano_del_gruppo = (int)Math.floor((numero_elemnti_non_completi - 1) / 2) + (numero_gruppi_completi * 5);
                    swap (arr, numero_gruppi_completi, posizione_mediano_del_gruppo);
                }

                //Esco siccome ho finito
                if (numero_gruppi_completi == 0)
                    break;

                lun = n % 5 == 0 ? numero_gruppi_completi : numero_gruppi_completi + 1;
                numero_gruppi_completi = (int)Math.floor(lun / 5);
                numero_elemnti_non_completi = lun - (numero_gruppi_completi * 5);
                ultimiElementi = numero_gruppi_completi * 5;
            }

            mom = arr[low];

            //Chiamata a partition
            pivot = partitionPractise(arr, low, high, mom);


            if (pivot == k)
                return arr[pivot];

            if (pivot < k) {
                k = k - pivot - 1 ;
                low = pivot + 1;
            } else if (pivot > k)
                high = pivot;
        }
    }


        // ------------------------------------------------------------------------------------

    public static int medianOfMedianInplace(int arr[], int low, int high, int k) {
        int medOfMed;

        if (k > 0 && k <= high - low + 1) {
            int n = high - low + 1;
            int medIndex;

            for (medIndex = 0; medIndex < ((n + 4) / 5) - 1; medIndex++) {
                Arrays.sort(arr, (5 * medIndex + low), (5 * medIndex + low + 5));
                swap(arr, medIndex, (medIndex * 5)+1+low);
                //swap(arr, medIndex, getMedianIndex(Arrays.copyOfRange(arr, (5 * medIndex + low), (5 * medIndex + low + 4)), 5, medIndex, low));
            }

            if(n % 5 == 0) {
                Arrays.sort(arr, (5 * medIndex + low), (5 * medIndex + low + 5));
                swap(arr, medIndex, (medIndex * 5)+1+low);
                //swap(arr, medIndex, getMedianIndex(Arrays.copyOfRange(arr, (5 * medIndex + low), (5 * medIndex + low + 4)), 5, medIndex, low));
            }else{
                Arrays.sort(arr, (5 * medIndex + low), (5 * medIndex + low + (n % 5)));
                swap(arr, medIndex, (medIndex * 5)+(n % 5)/2+low);
                //swap(arr, medIndex, getMedianIndex(Arrays.copyOfRange(arr, (5 * medIndex + low), (5 * medIndex + low + (n % 5))), n % 5, medIndex, low));
            }

            medIndex++;

            if(medIndex == 1)
                medOfMed = arr[low]; //ex medIndex - 1
            else
              medOfMed = medianOfMedianInplace(arr, 0, medIndex - 1, medIndex / 2);

            int pos = partitionPractise(arr, low, high, medOfMed);

            if (pos - low == k - 1)
                return arr[pos];
            if (pos - low > k - 1)
                return medianOfMedianInplace(arr, low, pos - 1, k);
            return medianOfMedianInplace(arr, pos + 1, high, k - (pos + 1) + low);
        }
        return -1;
    }

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

    private static int getMedian(int arr[], int n) {
        Arrays.sort(arr);

        return arr[n / 2];
    }
    // x Versione Lineare
    private static int getMedianIndex(int arr[], int n, int medIndex, int low) {
        //Arrays.sort(arr);

        return (n / 2) + (5 * medIndex) + low;
    }

    private static void swap(int[] arr, int i, int index) {
        if (arr[i] == arr[index])
            return;
        int temp = arr[i];

        arr[i] = arr[index];
        arr[index] = temp;
    }

    private static int partitionPractise(int[] arr, int low, int high, int pivot) {
        for (int i = low; i < high; i++) {
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

    public static int[] scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();
        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");
        int[] arr = new int[tokens.length];
        int i = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) { // some tokens may be empty (e.g. with trailing spaces)
                arr[i] = Integer.valueOf(token);
                i++;
            }
        }

        return arr;
    }
    /*
      INPUT: 7 3 11 3 7 0 0 5
                 6
      OUTPUT: 7
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = scanArray(in);
        int k = scanArray(in)[0];

        System.out.println(medianOfMedianInplace(input, 0, input.length - 1, k));
    }
}
