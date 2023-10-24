import java.util.TreeMap;
import java.util.Iterator;

public class AssociationTable<K extends Comparable<K>, V> {
    private TreeMap<K, V> table;

    // Constructor to initialize an empty table
    public AssociationTable() {
        this.table = new TreeMap<>();
    }

    // Constructor to initialize the table with arrays of keys and values
    public AssociationTable(K[] keys, V[] values) {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Mismatch in lengths of keys and values.");
        }
        this.table = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            this.table.put(keys[i], values[i]);
        }
    }

    // Add a key-value pair to the table
    public void add(K key, V value) {
        this.table.put(key, value);
    }

    // Get the value associated with the key
    public V get(K key) {
        return this.table.get(key);
    }

    // Check if the table contains the key
    public boolean contains(K key) {
        return this.table.containsKey(key);
    }

    // Remove the key-value pair with the specified key
    public boolean remove(K key) {
        return this.table.remove(key) != null;
    }

    // Get the number of key-value pairs in the table
    public int size() {
        return this.table.size();
    }

    // Get an iterator for the keys in the table
    public Iterator<K> keyIterator() {
        return this.table.keySet().iterator();
    }
}
