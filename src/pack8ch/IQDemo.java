package pack8ch;
import pack8ch.qpack.*;


public class IQDemo {
    public static void main(String[] args) {

        LineQueue q1 = new LineQueue(10);
        LineQueue qn = new LineQueue(10);
        DynamicQueue q2 = new DynamicQueue(5);
        CircularQueue q3 = new CircularQueue(10);
        DynCirQueue q4 = new DynCirQueue(5);

        q1.filling(0,10);
        q1.extraction(0,10);
        q1.reset();

        q2.filling(0,10);
        q2.extraction(0,10);
        q2.reset();

        q3.filling(0,10);
        q3.extraction(0,10);
        q3.filling(10,20);
        q3.extraction(0,10);

        q3.fillAndExtr(0,20);
        q3.reset();

        q4.filling(0,5);
        q4.extraction(0,5);
        q4.reset();
        q4.filling(5,10);
        q4.extraction(0,5);
        q4.reset();
        q4.filling(0,10);
        q4.extraction(0,10);

        q1.filling(0, 10);
        qn.filling(10, 20);
        MasterQueue.queueCopy(qn, q1);
        q1.extraction(0, 10);
        qn.extraction(0, 10);
    }
}
