package pack4ch;

public class Finalize {
    public static void main(String[] args) {
        int count;

        FDemo ob = new FDemo(0);

        for (count = 1; count < 900_000; count++)
            ob.generator(count);
    }
}
