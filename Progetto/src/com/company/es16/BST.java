package com.company.es16;

import java.util.ArrayList;
import java.util.Scanner;

public class BST {
    private Node root;

    BST() {
        root = null;
    }

    public void insert(int key) {
        Node parent = null;
        Node temp = this.root;
        int rightOrLeft = -1;

        while (temp != null){
            if (temp.getKey() > key){
                parent = temp;
                temp = parent.getLeft();
                rightOrLeft = 0;
            }else if (temp.getKey() < key){
                parent = temp;
                temp = parent.getRight();
                rightOrLeft = 1;
            }else{
                return;
            }
        }

        Node newNode = new Node(key);

        if (parent == null) {
            this.root = newNode;
        } else{
            if (rightOrLeft == 0)
                parent.setLeft(newNode);
            else
                parent.setRight(newNode);
        }
    }

    public String show(Node root){
        if(root == null)
            return "NULL";
        else
            return "" + root.getKey() + " " + show(root.getLeft())
                    + " " + show(root.getRight());
    }

    public boolean isBST(String a, String b){
        return a.equalsIgnoreCase(b);
    }

    public static ArrayList<String> scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();

        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");

        ArrayList<String> arr = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) // some tokens may be empty (e.g. with trailing spaces)
                arr.add(token);
        }

        return arr;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner in = new Scanner(System.in);
        ArrayList<String> plRep = scanArray(in);
        String plRepStr = String.join(" ", plRep);

        for(String key : plRep){
            if(!key.equalsIgnoreCase("NULL"))
                tree.insert(Integer.parseInt(key));
        }
        String BSTplRep = tree.show(tree.root);

        if(tree.isBST(BSTplRep, plRepStr))
            System.out.println(1);
        else
            System.out.println(0);
    }
}