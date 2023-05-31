package com.company.input;

import java.util.Random;

public class PeriodGeneratorBin {

    private int periodLength;

    public PeriodGeneratorBin(int periodLength) {
        this.periodLength = periodLength;
    }

    /**
     * @param length lunghezza del periondo che si vuole generare
     * @return ritorna il periodo di lunghezza length
     */
    private String generateChunck(int length){
        Random rand = new Random();
        StringBuffer tempStr = new StringBuffer();

        tempStr.append("");

        for (int i = 0; i < length; i++) {
            int c = rand.nextInt(99 - 97) + 97;// alfabeto: ab
            tempStr.append((char)c);
        }

        return tempStr.toString();
    }

    /**
     *
     * @param length lunghezza totale della stringa
     * @return stringa periodica
     */
    public String createFromPeriod(int length){
        StringBuffer str = new StringBuffer();
        String period = generateChunck(this.periodLength);

        for(int i = 0; i < (length / this.periodLength); i++)
            str.append(period);

        if(str.length() < length)
            for(int i = 0; i < (length % this.periodLength); i++)
                str.append(period.charAt(i));

        return str.toString();
    }

    public static void main(String[] args) {
        PeriodGeneratorBin generator = new PeriodGeneratorBin(3);
        System.out.println(generator.createFromPeriod(10));

    }

}
