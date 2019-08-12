package course.lesson3;

class MyLinkedList<L> {
    private Node<L> firstNode;
    private Node<L> lastNode;


    MyLinkedList(){
        lastNode = new Node<>(firstNode,null,null);
        firstNode = new Node<>(null,null,lastNode);
    }

    void addElement(L element) {
        Node<L> prev = lastNode;
        prev.setCurrentElement(element);
        lastNode = new Node<>(prev,null,null);
        prev.setNextElement(lastNode);
    }

    L getElement(int index){
        Node<L> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = target.getNextElement();
        }
        return target.getCurrentElement();
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
