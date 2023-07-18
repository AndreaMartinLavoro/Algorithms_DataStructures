package Graphs;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        //Test implementazione con Liste di Addicenza
        int numNodi = 5;
        LgGraph grafo = new LgGraph(numNodi);

        grafo.AddArc(0, 1);
        grafo.AddArc(0, 4);
        grafo.AddArc(1, 2);
        grafo.AddArc(1, 3);
        grafo.AddArc(1, 4);
        grafo.AddArc(2, 3);
        grafo.AddArc(3, 4);

        for (int i = 0; i < numNodi; i++) {
            System.out.print("Nodi adiacenti al nodo " + i + ": ");
            List<Integer> nodiAdiacenti = grafo.GetAdjacentNodes(i);
            for (Integer nodo : nodiAdiacenti) {
                System.out.print(nodo + " ");
            }
            System.out.println();
        }

        int nodoIniziale = 0;

        System.out.print("Visita in ampiezza (BFS): ");
        grafo.BFS(nodoIniziale);

        System.out.println("");

        System.out.print("Visita in profondità (DFS): ");
        grafo.DFS(nodoIniziale);

        System.out.println("");

        //Test implementazione con Matrice di Addicenza
        numNodi = 5;
        MgGraph grafo_m = new MgGraph(numNodi);

        grafo_m.AddArc(0, 1);
        grafo_m.AddArc(0, 4);
        grafo_m.AddArc(1, 2);
        grafo_m.AddArc(1, 3);
        grafo_m.AddArc(1, 4);
        grafo_m.AddArc(2, 3);
        grafo_m.AddArc(3, 4);

        System.out.println("Esiste l'arco tra il nodo 0 e il nodo 1? " + grafo_m.ExistsArc(0, 1));
        System.out.println("Esiste l'arco tra il nodo 2 e il nodo 4? " + grafo_m.ExistsArc(2, 4));
        System.out.println("Esiste l'arco tra il nodo 3 e il nodo 0? " + grafo_m.ExistsArc(3, 0));
    }
}
