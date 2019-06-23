package pack5ch;

public class TwoD {
    public static void main(String[] args) {
        int str, col;
        int strVal = 5;
        int colVal = 4;

        int table[][] = new int[strVal][colVal];

        for (str = 0; str < strVal; str++) {
            for (col = 0; col < colVal; col++) {
                table[str][col] = (str * colVal) + col + 1;

                System.out.print(table[str][col] + "\t");
            }
            System.out.println();
        }
    }
}
