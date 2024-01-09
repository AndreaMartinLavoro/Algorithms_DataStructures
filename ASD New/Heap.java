public class Heap {
    private int[] heap;
    private int heapsize; // dimensione del sottovettore contenente la Heap
    private int length; // dimensione del vettore

    public Heap(int length) {
        this.length = length;
        this.heapsize = 0;
        heap = new int[this.length];
    }

    public Heap(int[] array) {
        this.length = array.length;
        this.heapsize = 0;
        heap = array;
    }

    /**
     * Inserisce un nuovo elemento nella Heap
     * @param k elemento da inserire nella Heap
     */
    public void insert(int k) {
        if(this.heapsize < this.length) {
            this.heapsize ++;
            this.heap[this.heapsize] = k;
            int i = this.heapsize;
            while(i>0 && this.heap[i]>heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }
    }

    /**
     * Estrae la radice della Heap (numero più grande)
     * @return radice della Heap
     */
    public int extract() {
        if(this.heapsize > 0) {
            swap(0, this.heapsize - 1);
            this.heapsize --;
            heapify(0);
            return this.heap[this.heapsize];
        } else {
            throw new IllegalStateException("Errore");
        }
    }

    /**
     * Corregge le anomalie interne alla Heap
     * @param pos posizione di partenza per la correzione della Heap
     */
    public void heapify(int pos) {
        int l = left(pos);
        int r = right(pos);

        int m; // m punterà al massimo tra H[pos], H[l] e H[r]

        if(l < this.heapsize && this.heap[l] > this.heap[pos]) {
            m = l;
        } else {
            m = pos;
        }

        if(r < this.heapsize && this.heap[r] > this.heap[m]) {
            m = r;
        }

        if(m != pos) {
            swap(m, pos);
            heapify(m);
        }
    }

    /**
     * Crea una Heap a partire da un vettore
     */
    public void build() {
        this.heapsize = this.length;

        for(int i = this.length/2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private int parent(int p) { return p / 2; }

    private int left(int pos) { return (2 * pos) + 1; }

    private int right(int pos) { return (2 * pos) + 2; }

    /**
     * Scambia due elemento nel vettore
     * @param p posizione del primo elemento da scambiare
     * @param q posizione del secondo elemento da scambiare
     */
    public void swap(int p, int q) {
        int temp = this.heap[p];
        this.heap[p] = this.heap[q];
        this.heap[q] = temp;
    }

    /**
     * Ordina il vettore sfruttando la Heap
     */
    public void sort() {
        build();
        for (int i = this.heapsize - 1; i >= 1; i--){
            swap(0, i);
            this.heapsize --;
            heapify(0);
        }
    }

    /**
     * Stampa la Heap
     * @param title
     */
    public void print(String title) {
        System.out.println(title + ":");
        for (int item : heap) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] arg)
    {
        // Test per Heap
        Heap heap = new Heap(new int[]{4, 10, 3, 5, 1, 9, 12});

        heap.build();
        heap.print("Heap");

        System.out.println("Max: " + heap.extract());

        // Test prt HeapSort
        Heap newHeap = new Heap(new int[]{4, 10, 3, 5, 1, 9, 12});

        newHeap.sort();
        newHeap.print("After HeapSort");
    }
}
