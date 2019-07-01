package pack9ch.QueueException;

public abstract class MasterQueue implements ICharQ {
    private char[] qArr;
    private int putInd;
    private int extInd;

    MasterQueue(int size) {
        qArr = new char[size + 1];
        putInd = extInd = 0;
    }

    public abstract void put(char ch) throws QueueFullException;
    public abstract char get() throws QueueEmptyException;
    public void reset() {
        putInd = extInd = 0;
    }


    public void filling(int inFrom, int to) throws QueueFullException {
        for (int i = inFrom; i < to; i++)
            put((char) ('A' + i));
    }
    public void extraction(int inFrom, int to) throws QueueEmptyException {
        for (int i = inFrom; i < to; i++) System.out.print(get() + " ");

    }
    public void fillAndExtr(int inFrom, int to) throws QueueFullException, QueueEmptyException {
        messageList("FaEqm1");
        for (int i = inFrom; i < to; i++) {
            put((char) ('A' + i));
            System.out.print(get() + " ");
        }
    }
    public char[] arrExpansionTwice(char[] who) {
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
    public static void queueCopy(MasterQueue copyFrom, MasterQueue copyHere) {
        copyHere.setQArr(arrCopy(copyFrom.getqArr()));
        System.out.println("\n\nThe contents of the queue qn copied to the q1 queue!");
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
