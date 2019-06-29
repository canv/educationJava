package CodeWars;

public class MexicanWave {
    public static void main(String[] args) {

        String test1 = "hello";
        String test2 = "code wars";
        String test3 = "";
        String test4 = "two words";
        String test5 = " gap ";

        for (String x : MexicanWave.wave(test1)) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave(test2)) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave(test3)) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave(test4)) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave(test5)) {
            System.out.println(x);
        }
    }

    private static String[] wave(String str) {

        int resultLength = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != ' ') resultLength++;
        }
        String[] withoutSpaces = new String[resultLength];

        String[] r = new String[str.length()];

        int count = 0;


        for (int i = 0; i < r.length; i++) {


            String mask = str;
            char[] maskChars = mask.toCharArray();
            maskChars[i] = ((char) (str.charAt(i) - 32));
            mask = String.valueOf(maskChars);


            if (!mask.equals(mask.toLowerCase())) {
//                System.out.println("<"+count+">");
                withoutSpaces[count] = mask;
                count++;
            }
        }
        return withoutSpaces;
    }
}
