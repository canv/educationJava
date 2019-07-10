package pack10ch;

import java.io.*;

public class ReadChars {
    public static void main(String[] args) throws IOException {

        BufferedReader charStream =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input characters; end - '.'");

        char charInput;

        do{
            charInput = (char) charStream.read();
            System.out.print(charInput);
        }while (charInput != '.');
    }
}
