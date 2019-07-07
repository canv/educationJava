package pack10ch;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        int charIndex;

        if (args.length != 2) {
            System.out.println("Using: CopyFile from where ");
            return;
        }


        try (FileInputStream fileIn = new FileInputStream(args[0]);
             FileOutputStream fileOut = new FileOutputStream(args[1])) {
            do {
                charIndex = fileIn.read();
                if (charIndex != -1) fileOut.write(charIndex);
            }while (charIndex != -1);
        }catch (IOException exc) {
            System.out.println("IO exception: " + exc);
        }
    }
}
