package pack5ch;

public class Ragget {
    public static void main(String[] args) {

        int riders[][] = new int[7][];
        riders[0] = new int[10];
        riders[1] = new int[10];
        riders[2] = new int[10];
        riders[3] = new int[10];
        riders[4] = new int[10];
        riders[5] = new int[2];
        riders[6] = new int[2];

        int str, col;

        for (str = 0; str < 5; str++)
            for (col = 0; col < 10; col++)
                riders[str][col] = str + col + 10;

        for (str = 5; str < 7; str++)
            for (col = 0; col < 2; col++)
                riders[str][col] = str + col + 10;

        System.out.println("Quantity of passengers transported by each\n" +
                "by flight, on WEEKDAYS:");

        for (str = 0; str < 5; str++) {
            for (col = 0; col < 10; col++)
                System.out.print(riders[str][col] + " ");
            System.out.println();
        }

        System.out.println();


        System.out.println("Quantity of passengers transported by each\n" +
                "by flight, on WEEKENDS:");


        for (str = 5; str < 7; str++) {
            for (col = 0; col < 2; col++)
            System.out.print(riders[str][col] + " ");
            System.out.println();
        }
    }
}
