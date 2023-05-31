package com.company.tools;

import java.awt.*;
import javax.swing.*;

public class BarGraph extends JPanel {
    private int [] valori;
    private int [] valNorm;
    private int max;
    private int valMax;
    private boolean drawChart;

    public BarGraph() { this( new int[0] ); }
    public BarGraph(int [] valori) {
        this.valori = valori;
        valNorm = new int[valori.length];
        drawChart = false;
        cercaMax();
    }

    public void setValori(int [] valori) {
        this.valori = valori;
        valNorm = new int[valori.length];
        cercaMax();
        normalizza();
    }
    public void disegna() {drawChart = true; repaint(); }

    public void paint(Graphics g) {
        if (drawChart) {
            for (int i=0; i<valori.length; i++) {
                g.fillRect((i*20 + 10), (valMax - valNorm[i])+10 , 10, getHeight());
            }
            g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        }
    }

    private void cercaMax() {
        for (int i=0; i<valori.length; i++) max = (valori[i] > max) ? valori[i] : max;
    }

    private void normalizza() {
        int altezza = getHeight()-10;
        for (int i=0; i<valori.length; i++) {
            valNorm[i] = (altezza * valori[i]) / max;
            if (valori[i] == max) valMax = valNorm[i];
            System.out.println(valNorm[i]);
        }
    }
}
