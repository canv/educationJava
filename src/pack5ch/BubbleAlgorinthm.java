package pack5ch;

public class BubbleAlgorinthm {
    public static void main(String[] args) {
        int[] num = {99, -10, 100123, 18,
                -978, 5623, 463, -9, 287, 49};

        int actualIndex, sortIndex, temporaryValue;
        int arraySize = 10;

        System.out.print("Initial array: ");

        for (int i = 0; i < arraySize; i++)
            System.out.print(" " + num[i]);
        System.out.println(" ");

        for (actualIndex = 1;
             actualIndex < arraySize;
             actualIndex++) {

            for (sortIndex = arraySize - 1;
                 sortIndex >= actualIndex;
                 sortIndex--) {

                if (num[sortIndex - 1] > num[sortIndex]) {

                    temporaryValue = num[sortIndex - 1];
                    num[sortIndex - 1] = num[sortIndex];
                    num[sortIndex] = temporaryValue;
                }
            }
        }

        System.out.print("Sorted array: ");
        for (int i = 0; i < arraySize; i++)
            System.out.print(" " + num[i]);
        System.out.println(" ");
    }
}
