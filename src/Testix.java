public class Testix {

    public static void main(String[] args) {
        Chock chock = new Chock();
        chock.calc(4, 1);
    }
}

class Chock {
    void calc(int stones, long bugs) {
        if (stones <= bugs) return;
        long[] stonesArr = new long[stones];
        long nicePlace = stonesArr.length;
        long bugCounter = 1;

        long writeSpace = stonesArr.length % 2;
        long leftSpace = stonesArr.length - writeSpace;

        for (int i = 0; i < stonesArr.length; i++) {


        }

    }

    static void qsort(int[] items) {
        qs(items, 0, items.length - 1);
    }

    private static void qs(int[] items, int left, int right) {

        int i = left;
        int j = right;
        int pivot, TEMP;

        pivot = items[(left + right) / 2];

        do {

            while ((items[i] < pivot) && (i < right)) i++;
            while ((pivot < items[j] && (j > left))) j--;

            if (i <= j) {
                TEMP = items[i];
                items[i] = items[j];
                items[j] = TEMP;
                i++;
                j--;
            }

        } while (i <= j);

        if (left < j)
            qs(items, left, j);
        if (i < right)
            qs(items, i, right);
    }
}