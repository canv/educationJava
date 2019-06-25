package pack8ch;

class ByTwos implements Series {

    private int start, val, prev;

    ByTwos() {
        start = 0;
        val = 0;
        prev = -2;
    }

    @Override
    public int getNext() {
        prev = val;
        val += 2;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
        prev = -2;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
        prev = x-2;

    }

    int getPrevious(){
        return prev;
    }

}

class ByThrees implements Series {

    private int start, val, prev;

    ByThrees() {
        start = 0;
        val = 0;
        prev = -3;
    }

    @Override
    public int getNext() {
        prev = val;
        val += 3;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
        prev = -3;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
        prev = x-3;

    }

    int getPrevious(){
        return prev;
    }
}

public class SeriesDemo {
    public static void main(String[] args) {

        ByTwos twoOb = new ByTwos();
        ByThrees threeOb = new ByThrees();
        Series ob;

        for (int i = 0; i < 5; i++) {
            ob = twoOb;
            System.out.println("ByTwos next value: " + ob.getNext());
            ob = threeOb;
            System.out.println("ByThree next value: " + ob.getNext());
        }
//        !does not work properly, will fix after sleep!

//        ob = twoOb;
//        System.out.println("\n\nDemo of method getNextArray for twoOb: ");
//
//        for (int arID = 0; arID < ob.getNextArray(5).length; arID++) {
//            int x;
//            x = ob.getNextArray(5)[arID];
//            System.out.print(x + " ");
//        }
    }
}
