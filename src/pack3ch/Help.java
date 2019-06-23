package pack3ch;

public class Help {
    public static void main(String[] args)
            throws java.io.IOException {

        char choise, ignore;

        System.out.println("В данной программе " +
                "\nты сможешь найти свойства " +
                "\nоператоров и тп");
        System.out.println(" ");
        System.out.println("Выбери номер пункта о " +
                "котором хочешь узнать:");

        do {

            System.out.println("1. Оператор 'if'" +
                    "\n2. Цикл 'for'" +
                    "\n3. Оператор 'switch'" +
                    "\n4. Цикл 'while'" +
                    "\n5. Пример цикла 'while'" +
                    "\n6. Оператор 'do - while'" +
                    "\n7. Оператор 'break'" +
                    "\n8. Оператор 'continue'" +
                    "\n  Нажмите 'q' для выхода");


            choise = (char) System.in.read();

            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');

        } while (choise < '1' | choise > '8' & choise != 'q');


        System.out.println("\n");

        switch (choise) {
            case '1':
                System.out.println("1. Оператор 'if':" +
                        "\n\nif (условие) {оператор}" +
                        "\nelse {оператор}");
                break;
            case '2':
                System.out.println("2. Цикл 'for':" +
                        "\n\nfor (инициализация; условие; итерация)" +
                        "\n{оператор}");
                break;
            case '3':
                System.out.println("3. Оператор 'switch':" +
                        "\n\nswitch (выражение) {" +
                        "\n\tcase: константа 1:" +
                        "\n\t\tпоследовательность опертаоров;" +
                        "\n\tbreak;" +
                        "\n\tcase: константа 2:" +
                        "\n\t\tпоследовательность опертаоров;" +
                        "\n\tbreak;" +
                        "\n\t\t..." +
                        "\n\tcase: константа n:" +
                        "\n\t\tпоследовательность опертаоров;" +
                        "\n\tbreak;" +
                        "\n\tdefault:" +
                        "\n\t\tпоследовательность опертаоров;" +
                        "\n\n}");
                break;
            case '4':
                System.out.println("4. Цикл 'while':" +
                        "\n\nwhile (Условие) оператор");
                break;
            case '5':
                System.out.println("int e;// степень" +
                        "\n\nint result; // результат" +
                        "\n\nint n = 2;  // число возводимое в степень" +
                        "\n" +
                        "\n\nfor(int i=0; i<10; i++)" +
                        "\n\n{" +
                        "\n\n\t\t// объявляем новую переменную для счетчика" +
                        "\n\n\t\t// (нужно 10 циклов)" +
                        "\n\n\tresult = 1;" +
                        "\n\n\t\t// объявляем значение 1 внутри" +
                        "\n\n\t\t// цикла чтобы каждый новый цикл" +
                        "\n\n\t\t// первоначальное значение скидоволось до 1" +
                        "\n\n\te = i;" +
                        "\n\n\t\t// это значение явзяется счётчкиом степени" +
                        "\n\n\t\t// номер каждой новой итерации и будет самой степенью" +
                        "\n\n\twhile(e>0)" +
                        "\n\n\t\t{" +
                        "\n\n\t\t\t// e>0 для того, чтобы отсчет пошел со степени 1" +
                        "\n\n\t\tresult *=n;" +
                        "\n\n\t\t\t// в первом случае цик while пропускается" +
                        "\n\n\t\t\t// во втором переменная result умножается на 1" +
                        "\n\n\t\t\t// в третьем случае result умножается два раза, т.к" +
                        "\n\n\t\t\t// цикл проигрывается дважды (e=i=2)" +
                        "\n\n\t\te--;" +
                        "\n\n\t\t\t// в конце каждого цикла while e уменьшается на 1" +
                        "\n\n\t\t\t// чтобы не работать бесконечно" +
                        "\n\n\t\t\t// например в '2 in ^ 3 is 8'" +
                        "\n\n\t\t\t// в первоим умножении на само себя e=3" +
                        "\n\n\t\t\t// во втором е=2, в третьем е=1." +
                        "\n\n\t\t\t// таким образом 2 умножается на само себя три раза" +
                        "\n\n\t\t}" +
                        "\n\n\tSystem.out.println(n + ' in ^ ' + i + ' is ' + result);" +
                        "\n\n\t\t// Выведение надписи ставиться последним в цикле for" +
                        "\n\n\t\t// чтобы показать результат текущей итерации i" +
                        "\n\n\t\t// (например for(int i=2; i<10; i++))" +
                        "\n\n\t\t// а именно значения степени (каждая итерация for" +
                        "\n\n\t\t// это очередное возведение в степень)," +
                        "\n\n\t\t// и result который будет показывать итог возведения степени" +
                        "\n\n\t\t// в конце цикла, но обновляться в начале (цикла for) до 1" +
                        "\n\n\t}" +
                        "\n\n}");
                break;
            case '6':
                System.out.println("6. Оператор do - 'while':" +
                        "\n\ndo {" +
                        "\n оператор;" +
                        "\n} while (условие);");
                break;
            case '7':
                System.out.println("Oпepaтop break:" +
                        "\nbreak; или break метка;");
                break;
            case '8':
                System.out.println("Oпepaтop continue:" +
                        "\ncontinue; или continue метка;");
                break;
            //default: System.out.println("Запрос не найден");
        }
    }
}
