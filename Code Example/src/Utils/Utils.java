package Utils;

import java.util.Random;

public class Utils {
    /**
     * Questo metodo effettua la stampa dell'intero vettore di interi che gli viene passato.
     *
     * @param A il vettore da stampare
     */
    public static void print(int A[]){
        System.out.println("");
        for (int item : A){
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    /**
     * Questo metodo genera un veddore di interi random
     *
     * @param size dimensione dell'array
     * @param min valore minimo degli elementi
     * @param max valore massimo degli elementi
     *
     * @return un'array di interi di size elementi generati randomicamente in un intervallo (min, max)
     */
    public static int[] randomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }
}
