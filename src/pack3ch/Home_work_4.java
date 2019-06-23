package pack3ch;

public class Home_work_4
{
    public static void main (String args[])
    {
        int num = 0;
        int x;
        for(x = 1000; x>=0; x-=2 )
        {
            System.out.print(x + ", ");
            num++;
            if (num == 10)
            {
                System.out.println(" ");
                num=0;
            }
        }
    }
}
