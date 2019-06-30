// http://qaru.site/questions/187536/checking-letter-case-upperlower-within-a-string-in-java
// http://qaru.site/questions/109210/how-do-i-replace-a-character-in-a-string-in-java

package CodeWars;

public class MexicanWave {
    public static void main(String[] args) {

        for (String x : MexicanWave.wave("hello")) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave("code wars")) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave("")) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave("two words")) {
            System.out.println(x);
        }
        for (String x : MexicanWave.wave(" gap ")) {
            System.out.println(x);
        }
    }

    private static String[] wave(String str) {

        int finalLength = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != ' ') finalLength++;
        }
        String[] withoutSpaces = new String[finalLength];


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


//        //codewars version
//        String[] wave = new String[str.length()];
//
//        for (int i = 0; i < str.length(); i++) {
//            if (Character.isLetter(str.charAt(i))) {
//                wave[i] = str.substring(0, i) + Character.toUpperCase(str.charAt(i)) + str.substring((i + 1));
//            }
//        }
//
//        int spaceCount = 0;
//        for (String x : wave) {
//            if (x == null) {
//                spaceCount++;
//            }
//        }
//
//        String[] RealWaves = new String[wave.length - spaceCount];
//
//        int k = 0;
//        for (String j : wave) {
//            if (j != null) {
//                RealWaves[k] = j;
//                k++;
//            }
//        }
//
//        return (RealWaves);
    }
}
