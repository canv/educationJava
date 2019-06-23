package pack6ch;

class QueueS {
    private char[] arrQ;
    private int putIndex, getIndex;

    QueueS(int size) {
        arrQ = new char[size + 1];
        putIndex = getIndex = 0;
    }

    QueueS(QueueS object) {
        putIndex = object.putIndex;
        getIndex = object.getIndex;
        arrQ = new char[object.arrQ.length];

        for (int i = getIndex + 1; i <= putIndex; i++)
            arrQ[i] = object.arrQ[i];
    }

    QueueS(char[] queueIn) {
        putIndex = getIndex = 0;
        arrQ = new char[queueIn.length + 1];

        for (int i = 0; i < queueIn.length; i++)
            putValue(queueIn[i]);
    }

    void putValue(char ch) {
        if (putIndex == arrQ.length - 1) {
            System.out.println(" - Can't save, queue is full");
            return;
        }
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
}

public class OverLoadQueue {
    public static void main(String[] args) {

        char value;
        int id;


        QueueS arrOne = new QueueS(26);

        System.out.println("\nUsing queue 'arrOne' for safe ABC");
        for (id = 0; id < 26; id++)
            arrOne.putValue((char) ('A' + id));

        QueueS arrThree = new QueueS(arrOne);

        System.out.print("arrOne's content:\n");
        for (id = 0; id < 26; id++) {
            value = arrOne.getValue();
            System.out.print(value);
        }

        char[] objectTom = {'T', 'o', 'm'};
        QueueS arrTwo = new QueueS(objectTom);

        System.out.println("\n");
        System.out.print("arrTwo's content:\n");
        for (id = 0; id < 3; id++) {
            value = arrTwo.getValue();
            System.out.print(value);
        }



        System.out.println("\n");
        System.out.print("arrThree's content:\n");
        for (id = 0; id < 26; id++) {
            value = arrThree.getValue();
            System.out.print(value);
        }
        System.out.println();
    }
}

