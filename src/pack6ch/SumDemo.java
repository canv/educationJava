package pack6ch;

public class SumDemo {
    public static void main(String[] args) {
        System.out.println("Sum: " + sum());
        System.out.println("Sum: " + sum(11));
        System.out.println("Sum: " + sum(15, 26, 37));
    }

    static private int sum(int... args) {
        int result = 0;

        for (int i : args) {
            result += i;
        }

        return result;
    }
}

