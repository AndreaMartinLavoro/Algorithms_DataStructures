package com.company.tools;

import java.util.ArrayList;

public class Timer {
    private final static double E = 0.001; //errore relativo massimo
    private static double T_MIN = getResolution() * ((1 / E) + 1); //tempo minimo rilevabile

    private double beginning;
    private double ending;
    private ArrayList<Double> times; //contiene le rilevazioni di tempo per input differenti
    //private int last;


    public ArrayList<Double> getTimes() {
        return times;
    }

    /**
     * @param n numero di rilevazioni di tempo che si vogliono fare
     */
    public Timer(int n) {
        this.beginning = 0.0;
        this.ending = 0.0;   //inizzializzazione sbagliata - > guarda video ??????        //inizializzalo allo start??????
        this.times = new ArrayList<>(n);
    }

    /**
     * @param t tempo rilevato
     * @return true, se tempo rilevato è superiore al tempo minimo rilevabile; false, altrimenti
     */
    public boolean isMoreThanMin(double t){
        return t > this.T_MIN;
    }

    public void start() {
        this.beginning = System.nanoTime();//conversione in millisecondi --> /1000000;
        this.ending = System.nanoTime();
    }

    public void stop() {
        this.ending = System.nanoTime();//conversione in millisecondi --> /1000000;
    }

    public void reset() {
        this.beginning = 0.0;
        this.ending = 0.0;
    }

    public double getTime() {
        return this.ending - this.beginning;
    }

    /**
     * calcola il tempo di risoluzone di un ciclo di clock
     */
    private static double getResolution() {
        double start = System.nanoTime();
        double end;

        do {
            end = System.nanoTime();
        } while (start == end);

        return end - start;
    }

    public void saveTime(double time){
        this.times.add(time);
    }

    public void resetTimes(){
        this.times.clear();
    }

    public static void main(String[] args){
        System.out.println(T_MIN);
    }
}
