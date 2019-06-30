package CodeWars;

public class Isograms {
    public static void main(String[] args) {
        System.out.println(Isograms.isIsogram("Dermatoglyphics"));
        System.out.println(Isograms.isIsogram("isogram"));
        System.out.println(Isograms.isIsogram("moose"));
        System.out.println(Isograms.isIsogram("isIsogram"));
        System.out.println(Isograms.isIsogram("aba"));
        System.out.println(Isograms.isIsogram("moOse"));
        System.out.println(Isograms.isIsogram("thumbscrewjapingly"));
        System.out.println(Isograms.isIsogram(""));
    }

    private static boolean isIsogram(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int x = i+1; x < str.length(); x++) {

                if ((str.charAt(i)) == (str.charAt(x))) return false;
                if ((char) (str.charAt(i) - 32) == (str.charAt(x))) return false;
                if ((char) (str.charAt(i) + 32) == (str.charAt(x))) return false;
            }
        }
        return true;

//        //solution from codewars, I don't understand yet
//        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
