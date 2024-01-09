public class OversizedArrayQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int head;
    private int tail;
    private int size;

    public OversizedArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.head = 0;
        this.tail = -1;
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
        if(this.size == this.array.length) {
            resize();
        }

        this.tail = (this.tail + 1) % this.array.length;
        this.array[this.tail] = data;
        this.size ++;
    }

    /**
     * Rimuove e restituisce l'elemento in testa alla coda
     * @return l'informazone rimossa
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La coda è vuota");
        }

        T data = (T) this.array[this.head];
        this.head = (this.head + 1) % this.array.length;
        this.size --;

        return data;
    }

    /**
     * Restituisce l'elemento in testa alla coda senza rimuoverlo
     * @return l'informazone in testa alla coda
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La coda è vuota");
        }

        return (T) this.array[this.head];
    }

    private void resize() { // Metodo per riallocare un nuovo array con dimensione maggiore
        int newCapacity = this.array.length * 2;
        Object[] newArray = new Object[newCapacity];

        // Copia gli elementi dalla coda all'array sovradimensionato
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[(this.head + i) % this.array.length];
        }

        this.array = newArray;
        this.head = 0;
        this.tail = this.size - 1;
    }

    // Metodo per stampare gli elementi della coda
    public void print() { 
        int current = this.head;
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[current] + " ");
            current = (current + 1) % this.array.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OversizedArrayQueue<Integer> queue = new OversizedArrayQueue<>();

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
