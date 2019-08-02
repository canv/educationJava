package pack13ch.GenericQueue;

import static packAlternative.AOutput.consoleOut;

public abstract class MasterQueue<T> implements IGenQ<T> {
    private T[] queueStore;
    private int putInd, extInd;
    private String nameQueue;

    MasterQueue(T[] sortIt, String name) {
        nameQueue = name;
        queueStore = sortIt;
        putInd = extInd = 0;
    }

    public abstract void put(T val) throws QueueFullException;
    public abstract T get() throws QueueEmptyException;
    public void reset() {putInd = extInd = 0;}

    private void filling(T[] fillIt) throws QueueFullException {
        for (T t : fillIt) put(t);
    }
    public void extraction() throws QueueEmptyException {
        for (int i = 0; i < queueStore.length - 1; i++) consoleOut.printf(get() + " ");

    }
    void operation(T[] inputData) throws QueueFullException, QueueEmptyException {
        filling(inputData);
        consoleOut.println("\n\n" + nameQueue + " content:");
        extraction();
    }

    public Object[] arrExpansionTwice(T[] who) {
        Object[] arrMask = new Object[who.length * 2];
        arrCopy(who,arrMask);
        return arrMask;
    }
    private static void arrCopy(Object[] copyFrom, Object[] copyHere) {
//      System.arraycopy(copyFrom, 0, copyHere, 0, copyFrom.length);
        for (int i = 0; i < copyFrom.length; i++) {
            copyHere[i] = copyFrom[i];
        }
    }

    void setQArr(T[] qArr) {this.queueStore = qArr;}
    void setPutInd(int putInd) {this.putInd = putInd;}
    void setExtInd(int extInd) {this.extInd = extInd;}

    T[] getQArr() {return queueStore;}
    int getPutInd() {return putInd;}
    int getExtInd() {return extInd;}
}