package course.lesson6;

interface MyList<K, V> {

    void add(K key, V element);
    boolean coincidenceCorrection(K key, V element);
    V get(K key);
}
