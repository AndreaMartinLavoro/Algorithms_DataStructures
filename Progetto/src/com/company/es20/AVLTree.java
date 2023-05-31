package com.company.es20;

import java.util.ArrayList;
import java.util.Scanner;

public class AVLTree
{
    private Node root;

     private int getHeight(Node key){
        if (key == null)
            return 0;
        return key.getHeight();
    }

    private int getBalance(Node key){
        if (key == null)
            return 0;
        return (getHeight(key.getRight()) - getHeight(key.getLeft()));
    }

    private void updateHeight(Node key){
        int leftSubtreeHeight = getHeight(key.getLeft());
        int rightSubtreeHeight = getHeight(key.getRight());

        key.setHeight(Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }

    private Node rotateLeft(Node oldRoot){
        Node newRoot = oldRoot.getRight();
        Node temp = newRoot.getLeft();

        newRoot.setLeft(oldRoot);
        oldRoot.setRight(temp);

        updateHeight(oldRoot);
        updateHeight(newRoot);

        return newRoot;
    }

    private Node rotateRight(Node oldRoot){
        Node newRoot = oldRoot.getLeft();
        Node temp = newRoot.getRight();

        newRoot.setRight(oldRoot);
        oldRoot.setLeft(temp);

        updateHeight(oldRoot);
        updateHeight(newRoot);

        return newRoot;
    }

    private Node balanceTree(Node root){
        updateHeight(root);

        int balance = getBalance(root);

        if (balance == 2)
        {
            if (getBalance(root.getRight()) < 0)
                root.setRight(rotateRight(root.getRight()));

            return rotateLeft(root);
        }

        if (balance == -2)
        {
            if (getBalance(root.getLeft()) > 0)
                root.setLeft(rotateLeft(root.getLeft()));

            return rotateRight(root);
        }

        return root;
    }

    public Node insertNode(Node root, int key, String value){
        if (search(root , key) == null){
            if (root == null)
                return new Node(value, key);
            else if (key < root.getKey())
                root.setLeft(insertNode(root.getLeft(), key, value));
            else
                root.setRight(insertNode(root.getRight(), key, value));
        }
        return balanceTree(root);
    }

    private Node findSuccessor(Node root){
        if (root.getLeft() != null)
            return findSuccessor(root.getLeft());
        return root;
    }

    /*
     * Function : removeNode
     * Description : remove key from AVL tree
     * Order of Method : T(n) = O(log(n))
     */
   private Node removeNode(Node root, int key){
        if (root == null)
            return root;
        else if (key < root.getKey())
            root.setLeft(removeNode(root.getLeft(), key));
        else if (key > root.getKey())
            root.setRight(removeNode(root.getRight(), key));
        else{
            if (root.getRight() == null)
                root = root.getLeft();
            else if (root.getLeft() == null)
                root = root.getRight();
            else{
                Node temp = findSuccessor(root.getRight());
                root.setKey(temp.getKey());
                root.setValue(temp.getValue());
                root.setRight(removeNode(root.getRight(), root.getKey()));
            }
        }

        if (root == null)
            return root;

        else
            return balanceTree(root);
    }

    public Node search(Node root, int key){
        if (root == null || root.getKey() == key)
            return root;
        if (key < root.getKey())
            return search(root.getLeft(), key);
        else
            return search(root.getRight(), key);
    }

    public void delete(int key){
        if (search(root, key) != null){
            root = removeNode(root, key);
        }
    }

    public String show(Node root){
        if(root == null)
            return "NULL";
        else
            return "" + root.getKey() + ":" + root.getValue() + ":" + root.getHeight() + " " + show(root.getLeft())
                    + " " + show(root.getRight());
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
        AVLTree tree = new AVLTree();
        Scanner in = new Scanner(System.in);
        ArrayList<String> command;

        do{
            command = scanArray(in);

            if(command.contains("insert"))
                tree.root = tree.insertNode(tree.root, Integer.parseInt(command.get(1)), command.get(2));
            else if(command.contains("show"))
                System.out.println(tree.show(tree.root));
            else if(command.contains("find"))
                System.out.println(tree.search(tree.root, Integer.parseInt(command.get(1))).getValue());
            else if(command.contains("remove"))
                tree.delete(Integer.parseInt(command.get(1)));

        }while(!command.contains("exit"));
    }
}