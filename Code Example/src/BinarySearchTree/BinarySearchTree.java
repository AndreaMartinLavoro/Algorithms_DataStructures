package BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node Successore(Node n){
        if(n.getRightChild() != null){
            return MinRic(n.getRightChild());
        } else {
            Node y = n.getParent();
            while((y != null)&&(n == y.getRightChild())){
                n = y;
                y = y.getParent();
            }
            return y;
        }
    }

    public Node Predecessore(Node n){
        if(n.getLeftChild() != null){
            return MaxRic(n.getLeftChild());
        } else {
            Node y = n.getParent();
            while((y != null)&&(n == y.getLeftChild())){
                n = y;
                y = y.getParent();
            }
            return y;
        }
    }

    public void Insert(int val){
        root = InsertRic(root, val);
    }
    private Node InsertRic(Node n, int val){
        if(n == null){
            return new Node(val);
        }

        if(n.getValue() > val){
            n.setLeftChild(InsertRic(n.getLeftChild(), val));
        } else {
            n.setRightChild(InsertRic(n.getRightChild(), val));
        }

        return n;
    }

    public void Delete(Node n){ // n nodo diverso da null

        //Op 1 - Individuo il nodo n che eliminerò dall'albero:
        // Caso 1 e Caso 2 x è z
        // Caso 3 x è il successore di z
        Node x;

        if((n.getLeftChild()== null)||(n.getRightChild() == null)){
            x = n;
        } else {
            x = Successore(n);
        }

        //Op 2 - Elimino il nodo n sostituendolo con il suo figlio j
        Node y = x.getParent();
        Node v;

        if(x.getLeftChild() != null){
            v = x.getLeftChild();
        } else {
            v = x.getRightChild();
        }

        if(y == null){
            root = v;
        } else {
            if(x == y.getLeftChild()){
                y.setLeftChild(v);
            } else {
                y.setRightChild(v);
            }
        }

        if(v != null) {
            v.setParent(y);
        }

        //Op 3 - Se x è diverso da z copio la chiave di x in z
        if(n != x){
            n.setValue(x.getValue());
        }
    }

    public Node Search(int val){
        Node x = root;
        while((x!=null)&&(x.getValue()!=val)){
            if(x.getValue() > val){
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        return x;
    }

    public void Search_Ric(int val){
        Node node = SearchRic(root, val);

        if(node != null){
            System.out.println("Il numero " + val + " è stato trovato");
        } else {
            System.out.println("Il numero " + val + " NON è stato trovato");
        }
    }
    public Node SearchRic(Node n, int val){
        if((n == null)||(n.getValue() == val)){
            return n;
        } else {
            if (n.getValue() > val) {
                n = SearchRic(n.getLeftChild(), val);
            } else {
                n = SearchRic(n.getRightChild(), val);
            }
        }

        return n;
    }

    public Node Min_Iter(){ // In-Place
        Node x = root;

        while(x.getLeftChild() != null){
            x = x.getLeftChild();
        }
        return x;
    }

    public Node Min_Ric(){
        return MinRic(root);
    }
    private Node MinRic(Node n){
        //aux - controllo di non cadere fuori dall'albero
        if(n==null){
            return null;
        }

        if(n.getLeftChild()==null){
            return n;
        }

        return MinRic(n.getLeftChild());
    }

    public Node Max_Iter(){ // In-Place
        Node x = root;

        while(x.getRightChild() != null){
            x = x.getRightChild();
        }
        return x;
    }

    public Node Max_Ric(){
        return MaxRic(root);
    }
    private Node MaxRic(Node n){
        //aux - controllo di non cadere fuori dall'albero
        if(n==null){
            return null;
        }

        if(n.getRightChild()==null){
            return n;
        }

        return MaxRic(n.getRightChild());
    }

    public void Preorder(){
        System.out.println("Preorder");
        PreorderRic(root);
        System.out.println("");
    }
    private void PreorderRic(Node n){
        if(n != null){
            System.out.print(n.getValue() + " ");
            PreorderRic(n.getLeftChild());
            PreorderRic(n.getRightChild());
        }
    }

    public void Inorder(){
        System.out.println("Inorder");
        InorderRic(root);
        System.out.println("");
    }
    private void InorderRic(Node n){
        if(n != null){
            InorderRic(n.getLeftChild());
            System.out.print(n.getValue() + " ");
            InorderRic(n.getRightChild());
        }
    }

    public void Postorder(){
        System.out.println("Postorder");
        PostorderRic(root);
        System.out.println("");
    }
    private void PostorderRic(Node n){
        if(n != null){
            PostorderRic(n.getLeftChild());
            PostorderRic(n.getRightChild());
            System.out.print(n.getValue() + " ");
        }
    }
}
