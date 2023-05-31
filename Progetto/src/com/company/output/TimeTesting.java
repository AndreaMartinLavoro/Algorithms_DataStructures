package com.company.output;

/*
*
*   Classe deputata al controllo e all'analisi delle classi PeriodNaive e PeriodSmart
*
*   IDEA
*   - Chiamo un metodo Generator per n volte che genera n INPUT
*   - Eseguo PeriodNaive e PeriodSmart n volte monitorando con Timer gli andamenti dei tempi di esecuzione
*   - Confronto le relazioni tra Lunghezza dell'INPUT e Tempo di esecuzione (Creazione Dataset)
*   - Mostro i risultati tramite un Grafico e una Label di Conferma (è o non è lineare ?)
*
 */

import com.company.tools.CSV;
import com.company.tools.Timer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiConsumer;

public class TimeTesting{
    private final int A = 100;
    private final double B = Math.exp((Math.log(5000000) - Math.log(this.A)) / (this.I_MAX - 1));
    private final double I_MAX = 100;
    private static final int TIMES = 40; //numero di volte che sarà effettuata la misurazione di tempo(tra le 30 e le 50)
    //private BarGraph g;
    private static ArrayList<Integer> dims;//vettore contenete le dimensioni della stringa
    private static Timer timer;

    public TimeTesting() {
        this.dims = new ArrayList<>();
        this.timer = new Timer(this.TIMES);

        exponentialDistribution();
        //System.out.println(dims);
    }

    private void exponentialDistribution(){
        int value;

        for(int i = 0; i < this.I_MAX; i++) {
            value = (int) (this.A * (Math.pow(this.B, i)));
            this.dims.add(i, (int) Math.floor(value));
        }
    }

    /**
     *
     * @param select funzione che indica l'istruzione di cui si vuole stimare il tempo
     * @param writer oggetti che scrive all'interno di un file CSV
     */
    public static void estimateTime(BiConsumer<ArrayList<Integer>, Integer> select, CSV writer) {
        int i; // contiene il numero di cicli prima di raggiungere il tempo minimo rilevabile
        double detectedTime;
        int k;
        Random rnd = new Random();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();

        for (int dim : dims) {
            for(int time = 0; time < TIMES; time++){
                k = rnd.nextInt(dim) + 1;
                pos.add(time, k);

                for(int j = 0; j < dim; j++)
                    input.add(rnd.nextInt(dim * 2) - dim);

                i = 0;

                timer.start();
                while (!timer.isMoreThanMin(timer.getTime())) {
                    select.accept(input, k);
                    //System.out.println(" -> " + timer.getTime() + "\n");
                    timer.stop();
                    i++;
                    //System.out.println("" + i + "-->" + timer.getTime());
                }
                input.clear();
                detectedTime = timer.getTime() / i;

                timer.saveTime(detectedTime);
                timer.reset();
            }

            try {
                writer.csvWriter(timer.getTimes(), dim, pos);
            } catch (IOException ioe) {
                System.out.println("operazione di scrittura non è andata a buon fine");
            }

            timer.resetTimes(); //necessario perchè altrimenti mi scriveva almeno l'ultima misurazione due volte
        }
        writer.csvClose();
    }

    public static void estimateTimeBis(BiConsumer<int[], Integer> select, CSV writer) {
        int i; // contiene il numero di cicli prima di raggiungere il tempo minimo rilevabile
        double detectedTime;
        int k;
        Random rnd = new Random();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int dim : dims) {
            int[] input = new int[dim];

            for(int time = 0; time < TIMES; time++){
                k = rnd.nextInt(dim) + 1;

                pos.add(time, k);
                for(int j = 0; j < dim; j++)
                    input[j] = rnd.nextInt(dim * 2) - dim;

                i = 0;

                timer.start();

                while (!timer.isMoreThanMin(timer.getTime())) {
                    select.accept(input, k);
                    //System.out.println(" -> " + timer.getTime() + "\n");
                    timer.stop();
                    i++;
                    //System.out.println("" + i + "-->" + timer.getTime());
                }
                detectedTime = timer.getTime() / i;

                timer.saveTime(detectedTime);
                timer.reset();
            }

            try {
                writer.csvWriter(timer.getTimes(), dim, pos);
            } catch (IOException ioe) {
                System.out.println("operazione di scrittura non è andata a buon fine");
            }

            timer.resetTimes(); //necessario perchè altrimenti mi scriveva almeno l'ultima misurazione due volte
        }
        writer.csvClose();
    }

    public static void main(String[] args) {
        TimeTesting f = new TimeTesting();
        BiConsumer<ArrayList<Integer>, Integer> quick = (input, pos) -> Select.quickSelect(input, 0, input.size() - 1, pos);
        BiConsumer<int[], Integer> median = (input, pos) -> Select.medianOfMedian(input, 0, input.length - 1, pos);
        BiConsumer<int[], Integer> medianInplace = (input, pos) -> Select.meidanOfMedianInplace(input, 0, input.length - 1, pos);
        BiConsumer<ArrayList<Integer>, Integer> heap = (input, pos) -> Select.heapSelect(input, pos);

        //TimeTesting.estimateTime(quick, new CSV("quick"));
        //TimeTesting.estimateTimeBis(median, new CSV("median"));
        TimeTesting.estimateTimeBis(medianInplace, new CSV("medianInplace"));
        //TimeTesting.estimateTime(heap, new CSV("heap"));
        System.out.println("CONCLUSO!!!!!!");
    }
}
