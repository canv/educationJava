package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class HashArray<K,V> {
    private static final int SIZE = 1_000_000;
    private MyLinkedList[] hashArray = new MyLinkedList[SIZE];

    public void put(K key, V val) {
        int hash = key.hashCode() * 32 & SIZE;

        if (hashArray[hash] == null) {
            MyLinkedList<K, V> entry = new MyLinkedList<>();
            entry.addToEnd(key, val);
            hashArray[hash] = entry;
        } else {
            hashArray[hash].addToEnd(key, val);
        }
    }

    public V get(K key) {
        int hash = key.hashCode()* 32 & SIZE;
        MyLinkedList extract = hashArray[hash];
        try {
            return (V) extract.getValue(key);
        }catch (NullPointerException exc)
        {consoleOut.println("Key \"" + key + "\" not found");}
        return null;
    }
}