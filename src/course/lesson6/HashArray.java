package course.lesson6;

import static packAlternative.AOutput.consoleOut;

public class HashArray<K,V> {
    private static final int SIZE = 1_000_000;
    private MyLinkedList[] hashArray = new MyLinkedList[SIZE];

    public void put(K key, V val) {
        int hash = key.hashCode() * 32 & SIZE;
        consoleOut.println("h ~ "+hash);

        if (hashArray[hash] == null) {
            MyLinkedList<K, V> entry = new MyLinkedList<>();
            entry.addToEnd(key, val);
            hashArray[hash] = entry;
        } else {
            hashArray[hash].addToEnd(key, val);
        }
    }

    public String get(K key) {
        int hash = key.hashCode()* 32 & SIZE;
        MyLinkedList extract = hashArray[hash];
        try {
            return (String) extract.getElement(key);
        }catch (NullPointerException exc)
        {consoleOut.println("Key \"" + key + "\" not found");}
        return null;
    }

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
}