package RedBlackTree;

public class RBT {
    private Node root;
    private Node nil; // Nodo sentinella nero

    public class Node {
        public int data;
        public Node parent;
        public Node left;
        public Node right;
        public int color; // 0 = nero, 1 = rosso
    }

    //Costruttore
    public RBT() {
        nil = new Node();
        nil.color = 0;
        root = nil;
    }


    /***
     * Inserisce un nuovo nodo nell'albero e chiama insertFixup per ripristinare le proprietà del Red-Black Tree dopo l'inserimento.
     *
     * @param value valore da inserire nel nuovo Nodo
     */
    public void insert(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.left = nil;
        newNode.right = nil;
        newNode.color = 1; // Nuovi nodi sono sempre rossi

        Node current = root;
        Node parent = null;

        while (current != nil) {
            parent = current;
            if (value < current.data)
                current = current.left;
            else
                current = current.right;
        }

        newNode.parent = parent;

        if (parent == null) {
            root = newNode; // Albero vuoto, il nuovo nodo diventa la radice
        } else if (value < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        insertFixup(newNode); // Chiamata alla funzione di ripristino
    }

    /***
     * Esegue la ricolorazione e le rotazioni necessarie per mantenere le proprietà dell'albero.
     * Viene chiamata iterativamente fino a quando le proprietà non vengono ripristinate.
     *
     * @param x nodo di partenza
     */
    private void insertFixup(Node x) {
        while (x.parent != null && x.parent.color == 1) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.right;
                if (y != null && y.color == 1) {
                    x.parent.color = 0;
                    y.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    rightRotate(x.parent.parent);
                }
            } else {
                Node y = x.parent.parent.left;
                if (y != null && y.color == 1) {
                    x.parent.color = 0;
                    y.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    leftRotate(x.parent.parent);
                }
            }
        }

        root.color = 0; // Assicura che la radice sia sempre nera
    }


    /***
     * Per rimuove un nodo specificato dall'albero.
     * Viene chiamata deleteFixup per ripristinare le proprietà del Red-Black Tree dopo la cancellazione.
     *
     * @param value
     */
    public void delete(int value) {
        Node z = search(value);
        if (z == nil)
            return;

        Node y = z;
        Node x;
        int yOriginalColor = y.color;

        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == 0)
            deleteFixup(x);
    }

    /***
     * Esegue il ripristino delle proprietà dell'albero dopo la cancellazione, eseguendo ricolorazioni e rotazioni se necessario,
     * fino a quando tutte le proprietà non sono state ripristinate.
     *
     * @param x
     */
    private void deleteFixup(Node x) {
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == 0 && w.right.color == 0) {
                    w.color = 1;
                    x = x.parent;
                } else {
                    if (w.right.color == 0) {
                        w.left.color = 0;
                        w.color = 1;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node w = x.parent.left;
                if (w.color == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.left.color == 0 && w.right.color == 0) {
                    w.color = 1;
                    x = x.parent;
                } else {
                    if (w.left.color == 0) {
                        w.right.color = 0;
                        w.color = 1;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }


    /***
     * Esegue una ricerca ricorsiva nell'albero per trovare un nodo con il valore specificato.
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        return searchRecursive(root, value);
    }

    private Node searchRecursive(Node node, int value) {
        if (node == nil || value == node.data)
            return node;
        if (value < node.data)
            return searchRecursive(node.left, value);
        else
            return searchRecursive(node.right, value);
    }


    /***
     * Per trovare il valore minimo nell'albero
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        while (node.left != nil)
            node = node.left;
        return node;
    }


    /***
     * Per la sostituzione di un sottoalbero con un altro sottoalbero
     *
     * @param u
     * @param v
     */
    private void transplant(Node u, Node v) {
        if (u.parent == nil)
            root = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;
        v.parent = u.parent;
    }


    /***
     * Rotazione a sinistra
     *
     * @param x
     */
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }


    /***
     * Rotazione a destra
     *
     * @param x
     */
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;
        y.right = x;
        x.parent = y;
    }


    /***
     * Funzione di ricolorazione
     *
     * @param x
     */
    private void recolor(Node x) {
        if (x == root) {
            x.color = 0; // Imposta il colore della radice a nero
        } else {
            while (x != root && x.parent.color == 1) {
                if (x.parent == x.parent.parent.left) {
                    Node y = x.parent.parent.right;
                    if (y != null && y.color == 1) {
                        x.parent.color = 0;
                        y.color = 0;
                        x.parent.parent.color = 1;
                        x = x.parent.parent;
                    } else {
                        if (x == x.parent.right) {
                            x = x.parent;
                            leftRotate(x);
                        }
                        x.parent.color = 0;
                        x.parent.parent.color = 1;
                        rightRotate(x.parent.parent);
                    }
                } else {
                    Node y = x.parent.parent.left;
                    if (y != null && y.color == 1) {
                        x.parent.color = 0;
                        y.color = 0;
                        x.parent.parent.color = 1;
                        x = x.parent.parent;
                    } else {
                        if (x == x.parent.left) {
                            x = x.parent;
                            rightRotate(x);
                        }
                        x.parent.color = 0;
                        x.parent.parent.color = 1;
                        leftRotate(x.parent.parent);
                    }
                }
            }
            root.color = 0; // Assicura che la radice sia sempre nera
        }
    }


    /***
     * Richiama la funzione ausiliaria 'printTreeRecursive', che esegue la visita in-order sull'albero e stampa i valori dei nodi.
     */
    public void printTree() {
        printTreeRecursive(root);
    }

    /***
     * Viene effettuata una chiamata ricorsiva per visitare il sottoalbero sinistro,
     * quindi viene stampato il valore del nodo corrente insieme al suo colore (nero = B, rosso = R)
     * e infine viene effettuata una chiamata ricorsiva per visitare il sottoalbero destro.
     *
     * @param node
     */
    private void printTreeRecursive(Node node) {
        if (node == nil)
            return;

        printTreeRecursive(node.left);
        System.out.print(node.data + "(" + (node.parent == null ? "B" : (node.color == 0 ? "B" : "R")) + ") ");
        printTreeRecursive(node.right);
    }


    /***
     * Richiama la funzione ausiliaria 'drawTreeRecursive',
     * che esegue una visita post-ordine dell'albero per disegnarlo in modo ricorsivo.
     */
    public void drawTree() {
        drawTreeRecursive(root, "");
    }

    /***
     * Viene effettuata una chiamata ricorsiva per visitare il sottoalbero destro. Viene quindi stampata una linea verticale ('|---') seguita dal valore del nodo corrente e il suo colore.
     * Utilizziamo uno spazio aggiuntivo ('" "') come prefisso per creare l'indentazione visiva dell'albero.
     *
     * Infine, viene effettuata una chiamata ricorsiva per visitare il sottoalbero sinistro utilizzando un prefisso incrementato con spazi.
     *
     * Questo approccio utilizza la rappresentazione ASCII per disegnare l'albero, rendendo più facile la visualizzazione della struttura dell'albero in modo grafico.
     *
     * @param node
     * @param prefix
     */
    private void drawTreeRecursive(Node node, String prefix) {
        if (node == nil)
            return;

        drawTreeRecursive(node.right, prefix + "    ");

        System.out.println(prefix + "|---" + node.data + (node.color == 0 ? " (B)" : " (R)"));

        drawTreeRecursive(node.left, prefix + "    ");
    }
}
