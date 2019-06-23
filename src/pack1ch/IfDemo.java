package pack1ch;
// 1 глава Основы java 48 стр ( "if" operator)



public class IfDemo {
        public static void main (String args[]) {

            int a = 2, b = 3, c;

            if (a < b) System.out.println(a + " меньше чем " + b);

                        System.out.println( );

            if (a == b) System.out.println
                    (a + " ровно " + b + " так не должно быть!! Исправь!");
            if (a > b) System.out.println
                    (a + " больше чем " + b + " так не должно быть!! Исправь!");

            c = a - b; // set the variable value "С" (задаем значение переменной "С")

            System.out.println("Переменная 'с' содержит значение  " + c);

            if (c >= 0) System.out.println
                    (" - Переменная 'с' положительное число ");
            if (c < 0) System.out.println
                    (" - Переменная 'с' отрицательное число ");

                    System.out.println( );

            c = b - a; // change the variable value "С" (меняем значение переменной "С")

            System.out.println("Переменная 'с' содержит значение  " + c);

            if (c >= 0) System.out.println
                    (" - Переменная 'с' положительне число ");
            if (c < 0) System.out.println
                    (" - Переменная 'с' отрицательное число ");

        }
}
