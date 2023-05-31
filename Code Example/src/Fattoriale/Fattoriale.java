package Fattoriale;

public class Fattoriale {
    public int Fattoriale_int(int n){
        int fattoriale = 1;
        for(int i = 1; i <= n; i++){
            fattoriale = fattoriale * i;
        }
        return fattoriale;
    }

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

        int fattoriale_int = ob.Fattoriale_int(val);
        System.out.println(fattoriale_int);

        int fattoriale_ric = ob.Fattoriale_ric(val);
        System.out.println(fattoriale_ric);
    }
}


