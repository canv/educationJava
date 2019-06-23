package pack5ch;

public class HomeWork4 {
    public static void main(String[] args) {
//        String[] num = {
//                "ninety nine",
//                "minus ten",
//                "one hundred thousand one hundred twenty three",
//                "eighteen",
//                "minus nine hundred eighty eight",
//                "five thousand six hundred twenty three",
//                "four hundred sixty three",
//                "minus nine",
//                "two hundred eighty seven",
//                "forty nine"};
        String[] num = {
                "123",
                "1234",
                "12",
                "1",
                "12345",
                "123456",
                "12345678",
                "1234567890",
                "1234567",
                "123456789"};

        int actualIndex, sortIndex;
        String temporaryValue;
        int arraySize = num.length;

        System.out.print("Origin array: \n");
//        for (int i = 0; i < arraySize; i++)
        for (String i : num) System.out.println(" " + i);
        System.out.println(" ");

        for (actualIndex = 1;
             actualIndex < arraySize;
             actualIndex++) {

            for (sortIndex = arraySize - 1;
                 sortIndex >= actualIndex;
                 sortIndex--) {

                if (num[sortIndex - 1].compareTo(num[sortIndex]) > 0) {

                    temporaryValue = num[sortIndex - 1];
                    num[sortIndex - 1] = num[sortIndex];
                    num[sortIndex] = temporaryValue;
                }
            }
        }

        System.out.print("Sorted array: \n");
//        for (int i = 0; i < arraySize; i++)
        for (String i : num)
            System.out.println(" " + i);
        System.out.println(" ");
    }
}
