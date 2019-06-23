package pack2ch;

public class Ch2_Log_Tabl
{
    public static void main (String args[])
    {
        boolean p, q;
        byte P, Q, AND, OR, XOR, NOT;

        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");
        System.out.println("|\t|\t|\t|\t|\t|");

        p = true;
        q = true;
        if (p==true) P=1; else P = 0;
        if (q==true) Q=1; else Q = 0;
        if ((p&q)==true) AND=1; else AND = 0;
        if ((p|q)==true) OR=1; else OR = 0;
        if ((p^q)==true) XOR=1; else XOR = 0;
        if ((!p)==true) NOT=1; else NOT = 0;
        System.out.println
                (P + "\t" + Q + "\t" + AND +
                "\t" + OR + "\t" + XOR + "\t" + NOT);
        p = true;
        q = false;
             System.out.println
                (P + "\t" + Q + "\t" + AND +
                "\t" + OR + "\t" + XOR + "\t" + NOT);
        p = false;
        q = true;
                System.out.println
                (P + "\t" + Q + "\t" + AND +
                "\t" + OR + "\t" + XOR + "\t" + NOT);
        p = false;
        q = false;
                System.out.println
                (P + "\t" + Q + "\t" + AND +
                "\t" + OR + "\t" + XOR + "\t" + NOT);
    }
}
