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
    public void reset() {
        putInd = extInd = 0;
    }

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

    void setQArr(T[] qArr) {
        this.queueStore = qArr;
    }
    void setPutInd(int putInd) {
        this.putInd = putInd;
    }
    void setExtInd(int extInd) {
        this.extInd = extInd;
    }

    T[] getQArr() {
        return queueStore;
    }
    int getPutInd() {
        return putInd;
    }
    int getExtInd() {
        return extInd;
    }
}