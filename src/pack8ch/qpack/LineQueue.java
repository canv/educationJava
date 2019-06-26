package pack8ch.qpack;

public class LineQueue extends MasterQueue {

    public LineQueue(int size) {
        super(size);
    }

    public void put(char ch) {
        if (getPutInd() == getqArr().length - 1) {
            messageList("er01");
            return;
        }

        incrementingPutInd();
        getqArr()[getPutInd()] = ch;
    }

    public char get() {
        if (getExtInd() == getPutInd()) {
            messageList("er02");
            return (char) 0;
        }
        incrementingExtInd();
        return getqArr()[getExtInd()];
    }

    public void reset() {
        super.reset();
    }

    public void extraction(int inFrom, int to) {
        messageList("Lqm1");
        super.extraction(inFrom, to);
    }

}
