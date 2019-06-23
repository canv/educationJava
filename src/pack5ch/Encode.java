package pack5ch;

public class Encode {
    public static void main(String[] args) {
        String text = "Just encode me, please";
        String ecText = "";
        String decText = "";
        int key = 335;

        System.out.println("Original message: " + text);

        //encoding!
        for (int i = 0; i < text.length(); i++)
            ecText += (char) (text.charAt(i) ^ key);
        System.out.println("\nEncoded message: " + ecText);


        //de encoding!
        for (int i = 0; i < ecText.length(); i++)
            decText += (char) (ecText.charAt(i) ^ key);
        System.out.println("\nEncoded message: " + decText);
    }
}
