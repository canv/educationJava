package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface StringFunc {
    String func(String str);
}

public class LambdaArgumentDemo {
    private static String changeStr(StringFunc function, String inStr) {
        return function.func(inStr);
    }

    public static void main(String[] args) {

        String inStr = "lambda expressions extend Java";
        String outStr;
        consoleOut.println("Input string: " + inStr);


        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        outStr = changeStr(reverse, inStr);
        consoleOut.println("\nReversed string: " + outStr);


        outStr = changeStr((str)-> {
            String result = "";
            char ch;

            for (int i =0; i< str.length(); i++){
                ch=str.charAt(i);
                if(Character.isUpperCase(ch))result += Character.toLowerCase(ch);
                else result += Character.toUpperCase(ch);
            }
            return result;
        }, inStr);
        consoleOut.println("\nString with reverse case: " + outStr);


        outStr = changeStr((str) -> {
            String result = "";
            char ch;

            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (str.charAt(i) == ' ') continue;
                result += ch;
            }
            return result;
        }, inStr);
        consoleOut.println("\nString without spaces: " + outStr);


        consoleOut.println("\nString with replaced spaces: " +
                changeStr((str) -> str.replace(' ', '-'), inStr));

    }
}