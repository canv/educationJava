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

    void filling(int inFrom, int to) {
        for (int i = inFrom; i < to; i++)
            put((char) ('A' + i));
    }
    void extraction(int inFrom, int to) {
        for (int i = inFrom; i < to; i++) System.out.print(get() + " ");

    }
    void fillAndExtr (int inFrom, int to) {
        for (int i = inFrom; i < to; i++){
            put((char) ('A' + i));
            System.out.print(get() + " ");
        }
    }

    void setqArr(char[] qArr) {
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
        return putInd+1;
    }
    int getExtInd() {
        return extInd;
    }

}


class LineQueue extends MasterQueue {

    LineQueue(int size){
        super(size);
    }

    public void put(char ch) {

        if (getPutInd() == getqArr().length - 1) {
            fullQError();
            return;
        }

        incrementingPutInd();
        getqArr()[getPutInd()]=ch;
    }
    public char get() {
        if (getExtInd() == getPutInd()) {
            emptyQError();
            return (char) 0;
        }
        incrementingExtInd();
        return getqArr()[getExtInd()];
    }

    void extraction(int inFrom, int to){
        System.out.println("\n\nLines queue content: ");
        super.extraction(inFrom,to);
    }

}


class DynamicQueue extends MasterQueue{

    DynamicQueue (int size) {
        super(size);
    }

    public void put(char ch){
        if (getPutInd() == getqArr().length - 1) {
            setqArr(arrExtantionTwice(getqArr()));
        }

        incrementingPutInd();
        getqArr()[getPutInd()]=ch;
    }
    public char get() {
        if (getExtInd() == getPutInd()) {
            emptyQError();
            return (char) 0;
        }
        incrementingExtInd();
        return getqArr()[getExtInd()];
    }

    void extraction(int inFrom, int to){
        System.out.println("\n\nDynamics queue content: ");
        super.extraction(inFrom,to);
    }

    private char[] arrExtantionTwice (char[] who) {
        char[] arrMask = new char[who.length*2];
        for (int i = 0; i < who.length; i++)
            arrMask[i] = who[i];

        return arrMask;
    }
}


class CircularQueue extends MasterQueue{


    CircularQueue(int size) {
        super(size);
    }

    public void put(char ch) {

        if (getPutInd1() == getExtInd()
                | ((getPutInd() == getqArr().length - 1) & (getExtInd() == 0))) {
            fullQError();
            return;
        }

        incrementingPutInd();
//        putInd++;
//        System.out.println("~" + putInd);
        if (getPutInd() == getqArr().length) setPutInd(0);
//        if(putInd==qArr.length) putInd=0;
//        System.out.println("<" + qArr.length + ">");
        getqArr()[getPutInd()]=ch;
//        qArr[putInd] = ch;
    }
    public char get() {
        if (getExtInd() == getPutInd()) {
            emptyQError();
            return (char) 0;
        }
        incrementingExtInd();
        if (getExtInd() == getqArr().length) setExtInd(0);
        return getqArr()[getExtInd()];
    }

    void extraction(int inFrom, int to){
        System.out.println("\n\nCirculars queue content: ");
        super.extraction(inFrom,to);
    }

}


public class IQDemo {
    public static void main(String[] args) {

        LineQueue q1 = new LineQueue(10);
        DynamicQueue q2 = new DynamicQueue(5);
        CircularQueue q3 = new CircularQueue(10);

        q1.filling(0,10);
        q1.extraction(0,10);

        q2.filling(0,10);
        q2.extraction(0,10);

        q3.filling(0,10);
        q3.extraction(0,10);
        q3.filling(10,20);
        q3.extraction(0,10);

        q3.fillAndExtr(0,20);
    }
}
