package Graphs;

public class MgGraph {
    private int n; // numero nodi
    private boolean[][] m; // matrice delle addiacenze

    public MgGraph(int n) {
        this.n = n;
        this.m = new boolean[n][n];
    }

    public void AddArc(int n1, int n2) {
        this.m[n1][n2] = true;
        this.m[n2][n1] = true;
    }

    public boolean ExistsArc(int n1, int n2) { // Verifica se esiste un arco tra 2 archi
        return this.m[n1][n2];
    }
}