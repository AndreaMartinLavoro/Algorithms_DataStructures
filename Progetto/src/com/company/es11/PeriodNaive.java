package com.company.es11;

import java.util.ArrayList;
import java.util.Scanner;

public class PeriodNaive {
    public static ArrayList<String> scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();

        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");

        ArrayList<String> arr = new ArrayList<String>();
        for (String token : tokens) {
            if (!token.isEmpty()) // some tokens may be empty (e.g. with trailing spaces)
                arr.add(token);
        }

        return arr;
    }

    public static int periodNaive(String stringa) {
        int n = stringa.length();
        int p = 1;

        if(n != 1) {
            String prefix = stringa.substring(0, n - p);
            String suffix = stringa.substring(p, n);

            while (!prefix.equals(suffix) && p < n) {
                p++;
                suffix = stringa.substring(p, n);
                prefix = stringa.substring(0, n - p);
            }
        }

        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci le stringhe in cui si vuole calcolare il periodo\n");
        ArrayList<String> stringhe = scanArray(in);

        for (String str:stringhe)
            System.out.println(str + " --> " + periodNaive(str));
    }
}