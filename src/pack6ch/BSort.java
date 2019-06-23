package pack6ch;

public class BSort {
    public static void main(String[] args) {
        String str;

        str = "OneTwoThree";

        System.out.println("String: " + str);
        System.out.println("Back sort: " + backSort(str));
    }

    static private String backSort(String str) {
        return reverse(str, str.length() - 1);
    }

    static private String reverse(String stringToReverse, int index) {
        if (index == 0) {
            return stringToReverse.charAt(0) + "";
        }

        char letter = stringToReverse.charAt(index);
        // присвоение letter кажой буквы с конца
        return letter + reverse(stringToReverse, index - 1);
        // каждая рекурсия конкатинирует каждую букву с конца
    }
}
