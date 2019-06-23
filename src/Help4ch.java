public class Help4ch {
    public static void main(String[] args)
            throws java.io.IOException {
        char choise, ignore;
        ForHelp4ch hlpobj = new ForHelp4ch();

        System.out.println("В данной программе " +
                "\nты сможешь найти свойства " +
                "\nоператоров и тп" +
                "\n\nВыбери номер пункта о " +
                "котором хочешь узнать:");

        for (; ; ) {
            do {
                hlpobj.showmenu();

                choise = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');

            } while (hlpobj.isvailid(choise));
            if (choise == 'q') break;
            System.out.println("\n\n");
            hlpobj.helpon(choise);
        }
    }
}
