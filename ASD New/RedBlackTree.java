class RBTNode{
    int data;
    RBTNode parent;
    RBTNode left;
    RBTNode right;
    int color; // 0 black, 1 red

    public RBTNode(int data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.color = 1; // Inizializzato a rosso (1) per semplificare l'inserimento
    }
}
public class RedBlackTree {
    private RBTNode root;
    private RBTNode nullNode; // Nodo sentinella nero

    public RedBlackTree() {
        nullNode = new RBTNode(-1);
        nullNode.color = 0;
        root = nullNode;
    }

    // Metodo di ricerca
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(RBTNode root, int key) {
        if (root == nullNode || root.data == key) {
            return root != nullNode;
        }

        if (key < root.data) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    // Metodo di inserimento
    public void insert(int key) {
        RBTNode node = new RBTNode(key);
        insert(node);
    }

    private void insert(RBTNode z) {
        RBTNode y = nullNode;
        RBTNode x = root;

        while (x != nullNode) {
            y = x;
            if (z.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if (y == nullNode) {
            root = z;
        } else if (z.data < y.data) {
            y.left = z;
        } else {
            y.right = z;
        }

        z.left = nullNode;
        z.right = nullNode;
        z.color = 1; // Nuovo nodo è rosso

        insertFixup(z);
    }

    private void insertFixup(RBTNode z) {
        while (z.parent.color == 1) {
            if (z.parent == z.parent.parent.left) {
                RBTNode y = z.parent.parent.right;

                if (y.color == 1) {
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }

                    z.parent.color = 0;
                    z.parent.parent.color = 1;
                    rightRotate(z.parent.parent);
                }
            } else {
                // Simmetrico del caso sopra
            }
        }

        root.color = 0; // La radice deve essere nera
    }

    /*
     * Esegue una rotazione a sinistra attorno al nodo x nel contesto di un Red-Black Tree. 
     * La rotazione coinvolge il nodo y, che inizialmente è il figlio destro di x. 
     */
    private void leftRotate(RBTNode x) {
        // Salvataggio del nodo destro di x in una variabile temporanea y
        RBTNode y = x.right;
    
        // Aggiornamento del sottoalbero destro di x con il sottoalbero sinistro di y
        x.right = y.left;
    
        // Se il sottoalbero sinistro di y non è il nodo nullo, aggiorna il padre di esso a x
        if (y.left != nullNode) {
            y.left.parent = x;
        }
    
        // Aggiornamento del padre di y con il padre di x
        y.parent = x.parent;
    
        // Se x è la radice dell'albero, aggiorna la radice con y
        if (x.parent == nullNode) {
            root = y;
        } else if (x == x.parent.left) {
            // Se x è il figlio sinistro del suo genitore, aggiorna il figlio sinistro con y
            x.parent.left = y;
        } else {
            // Se x è il figlio destro del suo genitore, aggiorna il figlio destro con y
            x.parent.right = y;
        }
    
        // Aggiornamento del sottoalbero sinistro di y con x
        y.left = x;
    
        // Aggiornamento del padre di x con y
        x.parent = y;
    }
    

    // Rotazione a destra
    private void rightRotate(RBTNode x) {
        RBTNode y = x.left;

        x.left = y.right;
        if(y.right != nullNode) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if(x.parent == nullNode) {
            root = y;
        } else if(x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.right = x;

        x.parent = y;
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        // Inserisce nodi nel RBT
        rbt.insert(50);
        rbt.insert(30);
        rbt.insert(70);
        rbt.insert(20);
        rbt.insert(40);

        // Esegue la ricerca di un valore nel RBT
        int searchValue = 40;
        if (rbt.search(searchValue)) {
            System.out.println("Il valore " + searchValue + " è presente nel RBT.");
        } else {
            System.out.println("Il valore " + searchValue + " non è presente nel RBT.");
        }

        // Esegue la ricerca di un valore nel RBT
        searchValue = 42;
        if (rbt.search(searchValue)) {
            System.out.println("Il valore " + searchValue + " è presente nel RBT.");
        } else {
            System.out.println("Il valore " + searchValue + " non è presente nel RBT.");
        }
    }
}
