/*
        Урок 13. Лямбда-выражения
          Создайте массив целых чисел, например, из 10 элементов.
          Используя лямбда-выражение, отсортируйте массив по убыванию.
          Выведите массив, используя цикл foreach.
 */

package VideoLessons.ch3;

import java.util.Arrays;

import static packAlternative.AOutput.consoleOut;

public class Lesson13 {

    interface IntNumCompare {
        boolean intCompare(int x, int y);
    }

    private static void bubbleSort(int[] arr, IntNumCompare compOperation) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compOperation.intCompare(arr[i], arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] intTest = {-59, 86, -23, -29, -63, -15, 3, 75, -50, -56};

        consoleOut.println("Origin array:\n" + Arrays.toString(intTest));
        consoleOut.println("\nSorted array:");
        bubbleSort(intTest, ((x, y) -> x > y));
        consoleOut.println(Arrays.toString(intTest));
    }
}