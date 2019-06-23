package pack3ch;

public class Home_work_10 {
    public static void main(String[] args)
            throws java.io.IOException {
        int reg_change = 0;
        char ch;

        System.out.println("В этой программе будут считыватся " +
                "\nбуквы и переводиться на противоположный регистр, " +
                "\nтак же в конце будет приведено количество смены " +
                "\nрегистров. Для завершения введите точку");

        do {

            ch = (char) System.in.read();
            if (ch >= 'a' & ch <= 'z') {
                ch -= 32;
                reg_change++;
                System.out.print(ch);
            } else if (ch >= 'A' & ch <= 'Z') {
                ch += 32;
                reg_change++;
                System.out.print(ch);
            }
        } while (ch != '.');
        System.out.println("Количество " +
                "преобразований регистра: " + reg_change);
    }
}
