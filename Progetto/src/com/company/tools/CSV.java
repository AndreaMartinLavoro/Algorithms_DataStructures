package com.company.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSV {
    private final String SEPARETOR = File.separator;  //"compilazione condizionale" - path valido sia per unix e windows
    private FileWriter writer;
    private String path;
    
    public CSV(String s){
        long date = new Date().getTime(); //unix timestamp(univocità file contenente i tempi)
        this.path = "CSV" + SEPARETOR + s + "_" + date + ".csv";

        try {
            this.writer = new FileWriter(path, true);

            this.writer.append("Tempo");
            this.writer.append(',');
            this.writer.append("DimInput");
            this.writer.append(",");
            this.writer.append("posCercata");
            this.writer.append('\n');
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void csvWriter(ArrayList<Double> times, int n, ArrayList<Integer> pos) throws IOException {
        for (int i = 0; i < times.size(); i ++) {
            this.writer.append("" + times.get(i));
            this.writer.append(',');
            this.writer.append("" + n);
            this.writer.append(',');
            this.writer.append("" + pos.get(i));
            this.writer.append('\n');
            this.writer.flush();
        }
    }

    public void csvClose(){
        try{
            this.writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        /*CSV test = new CSV("test");
        ArrayList<Double> times = new ArrayList<>();

        times.add(1.0);
        test.csvWriter(times,1, 1);*/
    }
}