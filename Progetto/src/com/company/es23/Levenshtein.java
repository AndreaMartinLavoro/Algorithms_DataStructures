package com.company.es23;

import java.util.ArrayList;
import java.util.Scanner;

public class Levenshtein {
    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int levenshteinDist(String x, String y){
        int n = x.length() + 1, m = y.length() + 1;
        int cost;
        int[][] distance = new int[n][m];

        //numero di cancellazioni necessarie per ottenere stringa vuota dalla stringa sorgente
        for (int i = 0; i < n; i++)
            distance[i][0] = i;

        //numero di inserimeti necessari per raggiungere la stringa target partendo da stringa vuota
        for (int j = 0; j < m; j++)
            distance[0][j] = j;

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    cost = 0;
                else
                    cost = 1;

                distance[i][j] = minimum(distance[i - 1][j] + 1, //cancellazioni
                        distance[i - 1][j - 1] + cost, // sostituzioni
                        distance[i][j - 1] + 1); // inserimeti
            }
        }
        return distance[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine(), y = in.nextLine();

        System.out.println(levenshteinDist(x, y));

    }
}
