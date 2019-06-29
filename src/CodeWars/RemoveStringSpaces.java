package CodeWars;

class SpaseDel {

    static String noSpace(final String x) {
        System.out.println(x.length());

//        String fin = "";
//        char s = ' ';
//
//        for (int i = 0; i < x.length(); i++) {
//            if (s != x.charAt(i)) fin += x.charAt(i);
//        }
//        return fin;

        //need to learn java library :)
        return x.replace(" ", "");
    }

}

public class RemoveStringSpaces {

    public static void main(String[] args) {
        System.out.println(SpaseDel.noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        System.out.println(SpaseDel.noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        System.out.println(SpaseDel.noSpace("8aaaaa dddd r     "));
        System.out.println(SpaseDel.noSpace("jfBm  gk lf8hg  88lbe8 "));
        System.out.println(SpaseDel.noSpace("8j aam"));
    }
}
