package RedBlackTree;

public class Test {
    public static void main(String[] args) {
        RBT tree = new RBT();

        // Inserimento dei valori nell'albero
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);

        // Stampa dell'albero in ordine
        System.out.println("Albero in ordine:");
        tree.drawTree();

        // Ricerca di un nodo
        int searchValue = 7;
        RBT.Node searchedNode = tree.search(searchValue);
        if (searchedNode != null) {
            System.out.println("Nodo trovato: " + searchedNode.data);
        } else {
            System.out.println("Nodo non trovato.");
        }

        // Cancellazione di un nodo
        int deleteValue = 12;
        tree.delete(deleteValue);

        // Stampa dell'albero in ordine dopo la cancellazione
        System.out.println("Albero in ordine dopo la cancellazione di " + deleteValue + ":");
        tree.drawTree();
    }
}
