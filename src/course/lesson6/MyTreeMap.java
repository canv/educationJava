package course.lesson6;

class MyTreeMap<K,V> {
    private Leaf<K,V> root;
    private int size = 0;

    MyTreeMap(){
        root = new Leaf<>();
    }

    void add(K key, V val){
        Leaf<K, V> newLeaf = new Leaf<>();
        newLeaf.list.addToEnd(key, val);

        if (size == 0) {
            root = newLeaf;
            size++;
            return;
        }

        Leaf<K, V> lastLeaf = findLastLeaf(root, newLeaf);

        if (lastLeaf.compareTo(newLeaf.getKey()) == 0) {
            lastLeaf.list.addToEnd(key, val);
        }
        if (lastLeaf.compareTo(newLeaf.getKey()) < 0) {
            lastLeaf.right = newLeaf;
        }
        if (lastLeaf.compareTo(newLeaf.getKey()) > 0) {
            lastLeaf.left = newLeaf;
        }

        size++;
    }
    private Leaf<K,V> findLastLeaf(Leaf<K,V> oldLeaf, Leaf<K,V> newLeaf) {
        Leaf<K,V> lastLeaf = oldLeaf;
        int compare = oldLeaf.compareTo(newLeaf.getKey());

        if(compare < 0 && oldLeaf.right != null){
            lastLeaf = findLastLeaf(oldLeaf.right, newLeaf);
            return lastLeaf;
        }
        if(compare > 0 && oldLeaf.left != null){
            lastLeaf = findLastLeaf(oldLeaf.left, newLeaf);
            return lastLeaf;
        }
        if(compare == 0) {
            return lastLeaf;
        }

        return lastLeaf;
    }

    V get(K key){
        Leaf<K,V> eLeaf = new Leaf<>();
        eLeaf.list.addToEnd(key, null);
        return search(root,eLeaf).list.getElement(key);
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