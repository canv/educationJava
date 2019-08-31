package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class HashArray<K,V> {
    private static final int STORAGE_SIZE = 1_000_000;
    private MyLinkedList[] hashArray = new MyLinkedList[STORAGE_SIZE];

    public void put(K key, V val) {
        int hash = key.hashCode() * 32 & STORAGE_SIZE;

        if (hashArray[hash] == null) {
            MyLinkedList<K, V> entry = new MyLinkedList<>();
            entry.add(key, val);
            hashArray[hash] = entry;
        } else {
            if(key.equals(hashArray[hash].getKey()))
                hashArray[hash].overwrite(key, val);
            else hashArray[hash].add(key, val);
        }
    }

    public V get(K key) {
        int hash = key.hashCode()* 32 & STORAGE_SIZE;
        MyLinkedList extract = hashArray[hash];
        try {
            return (V) extract.get(key);
        }catch (NullPointerException exc)
        {consoleOut.println("Key \"" + key + "\" not found");}
        return null;
    }
}