package pack10ch;

import java.io.*;

public class ReadLines {
    public static void main(String[] args) throws IOException {

        BufferedReader stringStream =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input text string; end - string \"stop\"");

        String stringInput;

        do{
            stringInput = stringStream.readLine();
            System.out.println(stringInput);
        }while (!stringInput.equals("stop"));
    }
}
