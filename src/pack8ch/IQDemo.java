package pack8ch;

abstract class MasterQueue implements CommonQ {
    private char[] qArr;
    private int putInd;
    private int extInd;

    MasterQueue(int size) {
        qArr = new char[size + 1];
        putInd = extInd = 0;
    }

    public abstract void put(char ch);
    public abstract char get();
    public void reset() {
        putInd = extInd = 0;
    }


    void filling(int inFrom, int to) {
        for (int i = inFrom; i < to; i++)
            put((char) ('A' + i));
    }
    void extraction(int inFrom, int to) {
        for (int i = inFrom; i < to; i++) System.out.print(get() + " ");

    }
    void fillAndExtr(int inFrom, int to) {
        messageList("FaEqm1");
        for (int i = inFrom; i < to; i++) {
            put((char) ('A' + i));
            System.out.print(get() + " ");
        }
    }
    char[] arrExpansionTwice(char[] who) {
        char[] arrMask = new char[who.length * 2];
        for (int i = 0; i < who.length; i++)
            arrMask[i] = who[i];

        return arrMask;
    }
    private static char[] arrCopy(char[] copyFrom) {
        char[] copyHere = new char[copyFrom.length];
        for (int i = 0; i < copyFrom.length; i++) {
            copyHere[i] = copyFrom[i];
        }

        return copyHere;
    }
    static void queueCopy(MasterQueue copyFrom, MasterQueue copyHere) {
        copyHere.setQArr(arrCopy(copyFrom.getqArr()));
        System.out.println("The contents of the queue " + copyFrom +
                "copied to the " + copyHere + " queue! ((!) fix it!)");

    }

    void setQArr(char[] qArr) {
        this.qArr = qArr;
    }
    void setPutInd(int putInd) {
        this.putInd = putInd;
    }
    void incrementingPutInd() {
        this.putInd++;
    }
    void setExtInd(int extInd) {
        this.extInd = extInd;
    }
    void incrementingExtInd() {
        this.extInd++;
    }

    char[] getqArr() {
        return qArr;
    }
    int getPutInd() {
        return putInd;
    }
    int getPutInd1() {
        return putInd + 1;
    }
    int getExtInd() {
        return extInd;
    }

    void messageList(String messKey) {
        switch (messKey) {
            case "er01":
                System.out.println(" - Can't save, queue is full");
                break;

            case "er02":
                System.out.println("(!) - Can't continue " +
                        "extract, queue is empty");
                break;

            case "Lqm1":
                System.out.println("\n\nLine queue content: ");
                break;

            case "Dqm1":
                System.out.println("\n\nDynamic queue content: ");
                break;

            case "Dqn1":
                System.out.println("\n\nNotice! \n*The next queue " +
                                "is expanding because data size " +
                                "exceeds queue size*");
                break;

            case "Cqm1":
                System.out.println("\n\nCircular queue content: ");
                break;

            case "DCqm1":
                System.out.println("\n\nThe circular dynamic " +
                        "queue content: ");
                break;

            case "DCqn1":
                System.out.println("\n\nNotice! \n*The next queue " +
                                "is expanding because rewriting " +
                                "is impossible*");
                break;

            case "FaEqm1":
                System.out.println("\n\nPut the characters in a " +
                        "Circular queue and extract them from there: ");
                break;

            default:
                System.out.println("\n\n\tUnknown error, unregistered " +
                        "messKey: '" + messKey + "'!");
        }
    }
}


class LineQueue extends MasterQueue {

    LineQueue(int size) {
        super(size);
    }

    public void put(char ch) {
        if (getPutInd() == getqArr().length - 1) {
            messageList("er01");
            return;
        }

        incrementingPutInd();
        getqArr()[getPutInd()] = ch;
    }

    public char get() {
        if (getExtInd() == getPutInd()) {
            messageList("er02");
            return (char) 0;
        }
        incrementingExtInd();
        return getqArr()[getExtInd()];
    }

    public void reset() {
        super.reset();
    }

    void extraction(int inFrom, int to) {
        messageList("Lqm1");
        super.extraction(inFrom, to);
    }

}


class DynamicQueue extends MasterQueue {

    DynamicQueue(int size) {
        super(size);
    }

    public void put(char ch) {
        if (getPutInd() == getqArr().length - 1)
            setQArr(arrExpansionTwice(getqArr()));


        incrementingPutInd();
        getqArr()[getPutInd()] = ch;
    }

    public char get() {
        if (getExtInd() == getPutInd()) {
            messageList("er02");
            return (char) 0;
        }
        incrementingExtInd();
        return getqArr()[getExtInd()];
    }

    public void reset() {
        super.reset();
    }

    void extraction(int inFrom, int to) {
        messageList("Dqm1");
        super.extraction(inFrom, to);
    }

    char[] arrExpansionTwice(char[] who) {
        return super.arrExpansionTwice(who);
    }
}


class CircularQueue extends MasterQueue {


    CircularQueue(int size) {
        super(size);
    }

    public void put(char ch) {

        if (getPutInd1() == getExtInd()
                | ((getPutInd() == getqArr().length - 1) & (getExtInd() == 0))) {
            messageList("er01");
            return;
        }

        incrementingPutInd();
        if (getPutInd() == getqArr().length) setPutInd(0);
        getqArr()[getPutInd()] = ch;
    }

    public char get() {
        if (getExtInd() == getPutInd()) {
            messageList("er02");
            return (char) 0;
        }
        incrementingExtInd();
        if (getExtInd() == getqArr().length) setExtInd(0);
        return getqArr()[getExtInd()];
    }

    public void reset() {
        super.reset();
    }

    void extraction(int inFrom, int to) {
        messageList("Cqm1");
        super.extraction(inFrom, to);
    }

}


class DynCirQueue extends MasterQueue {

    DynCirQueue(int size) {
        super(size);
    }

    public void put(char ch) {

        if (getPutInd1() == getExtInd()
                | ((getPutInd() == getqArr().length - 1) & (getExtInd() == 0))) {
            setQArr(arrExpansionTwice(getqArr()));
        }

        incrementingPutInd();
        if (getPutInd() == getqArr().length) setPutInd(0);
        getqArr()[getPutInd()] = ch;
    }

    public char get() {
        if (getExtInd() == getPutInd()) {
            messageList("er02");
            return (char) 0;
        }
        incrementingExtInd();
        if (getExtInd() == getqArr().length) setExtInd(0);
        return getqArr()[getExtInd()];
    }

    public void reset() {
        super.reset();
    }

    char[] arrExpansionTwice(char[] who) {
        return super.arrExpansionTwice(who);
    }

    void filling(int inFrom, int to) {
        if (to > getqArr().length & inFrom > 0) messageList("Dqn1");
        if (to > getqArr().length & inFrom == 0) messageList("DCqn1");
        super.filling(inFrom, to);
    }

    void extraction(int inFrom, int to) {
        messageList("DCqm1");
        super.extraction(inFrom, to);
    }
}


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
