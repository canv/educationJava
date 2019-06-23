package VideoLessons.ch2;

public class Lesson13 {
    public static void main(String[] args) {
//        int[][] table = new int[9][9];
//
//        for (int i = 0; i < table.length; i++) {
//            for (int j = 0; j < table.length; j++)
//                table[i][j] = (i + 1) * (j + 1);
//        }
//        System.out.println("   1  2  3  4  5  6  7  8  9");
//        for (int i = 0; i < table.length; i++) {
//            System.out.print((i + 1) + " ");
//            for (int j = 0; j < table.length; j++) {
//                if (table[i][j] < 10) System.out.print(" ");
//                System.out.print(table[i][j] + " ");
//            }
//            System.out.println();
//        }
        int[][] one = {
                {2, 1},
                {3, 11, 102}};
        int[] two = new int[2];
        int sumArr = 0;

        for (int i = 0; i < one.length; i++) {
            two[0] += one[0][i];
            for (int j = 0; j < one[i].length; j++) {
                sumArr += one[i][j];
            }
        }
        System.out.println(sumArr);

        for (int i = 0; i < one.length; i++)
            two[0] += one[0][i];
        for (int j = 0; j < one[1].length; j++)
            two[1] += one[1][j];

        System.out.println(two[0] + ", " + two[1]);
    }
}
