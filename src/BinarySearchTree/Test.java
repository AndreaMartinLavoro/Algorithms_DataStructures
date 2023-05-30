package BinarySearchTree;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree albero = new BinarySearchTree();

        int A[] = { 5, 20, 30, 15, 2, 10, 12, 18, 40 };

        for(int i=0; i<A.length; i++){
            albero.Insert(A[i]);
        }

        System.out.println(albero.Min_Ric().getValue());
        System.out.println(albero.Max_Ric().getValue());

        albero.Preorder();
        albero.Inorder();
        albero.Postorder();

        albero.Search_Ric(12);
        albero.Search_Ric(20);
        albero.Search_Ric(72);

        System.out.println("Successore: " + albero.Successore(albero.SearchRic(albero.root, 20)).getValue());
        System.out.println("Predecessore: " + albero.Predecessore(albero.SearchRic(albero.root, 20)).getValue());
    }
}
