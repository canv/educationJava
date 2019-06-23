package pack5ch;

class ShowBits {
    private int numbits;

    ShowBits(int n) {
        numbits = n;
    }

    //не понимаю как работает этот метод! (5.05.19)
    //понял (14.06.19) 22-24 сердце метода

    void show(long val) {
        long mask = 1;

        mask <<= numbits - 1;

        int spacer = 0;
        for (; mask != 0; mask >>>= 1) {

//            System.out.print(">  <mask->("+(Long.toBinaryString(mask))+")" +
//                    "/val->("+(Long.toBinaryString(val))+")" +
//                    "/(val&long)->("+(Long.toBinaryString((val & mask)))+")" +
//                    "/result->");

            if ((val & mask) != 0) System.out.print("1");
            else System.out.print("0");

            spacer++;
            if ((spacer % 4) == 0) {
                System.out.print(" ");
                spacer = 0;
            }
        }
        System.out.println();
    }
}

public class ShowBitsDemo {
    public static void main(String[] args) {
        ShowBits b = new ShowBits(8);
        ShowBits i = new ShowBits(32);
        ShowBits li = new ShowBits(64);

        System.out.println("123 in binary: ");
        b.show(123);

        System.out.println("\n87987 in binary: ");
        i.show(87987);

        System.out.println("\n237658768 in binary: ");
        li.show(237658768);

        System.out.println("\nYounger 8 bits of the number 87987: ");
        b.show(87987);

    }

}
