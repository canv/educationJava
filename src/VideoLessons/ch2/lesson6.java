package VideoLessons.ch2;

public class lesson6 {
    public static void main(String[] args) {
        int one = 5, two = 10;

        System.out.println("Binar " + one + " = " + Integer.toBinaryString(one) +
                "\nBinar " + two + " = " + Integer.toBinaryString(two));

        System.out.println("Binar " + one + " & " + two + " = " +
                Integer.toBinaryString(one & two));
        System.out.println("Binar " + one + " | " + two + " = " +
                Integer.toBinaryString(one | two));
        System.out.println("Binar " + one + " ^ " + two + " = " +
                Integer.toBinaryString(one ^ two));
        System.out.println("Binar ~" + one + " = " +
                Integer.toBinaryString(~one));
        System.out.println("Binar " + one + ">>1 = " +
                Integer.toBinaryString(one >> 1));
        System.out.println("Binar " + one + "<<1 = " +
                Integer.toBinaryString(one << 1));
    }
}