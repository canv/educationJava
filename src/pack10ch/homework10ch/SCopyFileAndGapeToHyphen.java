package pack10ch.homework10ch;

import java.io.*;

public class SCopyFileAndGapeToHyphen {
    public static void main(String[] args) {
        int charIndex;

        if (args.length != 2) {
            consoleOut.println("Using: CopyFile from where ");
            return;
        }

        try (FileReader fileIn = new FileReader(args[0]);
             FileWriter fileOut = new FileWriter(args[1])) {
            do {
                charIndex = fileIn.read();
                if (charIndex == -1) continue;
                if (charIndex == ' ') {
                    fileOut.write('~');
                    continue;
                }
                fileOut.write(charIndex);
            } while (charIndex != -1);
        } catch (IOException exc) {
            consoleOut.println("IO exception: " + exc);
        }
    }
    private static PrintWriter consoleOut = new PrintWriter(System.out, true);
}
