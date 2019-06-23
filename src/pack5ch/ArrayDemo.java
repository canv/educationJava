package pack5ch;

public class ArrayDemo {
    public static void main(String[] args) {

        int simple[] = new int[10];
        int i;

        for (i = 0; i < 10; i++) {
            simple[i] = i;
            System.out.println("Element simple[" + i + "]: " + simple[i]);
        }
    }
}
