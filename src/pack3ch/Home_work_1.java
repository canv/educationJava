package pack3ch;

public class Home_work_1
{
    public static void main(String[] args)
            throws java.io.IOException
    {
        char sim;
        int spase = 0;

        System.out.println ("В этой программе будут считыватся" +
                "\nсиимволы с клавиатуры то тех пор пока не " +
                "\nвстретиться точка, сведения о количестве пробелов " +
                "\nбудут выводиться в конце");
        do
        {
            sim = (char) System.in.read();
            if (sim == ' ') spase++;
        }
        while (sim != '.');
        System.out.println (spase);
    }
}
