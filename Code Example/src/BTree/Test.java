package BTree;

public class Test {
    public static void main(String[] args) {
        BTree bTree = new BTree(3); // Creazione di un albero B con grado 3

        // Inserimento di alcuni valori nell'albero
        bTree.BTreeInsert(10);
        bTree.BTreeInsert(20);
        bTree.BTreeInsert(5);
        bTree.BTreeInsert(15);
        bTree.BTreeInsert(30);

        // Ricerca di valori nell'albero
        System.out.println(bTree.BTreeSearch(10)); // Output: true
        System.out.println(bTree.BTreeSearch(25)); // Output: false

        // Inserimento di altri valori nell'albero
        bTree.BTreeInsert(25);
        bTree.BTreeInsert(40);

        // Ricerca dei nuovi valori nell'albero
        System.out.println(bTree.BTreeSearch(25)); // Output: true
        System.out.println(bTree.BTreeSearch(40)); // Output: true
        System.out.println(bTree.BTreeSearch(35)); // Output: false
    }
}
