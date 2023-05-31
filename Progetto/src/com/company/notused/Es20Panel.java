package com.company.notused;

import com.company.tools.DataSet;

import javax.swing.*;

public class Es20Panel extends JPanel {
    public Es20Panel() {
        // crea il modello di dati
        DataSet dataModel = new DataSet();
        // crea la tabella
        JTable t = new JTable(dataModel);
        // aggiunge la tabella ad uno ScollPane
        JScrollPane scrollpane = new JScrollPane(t);
        // aggiunge lo ScrollPane al pannello
        add(scrollpane);
    }
    public static void main(String [] args) {
        new Es20Panel();
    }
}