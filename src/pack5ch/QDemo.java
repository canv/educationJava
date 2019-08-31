package pack5ch;

class Queue {
    private char[] arrQ;
    private int putIndex, getIndex;

    Queue(int size) {
        arrQ = new char[size + 1];
        putIndex = getIndex = 0;
    }

    void putValue(char ch) {
        if (putIndex == arrQ.length - 1) {
            System.out.println(" - Can't save, queue is full");
            return;
        }
        System.out.println("<"+putIndex+">");
        putIndex++;

        arrQ[putIndex] = ch;

    }

    char getValue() {
        if (getIndex == putIndex) {
            System.out.println("(!) - Can't continue extract, queue is empty");
            return (char) 0;
        }
        getIndex++;
        return arrQ[getIndex];
    }
    void showArrQTest(){
        for (char x:arrQ) System.out.print(x);
    }
}

public class QDemo {
    public static void main(String[] args) {
        Queue bigQ = new Queue(10);
        Queue smallQ = new Queue(4);

        char value;
        int id;

        System.out.println("Using queue 'bigQ' for safe ABC");
        for (id = 0; id < 10; id++)
            bigQ.putValue((char) ('A' + id));

        System.out.println("bigQ's content: ");
        for (id = 0; id < 10; id++) {
            value = bigQ.getValue();
            if (value != (char) 0) System.out.print(value);
        }
        System.out.println("\n\n");
        bigQ.showArrQTest();

//        System.out.println("\n");
//
//        System.out.println("Using queue 'smallQ' for generation errors");
//        for (id = 0; id < 5; id++) {
//            System.out.print("Try to save " + (char) ('Z' - id));
//            smallQ.putValue((char) ('Z' - id));
//            System.out.println();
//        }
//        System.out.println();
//
//        System.out.println("smallQ's content: ");
//        for (id = 0; id < 5; id++) {
//            value = smallQ.get();
//            if (value != (char) 0) System.out.print(value);
//        }
    }
}
