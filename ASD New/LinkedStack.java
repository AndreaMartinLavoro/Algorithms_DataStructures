class Node<T> {
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedStack<T> {
    private Node<T> top;

    public LinkedStack() {
        this.top = null;
    }

    // Metodo per verificare se la pila è vuota
    public boolean isEmpty() {
        return this.top == null;
    }

    // Metodo per inserire un elemento nella pila
    public void push(T data) {
        Node<T> newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Metodo per rimuovere e restituire l'elemento in cima alla pila
    public T pop() {
        if(isEmpty()) {
            throw new IllegalStateException("La pila è vuota");
        }

        T poppedData = top.data;
        top = top.next;

        return poppedData;
    }

    // Metodo per ottenere l'elemento in cima alla pila senza rimuoverlo
    public T peek() {
        if(isEmpty()) {
            throw new IllegalStateException("La pila è vuota");
        }

        return top.data;
    }

    // Metodo per stampare gli elementi della pila
    public void print() {
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Elementi della pila:");
        stack.print();

        System.out.println("Elemento in cima alla pila: " + stack.peek());

        System.out.println("Elemento rimosso dalla pila: " + stack.pop());

        System.out.println("Elementi della pila dopo la rimozione:");
        stack.print();
    }
}
