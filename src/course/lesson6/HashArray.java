package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class HashArray<K,V> {
    private static final int INITIAL_SIZE = 1_000_000;
    private MyLinkedList[] hashArray = new MyLinkedList[INITIAL_SIZE+1];

    public void put(K key, V val) {
        int hash = entryAddress(key);
        if (hashArray[hash] == null) {
            MyLinkedList<K, V> entry = new MyLinkedList<>();
            entry.add(key, val);
            hashArray[hash] = entry;
        } else {
            if(hashArray[hash].coincidenceCorrection(key,val));
            else {
                hashArray[hash].add(key, val);
            }
        }
    }

    public V get(K key) {
        MyLinkedList extract = hashArray[entryAddress(key)];
        try {
            return (V) extract.get(key);
        }catch (NullPointerException exc)
        {consoleOut.println("Key \"" + key + "\" not found");}
        return null;
    }

    private int entryAddress(K key){
        return key.hashCode() & INITIAL_SIZE;
    }
}