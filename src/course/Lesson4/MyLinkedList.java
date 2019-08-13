package course.Lesson4;

import java.util.Iterator;

class MyLinkedList<L> implements Iterable<L>{
    private Node<L> firstNode;
    private Node<L> lastNode;
    private int size = 0;


    MyLinkedList(){
        lastNode = new Node<>(firstNode,null,null);
        firstNode = new Node<>(null,null,lastNode);
    }

    void addToEnd(L element) {
        Node<L> prev = lastNode;
        prev.setCurrentElement(element);
        lastNode = new Node<>(prev,null,null);
        prev.setNextElement(lastNode);
        size++;
    }

    void addToFirst(L element) {
        Node<L> next = firstNode;
        next.setCurrentElement(element);
        firstNode = new Node<>(null,null,next);
        next.setPrevElement(firstNode);
        size++;
    }

    L getElement(int index){
        Node<L> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = target.getNextElement();
        }
        return target.getCurrentElement();
    }

    @Override
    public Iterator<L> iterator() {
        return new Iterator<L>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter<size;
            }

            @Override
            public L next() {
                return getElement(counter++);
            }
        };
    }


    private class Node<L>{

        private Node<L> prevElement;
        private L currentElement;
        private Node<L> nextElement;
        private Node(Node<L> prevElement, L currentElement, Node<L> nextElement){
            this.prevElement = prevElement;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }

        Node<L> getPrevElement() {
            return prevElement;
        }

        L getCurrentElement() {
            return currentElement;
        }
        Node<L> getNextElement() {
            return nextElement;
        }
        void setPrevElement(Node<L> prevElement) {
            this.prevElement = prevElement;
        }
        void setCurrentElement(L currentElement) {
            this.currentElement = currentElement;
        }
        void setNextElement(Node<L> nextElement) {
            this.nextElement = nextElement;
        }
    }
}