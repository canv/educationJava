package pack13ch.GenericQueue;

import static packAlternative.AOutput.consoleOut;

public class DynCirQueue<T> extends MasterQueue<T> {
    DynCirQueue(T[] sortIt, String name) {
        super(sortIt, name);
    }

    @Override
    public void put(T val) {

        if ((getPutInd() + 1) == getExtInd()
                | ((getPutInd() == getQArr().length - 1) & (getExtInd() == 0))) {
            setQArr((T[]) arrExpansionTwice(getQArr()));
        }

        setPutInd(getPutInd() + 1); //putInd++
        if (getPutInd() == getQArr().length) setPutInd(0);
        getQArr()[getPutInd()] = val;

    }

    @Override
    public T get() throws QueueEmptyException {
        if (getExtInd() == getPutInd())
            throw new QueueEmptyException();

        setExtInd(getExtInd() + 1); //extInd++
        if (getExtInd() == getQArr().length) setExtInd(0);
        return getQArr()[getExtInd()];
    }

    void circularPropertyDemo(T[] inputData) throws QueueEmptyException {
        consoleOut.println("\nCircular function demo:");
        for (T inputDatum : inputData) {
            put(inputDatum);
            consoleOut.printf(get() + " ");
        }
    }
}