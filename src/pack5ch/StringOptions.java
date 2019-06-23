/*
        boolean equals (str)
        int length ()
        char charAt (index)
        int  compareTo (String str)
        int indexOf (String  str)
        int lastIndexOf (String  str)
*/

package pack5ch;

public class StringOptions {
    public static void main(String[] args) {

        String str1 = "Java is internet leader";
        String str2 = str1;
        String str3 = "Java strings effective";
        String con;

        int result, index;

        System.out.println("1) str1 length: " + str1.length());
        System.out.println("\n2) Character mapping: ");
        for (int i = 0; i < str1.length(); i++)
            System.out.print(str1.charAt(i));

        System.out.println("\n\n3) Equivalence test: ");
        if (str1.equals(str2))
            System.out.println("str1 is equivalent to str2");
        else System.out.println("str1 is not equivalent to str2");
        if (str1.equals(str3))
            System.out.println("str1 is equivalent to str3");
        else System.out.println("str1 is not equivalent to str3");

        result = str1.compareTo(str3);
        if (result == 0) System.out.println("\n4) str1 == str3");
        else if (result < 0) System.out.println("\n4) str1 < str3");
        else System.out.println("\n4) str1 > str3");

        str2 = "One Two Three One";
        index = str2.indexOf("One");
        System.out.println("\n5.1) One's First entry index: " + index);
        index = str2.lastIndexOf("One");
        System.out.println("5.2) One's Lust entry index: " + index);

        con = str1 + str2;
        System.out.println("\n6) Concatenation of str1 and str2:\n" + con);


    }
}
