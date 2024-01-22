class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// è già un BST
public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if(data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void insert(int data) {
        this.root = insertRecursive(root, data);
    }

    private void inorderRecursive(Node root) {
        if(root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void inorder() {
        inorderRecursive(this.root);
    }

    private void previsitRecursive(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            inorderRecursive(root.left);
            inorderRecursive(root.right);
        }
    }

    public void previsit() {
        previsitRecursive(this.root);
    }

    private void postorderRecursive(Node root) {
        if(root != null) {
            inorderRecursive(root.left);
            inorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postorder() {
        postorderRecursive(this.root);
    }

    private boolean searchRecursive(Node root, int data) {
        if(root == null) {
            return false;
        }

        if(data == root.data) {
            return true;
        } else if(data < root.data) {
            return searchRecursive(root.left, data);
        } else {
            return searchRecursive(root.right, data);
        }
    }

    public boolean search(int data) {
        return searchRecursive(this.root, data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserisce nodi nell'albero
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        System.out.println("Traversal in-order:");
        tree.inorder();
        System.out.println("");

        System.out.println("Traversal previsit:");
        tree.previsit();
        System.out.println("");

        System.out.println("Traversal postorder:");
        tree.postorder();
        System.out.println("");

        // Esegue la ricerca di un valore nel BST
        int searchValue = 40;
        if (tree.search(searchValue)) {
            System.out.println("\nIl valore " + searchValue + " è presente nel BST.");
        } else {
            System.out.println("\nIl valore " + searchValue + " non è presente nel BST.");
        }

        searchValue = 41;
        if (tree.search(searchValue)) {
            System.out.println("\nIl valore " + searchValue + " è presente nel BST.");
        } else {
            System.out.println("\nIl valore " + searchValue + " non è presente nel BST.");
        }
    }
}
