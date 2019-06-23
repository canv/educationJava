package pack1ch;// 1 глава Основы java 49 стр ( "for" cycle)

public class For_Demo {

    public static void main(String args[]) {

        double one = 213124;
                // как я понял значение one задаеться по новой в цикле for
                // и так как между ними ничего нет
                // то неимет значение какое значение имеет (хахх)
                // one перед for

        for (one = 1; one <= 6.5; one = one + 1.1)
            System.out.println(" Теперь значение 'one' = " + one);
            System.out.println("    Готово!");

    }
}