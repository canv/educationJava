package course.lesson6;

interface MyList<K, V> {

    void addToEnd(K key, V element);
    V getValue(K key);
}
