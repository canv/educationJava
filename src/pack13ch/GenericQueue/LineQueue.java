package pack13ch.GenericQueue;

public class LineQueue<T> extends MasterQueue<T> {

    LineQueue(T[] sortIt, String name) {
        super(sortIt, name);
    }

    @Override
    public void put(T val) throws QueueFullException {
        if (getPutInd() == getQArr().length - 1)
            throw new QueueFullException(getQArr().length);

        setPutInd(getPutInd() + 1); //putInd++
        getQArr()[getPutInd()] = val;
    }

    @Override
    public T get() throws QueueEmptyException {
        if (getExtInd() == getPutInd())
            throw new QueueEmptyException();

        setExtInd(getExtInd() + 1); //extInd++
        return getQArr()[getExtInd()];
    }
}