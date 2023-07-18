package BTree;

import java.util.ArrayList;
import java.util.List;

public class BTree {
    private Node root;
    private int degree;
    private class Node{
        private int numKeys;
        private List<Integer> keys;
        private List<Node> children;
        private boolean leaf;

        public Node() {
            this.numKeys = 0;
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
            this.leaf = true;
        }
    }

    public BTree(int degree) {
        this.root = new Node();
        this.degree = degree;
    }

    public void BTreeInsert(int key) {
        Node r = root;
        if (r.numKeys == (2 * degree) - 1) {
            Node s = new Node(); // creo nuovo nodo radice
            root = s;
            s.children.add(r);
            BTreeSplitChild(s, 0, r); // split vecchi radice
            BTreeInsertNonFull(s, key); // inserimento
        } else {
            BTreeInsertNonFull(r, key);
        }
    }

    private void BTreeInsertNonFull(Node x, int key) {
        int i = x.numKeys - 1;
        if (x.leaf) { // inserimento in nodo foglia
            while (i >= 0 && key < x.keys.get(i)) {
                i--;
            }
            x.keys.add(i + 1, key);
            x.numKeys++;
        } else { // inserimento in nodo non foglia
            while (i >= 0 && key < x.keys.get(i)) {
                i--;
            }
            i++;
            if (x.children.get(i).numKeys == (2 * degree) - 1) {
                BTreeSplitChild(x, i, x.children.get(i));
                if (key > x.keys.get(i)) {
                    i++;
                }
            }
            BTreeInsertNonFull(x.children.get(i), key);
        }
    }

    private void BTreeSplitChild(Node x, int i, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        for (int j = 0; j < degree - 1; j++) {
            z.keys.add(j, y.keys.remove(degree)); // parte destra nodo pieno
        }
        if (!y.leaf) {
            for (int j = 0; j < degree; j++) {
                z.children.add(j, y.children.remove(degree)); // se non è foglia, copio i figli
            }
        }
        y.numKeys = degree - 1;
        x.keys.add(i, y.keys.get(degree - 1));
        x.children.add(i + 1, z);
        x.numKeys++;
    }

    public int BTreeHeight(){
        Node x = root;
        int h = 0;

        while(!x.leaf){
            x = x.children.get(1);
            h++;
        }
        return h;
    }

    public boolean BTreeSearch(int key) {
        return BTreeSearchKey(root, key);
    }
    private boolean BTreeSearchKey(Node x, int key) {
        int i = 0;
        while (i < x.numKeys && key > x.keys.get(i)) {
            i++; // scandisco il nodo finchè trovo chiavi < k
        }
        if (i < x.numKeys && key == x.keys.get(i)) {
            //return ( x, i )
            return true; // trovato k
        } else if (x.leaf) {
            //return NIL
            return false; // k non appartiene a T
        } else {
            return BTreeSearchKey(x.children.get(i), key); // sottoalbero i-esimo
        }
    }
}
