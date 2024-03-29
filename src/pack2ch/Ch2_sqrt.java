package pack2ch;
/*
Определение длины гипотенузы, исходя из длины катетов,
        по теореме Пифагора
*/

public class Ch2_sqrt
{
    public static void main(String args[])
    {
        double x = 3, y = 4, z;

        // сумма квадратов катетов ровна квадрату гипотинузы

        z =  Math.sqrt(x * x + y * y);

        System.out.println("Исходя из того, что длинна катетов " +
                "ровна " + x + " и " + y + " соответственно, " +
                "длинна гипотинузы составляет " + z);
    }
}