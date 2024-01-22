// Hash Table con gestione delle collisioni mediante Open Adressing (come funzione di Hash viene utilizzato il metodo della moltiplicazione)
class Entry {
    private int key;
    private String value;

    public Entry(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(int key) {
        this.key = key;
    }
 }

public class HashTable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;

    private Entry[] table;
    private int size;

    public HashTable() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void put(int key, String value) {
        if ((double) (size + 1) / table.length > LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int index = hash(key);
        int originalIndex = index;

        do {
            if (table[index] == null || table[index].getKey() == -1) {
                table[index] = new Entry(key, value);
                size++;
                return;
            }

            index = (index + 1) % table.length;
        } while (index != originalIndex);

        // La tabella è piena, non è possibile inserire l'elemento
        System.out.println("Errore: Tabella piena, impossibile inserire l'elemento.");
    }

    public String get(int key) {
        int index = findIndex(key);
        return (index != -1) ? table[index].getValue() : null;
    }

    public void remove(int key) {
        int index = findIndex(key);
        if (index != -1) {
            table[index].setKey(-1);  // Segna l'elemento come rimosso
            size--;
        }
    }

    /**
     * A partire da una chiave, cerca l'indice di un elemento se presente nella tabella.
     * @param key chiave da controllare nella tabella
     * @return restituisce l'indice dell'elemento se presente
     */
    private int findIndex(int key) {
        int index = hash(key);
        int originalIndex = index;

        do {
            if (table[index] == null) {
                return -1;  // L'elemento non è presente
            }

            if (table[index].getKey() == key) {
                return index;  // L'elemento è presente
            }

            index = (index + 1) % table.length;
        } while (index != originalIndex);

        return -1;  // L'elemento non è presente
    }

    private void resize() {
        Entry[] oldTable = table;
        table = new Entry[2 * oldTable.length];
        size = 0;

        for (Entry entry : oldTable) {
            if (entry != null && entry.getKey() != -1) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private int hash(int key) { // metodo della moltiplicazione
        double A = (Math.sqrt(5) - 1) / 2;  // Costante di Knuth -> raccomandata per una buona dispersione
        double temp = key * A; // Moltiplicazione della chiave per la costante
        temp = temp - Math.floor(temp); // Sottraiamo la parte intera di questo risultato per ottenere la parte frazionaria di A
        return (int) Math.floor(table.length * temp);
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Inserimento di elementi
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");
        hashTable.put(4, "Four");
        hashTable.put(5, "Five");

        // Ricerca ed output
        System.out.println("Elemento con chiave 3: " + hashTable.get(3));  // Output: Three
        System.out.println("Elemento con chiave 6: " + hashTable.get(6));  // Output: null

        // Rimozione di un elemento
        hashTable.remove(2);

        // Ricerca dopo la rimozione
        System.out.println("Elemento con chiave 2 dopo la rimozione: " + hashTable.get(2));  // Output: null
    }
 }