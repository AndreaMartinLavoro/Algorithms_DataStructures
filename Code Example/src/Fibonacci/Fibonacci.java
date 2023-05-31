package Fibonacci;

public class Fibonacci {
    /**
     * Questo metodo calcola iterativamente l'n-esimo numero di Fibonacci.
     *
     * @param n l'n-esimo numero intero di Fibonacci di cui voglio conoscere il valore
     * @return il valore dell'n-esimo numero di Fibonacci
     */
    public int Fibonacci_it(int n) {
        if(n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        return fib;
    }

    /**
     * Questo metodo calcola ricorsivamente l'n-esimo numero di Fibonacci.
     *
     * @param n l'n-esimo numero intero di Fibonacci di cui voglio conoscere il valore
     * @return il valore dell'n-esimo numero di Fibonacci
     */
    public int Fibonacci_ric(int n) {
        if(n <= 1) {
            return n;
        }
        return Fibonacci_ric(n-1) + Fibonacci_ric(n-2);
    }

    public static void main(String args[]) {
        Fibonacci fib = new Fibonacci();

        System.out.println("Iterative version:");
        System.out.println(fib.Fibonacci_it(5));
        System.out.println(fib.Fibonacci_it(10));
        System.out.println(fib.Fibonacci_it(20));
        System.out.println(fib.Fibonacci_it(30));

        System.out.println("Recursive version:");
        System.out.println(fib.Fibonacci_ric(5));
        System.out.println(fib.Fibonacci_ric(10));
        System.out.println(fib.Fibonacci_ric(20));
        System.out.println(fib.Fibonacci_ric(30));
    }
}
