package com.company.es11;

import java.util.ArrayList;
import java.util.Scanner;

public class PeriodSmart {

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

    public static int trovaBordoMassimo(String s) {
        int len = s.length();

        for (int i = len - 1; i > 0; i--) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(len - i, len);

            if (prefix.equals(suffix)) {
                return i; //lunghezza bordo massimo
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci le stringhe in cui si vuole calcolare il periodo\n");
        ArrayList<String> stringhe = scanArray(in);

        for (String str:stringhe)
            System.out.println(str + " --> " + (str.length() - trovaBordoMassimo(str)));
    }
}