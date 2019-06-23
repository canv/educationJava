package pack6ch;

class MyQuicksort {
    static void qsort(char[] items) {
        qs(items, 0, items.length - 1);
    }

    private static void qs(char[] items, int left, int right) {
        int i, j;
        char x, y;

        i = left;
        j = right;
        x = items[(left + right) / 2];

        do {
            while ((items[i] < x) && (i < right)) i++;
            while ((x < items[j]) && (j > left)) j--;

            if (i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++;
                j--;
            }
        } while (i <= j);

        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }
}

public class MyQSDemo {
    public static void main(String[] args) {
        char[] a = {'d', 'x', 'a', 'r', 'p', 'y', 'z', 'o', 'q', 'j', 'i', 'i'};

        System.out.print("Original array: ");
        for (char id : a) System.out.print(id);

        System.out.println();
        MyQuicksort.qsort(a);

        System.out.print("Sorted array: ");
        for (char id : a) System.out.print(id);


    }
}
