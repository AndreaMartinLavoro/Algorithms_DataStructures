package Utils;

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
}
