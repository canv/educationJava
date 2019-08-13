package course.Lesson4;

import static packAlternative.AOutput.consoleOut;

class QueueEmptyException extends Exception {
    public String toString(){
        return "\n(!) Queue is empty!";
    }
}

public class DynamicQueue<T>{
    private T[] queueStore;
    private int putInd, extInd;

    DynamicQueue(T[] sortIt) {
        queueStore = sortIt;
        putInd = extInd = 0;
    }

    public void put(T val) {
        if (putInd == queueStore.length - 1)
            queueStore = (T[]) arrExpansionTwice(queueStore);

        putInd++;
        if(putInd == queueStore.length) putInd=0;
        queueStore[putInd] = val;
    }

    public T get() throws QueueEmptyException {
        if (extInd == putInd)
            throw new QueueEmptyException();

        extInd++;
        if (extInd == queueStore.length) extInd=0;
        return queueStore[extInd];
    }

    public Object[] arrExpansionTwice(T[] who) {
        Object[] arrMask = new Object[who.length * 2];
        arrCopy(who,arrMask);
        consoleOut.printf("~Queue has been expanded~");
        return arrMask;
    }

    private static void arrCopy(Object[] copyFrom, Object[] copyHere) {
        for (int i = 0; i < copyFrom.length; i++) {
            copyHere[i] = copyFrom[i];
        }
    }
}