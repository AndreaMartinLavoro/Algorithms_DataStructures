package com.company.es16;

public class Node {

    private int key;
    private Node left, right;

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int d) {
        key = d;
        left = null;
        right = null;
    }

}