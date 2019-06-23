package pack4ch;

public class FDemo {
    int x;

    FDemo(int i) {
        x = 1_000;
    }

    protected void finalize() {
        System.out.println("Finalize " + x);
    }

    void generator(int i) {
        FDemo o = new FDemo(i);
    }

}
