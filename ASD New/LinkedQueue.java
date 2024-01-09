class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Verifica se la coda è vuota
     * @return (boolean) true se la coda è vuota
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Restituisce la dimensione della coda
     * @return (int) dimensione della coda
     */
    public int size() {
        return this.size;
    }

    /**
     * Inserisce un elemento in coda
     * @param data informazione da inserire
     */
    public void enqueue(T data) {
        Node<T> newNode = new Node(data);
        if(isEmpty()) {
            this.head = newNode;
        }
        else {
            this.tail = newNode;
        }

        this.tail = newNode;
        this.size ++;
    }

    /**
     * Rimuove e restituisce l'elemento in testa alla coda
     * @return l'informazone rimossa
     */
    public T dequeue(){
        if(isEmpty()) {
            throw new IllegalStateException("La coda è vuota");
        }

        T data = this.head.data;
        this.head = this.head.next;
        this.size --;

        if(isEmpty()){ // Se la coda è diventata vuota, imposta anche il rear a null
            this.tail = null;
        }

        return data;
    }

    /**
     * Restituisce l'elemento in testa alla coda senza rimuoverlo
     * @return l'informazone in testa alla coda
     */
    public T peek(){
        if(isEmpty()) {
            throw new IllegalStateException("La coda è vuota");
        }

        return this.head.data;
    }

    /**
     * Stampa gli elementi della coda
     */
    public void print() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Elementi nella coda:");
        queue.print();

        System.out.println("Elemento rimosso dalla coda: " + queue.dequeue());

        System.out.println("Elementi nella coda dopo la rimozione:");
        queue.print();
    }
}
