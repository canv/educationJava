package pack5ch;

public class HomeWork7 {
    public static void main(String[] args) {
        String text = "Just encode me, please";
        String ecText = "";
        String decText = "";
        String key = "Apache22";
        int j;


        System.out.println("Original message: " + text);

        //encoding!
        j = 0;
        for (int i = 0; i < text.length(); i++) {
            ecText += (char) (text.charAt(i) ^ key.charAt(j));
            j++;
            if (j == 8) j = 0;
        }
        System.out.println("\nEncoded message: " + ecText);


        //de encoding!
        j = 0;
        for (int i = 0; i < ecText.length(); i++) {
            decText += (char) (ecText.charAt(i) ^ key.charAt(j));
            j++;
            if (j == 8) j = 0;
        }
        System.out.println("\nEncoded message: " + decText);
    }
}
