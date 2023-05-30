package BinarySearchTree;

public class Node {
    private int value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Permette di leggere il valore associato al nodo
     * @return un intero corrispondente al valore del nodo
     */
    public int getValue(){
        return this.value;
    }
    public void setValue(int val){
        this.value = val;
    }
    public void setParent(Node child) { parent = child; }
    public void setLeftChild(Node n) {
        left = n;
        if (n != null){
            n.setParent(this);
        }
    }
    public void setRightChild(Node n) {
        right = n;
        if (n != null){
            n.setParent(this);
        }
    }
    public Node getParent() { return parent; }
    public Node getLeftChild() { return left; }
    public Node getRightChild() { return right; }
}
