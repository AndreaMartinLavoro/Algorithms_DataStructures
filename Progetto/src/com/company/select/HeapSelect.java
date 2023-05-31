// TODO: versione che adotta MaxHeap o MinHeap in base al valore kS
package com.company.select;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HeapSelect {
    public static ArrayList<String> scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();

        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");

        ArrayList<String> arr = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) // some tokens may be empty (e.g. with trailing spaces)
                arr.add(token);
        }

        return arr;
    }

    public static int heapSelect(ArrayList<Integer> vett, int pos) {
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

        int kthSmallest = heap2.getRoot();

        heap1.eraseHeap();
        heap2.eraseHeap();

        return kthSmallest;
    }

    public static void main(String[] args) {
        //INPUT
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr= new ArrayList<>();
        Random rnd = new Random();
        int k;
        int dim = 10000;

        for(int i = 0; i < 50; i++) {
            k = rnd.nextInt(dim * (i + 1));

            for (int j = 0; j < dim * (i + 1); j++)
                arr.add(rnd.nextInt(dim * (i + 1) * 2) - dim * (i + 1));

            System.out.println((i + 1) + "(" + dim * (i + 1) + ")" + " -> " + heapSelect(arr,k));
            arr.clear();
        }

        /*Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr= new ArrayList<>();

        System.out.println("Inserisci vettore: \n");
        ArrayList<String> elems = scanArray(in);

        for (String elem : elems)
            arr.add(Integer.valueOf(elem));


        ArrayList<String> pos = scanArray(in);
        int kPosition = Integer.parseInt(pos.get(0));*/

        //System.out.println("L'elemento in posizione " + k + ": " + heapSelect(arr,k));
    }
}
