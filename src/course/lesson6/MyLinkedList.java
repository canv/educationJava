package course.lesson6;

class MyLinkedList<K,V> implements MyList<K,V>{
    private Node<K,V> firstNode;
    private Node<K,V> lastNode;

    MyLinkedList(){
        lastNode = new Node<>(firstNode,null, null,null);
        firstNode = new Node<>(null,null, null,lastNode);
    }

    @Override
    public void addToEnd(K key, V element) {
        Node<K,V> prev = lastNode;
        prev.setKey(key);
        prev.setCurrentValue(element);
        lastNode = new Node<>(prev,null,null,null);
        prev.setNextNode(lastNode);
    }

    @Override
    public V getValue(K key) {
        Node<K, V> target = firstNode;
        do{
            target = target.getNextNode();
        }while (target != lastNode && !target.currentKey.equals(key));
        return target.getCurrentValue();
    }

    K getKey() {
        return lastNode.prevNode.getKey();
    }

    V getLastNodeCurrentValue() {
        return lastNode.getCurrentValue();
    }

    private class Node<K,V>{

        private Node<K,V> prevNode;
        private K currentKey;
        private V currentValue;
        private Node<K,V> nextNode;

        private Node(Node<K,V> prevNode, K currentKey, V currentValue, Node<K,V> nextNode){
            this.prevNode = prevNode;
            this.currentKey = currentKey;
            this.currentValue = currentValue;
            this.nextNode = nextNode;
        }

        Node<K,V> getPrevNode() {
            return prevNode;
        }
        V getCurrentValue() {
            return currentValue;
        }
        K getKey() {
            return currentKey;
        }
        Node<K,V> getNextNode() {
            return nextNode;
        }

        void setKey(K key) {
            this.currentKey = key;
        }
        void setPrevNode(Node<K,V> prevNode) {
            this.prevNode = prevNode;
        }
        void setCurrentValue(V currentValue) {
            this.currentValue = currentValue;
        }
        void setNextNode(Node<K,V> nextNode) {
            this.nextNode = nextNode;
        }
    }
}