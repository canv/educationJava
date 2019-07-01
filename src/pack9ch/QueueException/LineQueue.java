package pack9ch.QueueException;

public class LineQueue extends MasterQueue {

    public LineQueue(int size) {
        super(size);
    }

    public void put(char ch)
            throws QueueFullException {


        if (getPutInd() == getqArr().length - 1) {
            throw new QueueFullException(getqArr().length - 1);
//            messageList("er01");
//            return;
        }

        incrementingPutInd();
        getqArr()[getPutInd()] = ch;
    }

    public char get() throws QueueEmptyException{
        if (getExtInd() == getPutInd()) {
            throw new QueueEmptyException();
//            messageList("er02");
//            return (char) 0;
        }
        incrementingExtInd();
        return getqArr()[getExtInd()];
    }

    public void reset() {
        super.reset();
    }

    public void extraction(int inFrom, int to) throws QueueEmptyException {
        messageList("Lqm1");
        super.extraction(inFrom, to);
    }

}
