package pack2ch;

public class Test1 {
    public static void main(String[] args) {
        int i, j;
        boolean isprime;
        for (i = 2; i < 200; i++) {
            isprime = true;
            for (j = 2; j < i; j++)
                // то же самое что и
                // for (j = 2; j <= Math.sqrt(i); j++)
                //Существует что-то типа теоремы (своими словами)
                //"Если у числа не найден
                if ((i % j) == 0) isprime = false;
            if (isprime) System.out.println(i);
        }
    }
}
