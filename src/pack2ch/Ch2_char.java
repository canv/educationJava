package pack2ch;/* Здесь я проверял как работает char и заодно решил испытать Блок кода
для того чтобы вышел красивый спиок */

public class Ch2_char
{
    public static void main(String args[])
    {
        char x;
        int num = 0;

        for (x = 'A'; x <= 199; x++)

            // пока не понятно почему
            // при значении меньше 65 ничего не выдаёт
        {
            System.out.print( "x = " + x + ", \t");
            num++;
            if (num >= 3)
            {
                System.out.println();
                num = 0;
            }
        }
    }
}
