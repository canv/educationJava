package pack6ch;

class QuickSort {
    static void sort(char[] items) {
        qs(items, 0, items.length - 1);
    }

    private static void qs(char[] items, int left, int right) {
        int leftPointer, rightPointer;
        char middle, exchange;

        leftPointer = left;
        rightPointer = right;
        middle = items[(left + right) / 2];

        do {
            while ((items[leftPointer] < middle) && (leftPointer < right))
                leftPointer++;
            while ((middle < items[rightPointer]) && (rightPointer > left))
                rightPointer--;

            if (leftPointer <= rightPointer) {
                exchange = items[leftPointer];
                items[leftPointer] = items[rightPointer];
                items[rightPointer] = exchange;
                leftPointer++;
                rightPointer--;
            }
        } while (leftPointer <= rightPointer);

        if (left < rightPointer) qs(items, left, rightPointer);
        if (leftPointer < right) qs(items, leftPointer, right);
    }
}

public class QSDemo {
    public static void main(String[] args) {
        char[] a = {'d', 'x', 'a', 'r', 'p', 'y', 'z', 'o', 'q', 'j', 'i', 'i'};
        int i;

        System.out.print("Исходный массив: ");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();

        QuickSort.sort(a);

        System.out.print("Отсортированный массив: ");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
