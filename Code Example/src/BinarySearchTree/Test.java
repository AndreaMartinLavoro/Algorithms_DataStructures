package BinarySearchTree;

public class Test {
    public static void main(String[] args) {
        BST bst = new BST();

        // Inserimento di alcuni valori nell'albero
        bst.Insert(50);
        bst.Insert(30);
        bst.Insert(20);
        bst.Insert(40);
        bst.Insert(70);
        bst.Insert(60);
        bst.Insert(80);

        // Stampa dell'albero in ordine
        System.out.println("Inorder traversal:");
        bst.Inorder();

        // Ricerca di un nodo nell'albero
        int searchValue = 40;
        BST.Node searchResult = bst.Search(searchValue);
        if (searchResult != null) {
            System.out.println("Il nodo con valore " + searchValue + " è stato trovato.");
        } else {
            System.out.println("Il nodo con valore " + searchValue + " non è stato trovato.");
        }

        // Calcolo del successore di un nodo
        int successorValue = 30;
        BST.Node successor = bst.Successore(bst.Search(successorValue));
        if (successor != null) {
            System.out.println("Il successore di " + successorValue + " è " + successor.getValue());
        } else {
            System.out.println("Non esiste un successore per il nodo con valore " + successorValue);
        }

        // Calcolo del predecessore di un nodo
        int predecessorValue = 60;
        BST.Node predecessor = bst.Predecessore(bst.Search(predecessorValue));
        if (predecessor != null) {
            System.out.println("Il predecessore di " + predecessorValue + " è " + predecessor.getValue());
        } else {
            System.out.println("Non esiste un predecessore per il nodo con valore " + predecessorValue);
        }

        // Stampa dell'albero in ordine
        System.out.println("Inorder traversal:");
        bst.Inorder();

        // Eliminazione di un nodo dall'albero
        int deleteValue = 30;
        BST.Node deleteNode = bst.Search(deleteValue);
        if (deleteNode != null) {
            bst.Delete(deleteNode);
            System.out.println("Il nodo con valore " + deleteValue + " è stato eliminato.");
        } else {
            System.out.println("Il nodo con valore " + deleteValue + " non è presente nell'albero.");
        }

        // Stampa dell'albero in ordine dopo l'eliminazione
        System.out.println("Inorder traversal dopo l'eliminazione:");
        bst.Inorder();
    }
}
