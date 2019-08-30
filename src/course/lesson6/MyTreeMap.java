package course.lesson6;

class MyTreeMap<K,V> implements MyMap<K,V> {
    private Leaf<K,V> root;
    private int size = 0;

    MyTreeMap(){
        root = new Leaf<>();
    }

    @Override
    public void add(K key, V val){
        Leaf<K, V> newLeaf = new Leaf<>();
        newLeaf.list.addToEnd(key, val);

        if (size == 0) {
            root = newLeaf;
            size++;
            return;
        }

        Leaf<K, V> lastLeaf = findLastLeaf(newLeaf,key,val);

//        if (lastLeaf.compareTo(newLeaf.getKey()) == 0) {
//            lastLeaf.list.addToEnd(key, val);
//        }
        if (lastLeaf.compareTo(newLeaf.getKey()) < 0) {
            lastLeaf.right = newLeaf;
        }
        if (lastLeaf.compareTo(newLeaf.getKey()) > 0) {
            lastLeaf.left = newLeaf;
        }

        size++;
    }
    private Leaf<K,V> findLastLeaf(Leaf<K,V> newLeaf,K key, V val) {
        Leaf<K,V> lastLeaf = root;
        int lastElementHashKey;
        int wantedElementHashKey = newLeaf.getKey().hashCode();
        do {
            lastElementHashKey = lastLeaf.getKey().hashCode();

            if (lastElementHashKey < wantedElementHashKey && lastLeaf.right != null){
                lastLeaf=lastLeaf.right;
                continue;
            }
            if (lastElementHashKey > wantedElementHashKey && lastLeaf.left != null){
                lastLeaf=lastLeaf.left;
                continue;
            }
            if (lastElementHashKey == wantedElementHashKey){
                lastLeaf.list.addToEnd(key, val);
                return lastLeaf;
            }

            return lastLeaf;

        }while (true);
    }

    @Override
    public V get(K key){
        Leaf<K,V> eLeaf = new Leaf<>();
        eLeaf.list.addToEnd(key, null);
        return search(root,eLeaf).list.getValue(key);
    }
    private Leaf<K,V> search(Leaf<K, V> leaf, Leaf<K, V> eLeaf){
        int compare = leaf.compareTo(eLeaf.getKey());

        if(compare < 0 && leaf.right != null){
            return search(leaf.right,eLeaf);}
        if(compare > 0 && leaf.left != null)
            return search(leaf.left,eLeaf);
        if(compare == 0) {
            return leaf;
        }

        return null;
    }


    class Leaf<K,V> implements Comparable<K>{
        private Leaf<K,V> right;
        private Leaf<K,V> left;
        private MyLinkedList<K,V> list;


        Leaf() {
            list = new MyLinkedList<>();
        }

        private K getKey() {
            return list.getKey();
        }

        @Override
        public int compareTo(K key) {
            return this.getKey().hashCode() - key.hashCode();
        }

//        @Override
//        public int hashCode() {
//            return key.hashCode() * 32 & Integer.MAX_VALUE;
//        }

        @Override
        public String toString() {
            return "TreeMap: " + list.getLastNodeCurrentElement() + "";
        }
    }
}