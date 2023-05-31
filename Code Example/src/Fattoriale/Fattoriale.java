package Fattoriale;

public class Fattoriale {
    /**
     * Questo metodo calcola iterativamente il fattoriale del numero passato.
     *
     * @param n il numero intero di cui calcolare il fattoriale
     * @return il fattoriale del numero fornito
     */
    public int Fattoriale_it(int n){
        int fattoriale = 1;
        for(int i = 1; i <= n; i++){
            fattoriale = fattoriale * i;
        }
        return fattoriale;
    }

    /**
     * Questo metodo calcola ricorsivamente il fattoriale del numero passato.
     *
     * @param n il numero intero di cui calcolare il fattoriale
     * @return il fattoriale del numero fornito
     */
    public int Fattoriale_ric(int n){
        if(n==0){
            return 1;
        } else {
            int res = n * Fattoriale_ric(n-1);
            return res;
        }
    }

    public static void main(String args[]){
        Fattoriale ob = new Fattoriale();
        int val = 10;

        int fattoriale_it = ob.Fattoriale_it(val);
        System.out.println(fattoriale_it);

        int fattoriale_ric = ob.Fattoriale_ric(val);
        System.out.println(fattoriale_ric);
    }
}


