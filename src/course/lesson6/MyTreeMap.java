package course.lesson6;

class MyTreeMap<K,V> implements MyMap<K,V> {
    private Leaf<K,V> root;
    private int size = 0;

    MyTreeMap(){
        root = new Leaf<>();
    }

    @Override
    public void put(K key, V val){
        Leaf<K, V> newLeaf = new Leaf<>();
        newLeaf.listLeaf.add(key, val);

        if (size == 0) {
            root = newLeaf;
            size++;
            return;
        }

        Leaf<K, V> lastLeaf = leafSearch(newLeaf);
        int newLeafKeyHashCode = newLeaf.getKey().hashCode();
        int lastLeafKeyHashCode = lastLeaf.getKey().hashCode();

        if (lastLeafKeyHashCode < newLeafKeyHashCode) {
            lastLeaf.rightLeaf = newLeaf;
        }
        if (lastLeafKeyHashCode > newLeafKeyHashCode) {
            lastLeaf.leftLeaf = newLeaf;
        }
        if (lastLeafKeyHashCode == newLeafKeyHashCode) {
            if(lastLeaf.getKey().equals(newLeaf.getKey()))
            lastLeaf.listLeaf.coincidenceCorrection(key, val);
            else lastLeaf.listLeaf.add(key, val);
        }

        size++;
    }

    @Override
    public V get(K key){
        Leaf<K,V> eLeaf = new Leaf<>();
        eLeaf.listLeaf.add(key, null);
        Leaf<K, V> lastLeaf = leafSearch(eLeaf);

        return lastLeaf.listLeaf.get(key);
    }

    private Leaf<K,V> leafSearch(Leaf<K, V> wantedLeaf){

        Leaf<K, V> lastLeaf = root;

        int wantedLeafKeyHashCode = wantedLeaf.getKey().hashCode();
        int lastLeafKeyHashCode;

        while (true){
            lastLeafKeyHashCode = lastLeaf.getKey().hashCode();
            if(lastLeafKeyHashCode < wantedLeafKeyHashCode && lastLeaf.rightLeaf != null){
                lastLeaf = lastLeaf.rightLeaf;
                continue;
            }
            if(lastLeafKeyHashCode > wantedLeafKeyHashCode && lastLeaf.leftLeaf != null){
                lastLeaf = lastLeaf.leftLeaf;
                continue;
            }
            if(lastLeafKeyHashCode == wantedLeafKeyHashCode) {
                return lastLeaf;
            }
            return lastLeaf;
        }
    }


    class Leaf<K,V>{
        private Leaf<K,V> rightLeaf;
        private Leaf<K,V> leftLeaf;
        private MyLinkedList<K,V> listLeaf;

        Leaf() {
            listLeaf = new MyLinkedList<>();
        }

        private K getKey() {
            return listLeaf.getKey();
        }

        @Override
        public String toString() {
            return "TreeMap: " + listLeaf.getLastNodeCurrentValue() + "";
        }
    }
}