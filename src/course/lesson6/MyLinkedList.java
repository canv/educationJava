package course.lesson6;

class MyLinkedList<K,V>{
    private Node<K,V> firstNode;
    private Node<K,V> lastNode;
    private int listSize = 0;

    MyLinkedList(){
        lastNode = new Node<>(firstNode,null, null,null);
        firstNode = new Node<>(null,null, null,lastNode);
    }

    void addToEnd(K key, V element) {
        Node<K,V> prev = lastNode;
        prev.setKey(key);
        prev.setCurrentElement(element);
        lastNode = new Node<>(prev,null,null,null);
        prev.setNextElement(lastNode);
        listSize++;
    }

    V getElement(K key) {
        Node<K, V> target = firstNode.getNextElement();
        for (int i = 0; i < listSize; i++) {
            if (target != null && target.currentKey.equals(key)) continue;
            target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    private class Node<K,V>{

        private Node<K,V> prevElement;
        private K currentKey;
        private V currentElement;
        private Node<K,V> nextElement;

        private Node(Node<K,V> prevElement, K currentKey, V currentElement, Node<K,V> nextElement){
            this.prevElement = prevElement;
            this.currentKey = currentKey;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }

        Node<K,V> getPrevElement() {
            return prevElement;
        }
        V getCurrentElement() {
            return currentElement;
        }
        K getKey() {
            return currentKey;
        }
        Node<K,V> getNextElement() {
            return nextElement;
        }

        void setKey(K key) {
            this.currentKey = key;
        }
        void setPrevElement(Node<K,V> prevElement) {
            this.prevElement = prevElement;
        }
        void setCurrentElement(V currentElement) {
            this.currentElement = currentElement;
        }
        void setNextElement(Node<K,V> nextElement) {
            this.nextElement = nextElement;
        }
    }
}