public class OversizedArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public OversizedArrayStack(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Metodo per verificare se la pila è vuota
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Metodo per inserire un elemento nella pila
    public void push(T data) {
        if(this.size == this.array.length) {
            resize();
        }

        this.array[size++] = data;
    }

    // Metodo per rimuovere e restituire l'elemento in cima alla pila
    public T pop() {
        if(isEmpty()) {
            throw new IllegalStateException("La pila è vuota");
        }

        this.size --;
        T poppedData = (T) this.array[this.size];
        this.array[this.size] = null; // Set null per evitare memory leak

        return poppedData;
    }

    // Metodo per ottenere l'elemento in cima alla pila senza rimuoverlo
    public T peek(){
        if(isEmpty()) {
            throw new IllegalStateException("La pila è vuota");
        }

        T poppedData = (T) this.array[this.size - 1];

        return poppedData;
    }

    private void resize() { // Metodo per riallocare un nuovo array con dimensione maggiore
        int newCapacity = this.array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, size);
        this.array = newArray;
    }

    // Metodo per stampare gli elementi della pila
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OversizedArrayStack<Integer> stack = new OversizedArrayStack<>();

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
