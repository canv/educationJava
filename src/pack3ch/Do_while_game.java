package pack3ch;

public class Do_while_game {
    public static void main(String[] args)
            throws java.io.IOException {
        char ch, ignore, answer = 'S';

        do {
            System.out.println("Задумана буква из диапазона A-Z" +
                    "\nПопытайтесь ее отгадать: ");

            ch = (char) System.in.read();
            System.out.println(ch);

            do {
                ignore = (char) System.in.read();
                System.out.println("~~ " + ignore);
                System.out.println("~~ " + ch);
            } while (ignore != '\n');

            if (ch == answer) System.out.println("**Правильно!!**");
            else {
                System.out.println("Неправильно, нужная буква находится ");
                if (ch < answer)
                    System.out.println("ближе к концу алфавита");
                else System.out.println("ближе к началу афавита");
                System.out.println("Повторите попытку!");
            }
        } while (answer != ch);
    }
}
//package pack3ch;
//
//public class Do_while_game {
//    public static void main(String args[])
//            throws java.io.IOException {
//        char ch, ignore, answer = 'S';
//        int i = 5;
//
//        do {
//            System.out.println("Задумана буква из диапазона A-Z" +
//                    "\nПопытайтесь ее отгадать: ");
//            i--;
////
////            ch = (char) System.in.read();
////
////            do {
////                ignore = (char) System.in.read();
////            } while (ignore != '\n');
////
////            if (ch == answer) System.out.println("**Правильно!!**");
////            else {
////                System.out.println("Неправильно, нужная буква находится ");
////                if (ch < answer)
////                    System.out.println("ближе к концу алфавита");
////                else System.out.println("ближе к началу афавита");
////                System.out.println("Повторите попытку!");
////            }
////        } while (answer != ch);
//        } while (i != 0);
//    }
//}
