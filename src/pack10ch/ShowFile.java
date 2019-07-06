package pack10ch;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {

        int charIndex;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("Using: ShowFile file_name");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                charIndex = fin.read();
                if (charIndex != -1) System.out.print((char) charIndex);
            } while (charIndex != -1);

        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        } catch (IOException exc) {
            System.out.println("IO error!");

        } finally {
            try {
                if (fin != null) fin.close();

            } catch (IOException exc) {
                System.out.println("Error closing file!");
            }
        }
    }
}
