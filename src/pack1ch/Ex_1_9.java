package pack1ch;
// 1 глава
// Сила тяжести на Луне составляет около 17% земной.
// Напишите программу, которая вычислила бы ваш вес на Луне.

public class Ex_1_9
{
    public static void main(String args[]) {

        double lwt, wt = 81;

        lwt = wt * 0.17;

        System.out.println ("Мой вес на земле: " + wt + " кг.");
        System.out.println ("Мой вес на луне: " + lwt + " кг.");

    }
}