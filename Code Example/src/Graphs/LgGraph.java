package Graphs;

import java.util.*;

public class LgGraph {
    private int n; // numero nodi
    private List<List<Integer>> l; // lista delle addiacenze

    public LgGraph(int n){
        this.n = n;
        this.l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>()); // Inizializza le liste di adiacenza per ogni nodo
        }
    }

    public void AddArc(int n1, int n2) {
        l.get(n1).add(n2);
        l.get(n2).add(n1);
    }

    public List<Integer> GetAdjacentNodes(int nodo) {
        return l.get(nodo);
    }

    /***
     * La BFS (visita in ampiezza) esplora il grafo a partire da un nodo iniziale e visita
     * tutti i nodi adiacenti di livello immediatamente successivo prima di passare ai nodi adiacenti
     * di livello successivo.
     * @param nodoIniziale nodo da cui fare iniziare la visita
     */
    public void BFS(int nodoIniziale) {
        boolean[] visitati = new boolean[this.n]; // Array per tracciare i nodi visitati
        Queue<Integer> coda = new LinkedList<>(); // Coda per la visita BFS

        visitati[nodoIniziale] = true; // Segna il nodo iniziale come visitato
        coda.offer(nodoIniziale); // Aggiunge il nodo iniziale alla coda

        while (!coda.isEmpty()) {
            int nodoCorrente = coda.poll(); // Prende il primo nodo dalla coda
            System.out.print(nodoCorrente + " "); // Stampa il nodo corrente

            // Esplora i nodi adiacenti non ancora visitati
            for (int nodoAdiacente : this.l.get(nodoCorrente)) {
                if (!visitati[nodoAdiacente]) {
                    visitati[nodoAdiacente] = true; // Segna il nodo adiacente come visitato
                    coda.offer(nodoAdiacente); // Aggiunge il nodo adiacente alla coda
                }
            }
        }
    }

    /***
     * La DFS (visita in profondità) esplora il grafo a partire da un nodo iniziale e
     * prosegue fino a quando non si raggiunge un nodo foglia (un nodo senza nodi adiacenti non visitati)
     * e quindi torna indietro.
     * L'algoritmo esplora il grafo a "profondità", visitando un percorso fino a quando non raggiunge
     * un punto di arresto e quindi tornando indietro per esplorare altri percorsi.
     * @param nodoIniziale nodo da cui fare iniziare la visita
     */
    public void DFS(int nodoIniziale) {
        boolean[] visitati = new boolean[this.n]; // Array per tracciare i nodi visitati
        Stack<Integer> stack = new Stack<>(); // Stack per la visita DFS

        stack.push(nodoIniziale); // Aggiunge il nodo iniziale allo stack

        while (!stack.isEmpty()) {
            int nodoCorrente = stack.pop(); // Prende il nodo corrente dallo stack

            if (!visitati[nodoCorrente]) {
                visitati[nodoCorrente] = true; // Segna il nodo corrente come visitato
                System.out.print(nodoCorrente + " "); // Stampa il nodo corrente

                // Aggiunge i nodi adiacenti non ancora visitati allo stack
                for (int nodoAdiacente : this.l.get(nodoCorrente)) {
                    if (!visitati[nodoAdiacente]) {
                        stack.push(nodoAdiacente);
                    }
                }
            }
        }
    }

}
