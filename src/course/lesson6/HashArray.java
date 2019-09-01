package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class HashArray<K,V> {
    private static final int INITIAL_SIZE = 1_000_000;
    private MyLinkedList[] hashArray = new MyLinkedList[INITIAL_SIZE+1];

    public void put(K key, V val) {
        int hash = entryAddress(key);
       // consoleOut.println("~ key: " + key + " val: " + val + " hash: " + hash);

        if (hashArray[hash] == null) {
          //  System.out.println("0");

            MyLinkedList<K, V> entry = new MyLinkedList<>();
            entry.add(key, val);
            hashArray[hash] = entry;
        } else {
           // consoleOut.println("put's first else");
            if(hashArray[hash].coincidenceCorrection(key,val));
            else {
             //   System.out.println("\tkey - [" + key + "] hashArray[hash].getCurrentKey() [" + (hashArray[hash].getKey()) + "]");
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
//        consoleOut.println("~*~ hash: " + (key.hashCode() & INITIAL_SIZE));
//        consoleOut.println("~~ hash: " + (key.hashCode() * 32));
//        consoleOut.println("~~ hash: " + (key.hashCode()));

        return key.hashCode() & INITIAL_SIZE;
    }
}