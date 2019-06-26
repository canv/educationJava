package pack8ch.qpack;

public class DynCirQueue extends MasterQueue {

    public DynCirQueue(int size) {
        super(size);
    }

    public void put(char ch) {

        if (getPutInd1() == getExtInd()
                | ((getPutInd() == getqArr().length - 1) & (getExtInd() == 0))) {
            setQArr(arrExpansionTwice(getqArr()));
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

    public char[] arrExpansionTwice(char[] who) {
        return super.arrExpansionTwice(who);
    }

    public void filling(int inFrom, int to) {
        if (to > getqArr().length & inFrom > 0) messageList("Dqn1");
        if (to > getqArr().length & inFrom == 0) messageList("DCqn1");
        super.filling(inFrom, to);
    }

    public void extraction(int inFrom, int to) {
        messageList("DCqm1");
        super.extraction(inFrom, to);
    }
}
