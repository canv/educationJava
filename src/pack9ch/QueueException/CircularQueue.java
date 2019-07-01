package pack9ch.QueueException;


public class CircularQueue extends MasterQueue {


    public CircularQueue(int size) {
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

    public void extraction(int inFrom, int to) throws QueueEmptyException {
        messageList("Cqm1");
        super.extraction(inFrom, to);
    }

}
