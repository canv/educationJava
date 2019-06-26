package pack8ch.qpack;

public class DynamicQueue extends MasterQueue {

    public DynamicQueue(int size) {
        super(size);
    }

    public void put(char ch) {
        if (getPutInd() == getqArr().length - 1)
            setQArr(arrExpansionTwice(getqArr()));


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
        messageList("Dqm1");
        super.extraction(inFrom, to);
    }

    public char[] arrExpansionTwice(char[] who) {
        return super.arrExpansionTwice(who);
    }
}
