package com.company.notused;

import java.util.Random;

public class Generator {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int dimSequenza;
    private Random sr;
    private StringBuilder str;

    public StringBuilder getStr(){
        return this.str;
    }

    public Generator(int n){
        this.dimSequenza = n;
        this.sr = new Random();
        this.str = new StringBuilder(n);
    }

    public String stringGenerator(){
        int randomInt;
        char randomChar;

        for (int i = 0; i < this.dimSequenza; i++) {
            randomInt = this.sr.nextInt(this.ALPHABET.length());
            randomChar = this.ALPHABET.charAt(randomInt);
            this.str.append(randomChar);
        }

        return this.str.toString();
    }

    public static void main(String[] args) {
        Generator gen = new Generator(10);

        System.out.println(gen.stringGenerator());
    }
}
