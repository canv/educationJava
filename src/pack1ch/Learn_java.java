package pack1ch;
// 1 глава Основы java 37 стр (моё первое задание)

public class Learn_java {

    public static void main (String[] args) {

        System.out.println("Java правит интернетом!");
        System.out.println(" ");
        System.out.println(" ");

        // первая глава 3е задание
        /* демонстрация различий между типами int и double */

        int celoe = 11;
        double drobnoe = 11;

        System.out.println ("начальное значение целого числа " + celoe);
        System.out.println ("начальное значение дробного числа " + drobnoe);

        celoe = celoe / 4;
        drobnoe = drobnoe / 4;

        System.out.println (" ");
        System.out.println ("значение целого числа после деления на 4: " + celoe);
        System.out.println ("значение дробного числа после деления на 4: " + drobnoe);

    }

}
