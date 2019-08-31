package course.lesson6;

interface MyList<K, V> {

    void add(K key, V element);
    void overwrite(K key, V element);
    V get(K key);
}
