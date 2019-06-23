

package pack1ch;

// 1 глава Основы java 50 стр (Демонстрация применения блоков кода)

public class Block_Demo {
    public static void main (String args[]) {

        double a = 10, b = 5, c;

        if(a != 0)

        // далее начало блока кода оператора if
        {
            System.out.println( "a не равно нулю");
            c = a / b;
            System.out.println( "Если 'a' разделить на '" + b +
                    "' то будет '" + c + "'");

        }
        // конец блока кода оператора if

        if(a <= 0) System.out.println("а равно нулю, переделывай");
    }

}
