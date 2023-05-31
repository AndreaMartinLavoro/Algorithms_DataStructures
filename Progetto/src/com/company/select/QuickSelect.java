package com.company.select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class QuickSelect {
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

    public static void main(String[] args) {
        //INPUT
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr= new ArrayList<>();
        Random rnd = new Random();

        //System.out.println("Inserisci vettore: \n");
        //ArrayList<String> elems = scanArray(in);

        //for (String elem : elems)
          //  arr.add(Integer.valueOf(elem));
        /*int k = rnd.nextInt(100000);

        for(int j = 0; j < 100000; j++)
            arr.add(j, rnd.nextInt(100000 * 2) - 100000);*/


        //ArrayList<String> pos = scanArray(in);
        //int kPosition = Integer.parseInt(pos.get(0));
        int k, length;
        int dim = 10000;

        for(int i = 0; i < 50; i++) {
            k = rnd.nextInt(dim * (i + 1));

            for (int j = 0; j < dim * (i + 1); j++)
                arr.add(rnd.nextInt(dim * (i + 1) * 2) - dim * (i + 1));

            length = arr.size();

            System.out.println((i + 1) + "(" + dim * (i + 1) + ")" + " -> " + quickSelect(arr, 0, length - 1, k));
            arr.clear();
        }
    }
}
