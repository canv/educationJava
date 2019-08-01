package pack13ch.GenericQueue;

public class DynamicQueue<T> extends MasterQueue<T> {
    DynamicQueue(T[] sortIt, String name) {
        super(sortIt, name);
    }

    @Override
    public void put(T val) {
        if (getPutInd() == getQArr().length - 1)
            setQArr((T[]) arrExpansionTwice(getQArr()));

        setPutInd(getPutInd() + 1); //putInd++
        if(getPutInd() == getQArr().length) setPutInd(0);
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

    public Object[] arrExpansionTwice(T[] who) {
        Object[] arrMask = new Object[who.length * 2];
        for (int i = 0; i < who.length; i++)
            arrMask[i] = who[i];

        return arrMask;
    }
}