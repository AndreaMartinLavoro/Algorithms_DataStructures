package com.company.notused;

import javax.swing.*;

public class TableExample {
    JFrame f;

    public TableExample() {
        f = new JFrame();
        String data[][] = {{"101", "Amit", "670000"},
                {"102", "Jai", "780000"},
                {"101", "Sachin", "700000"}};
        String column[] = {"INPUT", "OUTPUT", "TIMER"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 400);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new TableExample();
    }
}

/*
*   Accenni di Teoria e Base Code :https://www.javatpoint.com/java-jtable
 */
