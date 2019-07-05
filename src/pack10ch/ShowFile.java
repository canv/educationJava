package pack10ch;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {

        int i;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("Using: ShowFile file_name");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

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
