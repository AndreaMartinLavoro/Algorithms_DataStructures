package com.company.tools;

import javax.swing.table.AbstractTableModel;

public class DataSet extends AbstractTableModel {
        // ritorna il numero di colonne
        public int getColumnCount() { return 10; }
        // ritorna il numero di righe
        public int getRowCount() { return 10;}
        // ritorna il contenuto di una cella
        public Object getValueAt(int row, int col)
        {
            // ritorna il prodotto
            return new Integer((row+1)*(col+1));
        }
        // ritorna il nome della colonna
        public String getColumnName(int col) {
            // e' il numero di colonna
            return Integer.toString(col+1);
        }
        // specifica se le celle sono editabili
        public boolean isCellEditable(int row, int col)
        {
            // nessuna cella editabile
            return false;
        }
}
