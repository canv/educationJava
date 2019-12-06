public class Testix {

    public static void main(String[] args) {
        Chock chock = new Chock();
        chock.bugsThinking(2147483642, 214748364);
    }
}

class Chock {

    void bugsThinking(int stones, int bugs) {
        if (stones < bugs) return;
        if (stones == bugs)
            System.out.println("All stones are busy");

        boolean[] stonesArr = new boolean[stones + 2];
        stonesArr[0] = true;
        stonesArr[stonesArr.length - 1] = true;

        int tryLeftBound = 0;
        int tryRightBound = 0;
        int currentLeftBound;
        int currentRightBound;
        int bugCounter = 1;
        int putBug;

        do {
            currentLeftBound = currentRightBound = 0;
            for (int i = 1; i < stonesArr.length; i++) {

                if (!stonesArr[i]) {
                    if (tryLeftBound == 0) tryLeftBound = i;
                    tryRightBound = i;

                } else if (tryRightBound - tryLeftBound
                        > currentRightBound - currentLeftBound) {

                    currentLeftBound = tryLeftBound;
                    currentRightBound = tryRightBound;

                    tryLeftBound = 0;
                    tryRightBound = 0;

                } else tryLeftBound = tryRightBound = 0;
            }
            putBug = ((currentRightBound - (currentLeftBound - 1)) / 2) + currentLeftBound;
            stonesArr[putBug] = true;
            bugCounter++;
        } while (bugCounter <= bugs);

        int rightStones = currentRightBound-putBug;
        int leftStones = putBug-currentLeftBound;
        System.out.println(rightStones + ", " + leftStones);
    }
}