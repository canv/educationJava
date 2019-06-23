package pack2ch;// демонстрация boolean

public class Ch2_boolean
{
    public static void main(String args[])
    {
        boolean bl = true;
        if(bl) System.out.println("эта функция выполняется");
        bl = false;
        if(bl) System.out.println("эта не функция выполняется");
        System.out.println(10>1);// истина, 10 действительно больше 1
        System.out.println(10>11);// ложь, 10 не болльше 11
    }
}
