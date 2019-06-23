package pack4ch;

public class DemoPwr {
    public static void main(String[] args) {
        Pwr x = new Pwr(4.0, 2);
        Pwr y = new Pwr(2.5, 1);
        Pwr z = new Pwr(5.7, 0);

        System.out.println(x.b + " in exponent " + x.e +
                " equally " + x.get_pwr() +
                "\n" + y.b + " in exponent " + y.e +
                " equally " + y.get_pwr() +
                "\n" + z.b + " in exponent " + z.e +
                " equally " + z.get_pwr());
    }

}
