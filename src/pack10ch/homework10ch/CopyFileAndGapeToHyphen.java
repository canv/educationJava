/*
    Example of how it starts on my device:
    >java pack10ch.homework10ch.CopyFileAndGapeToHyphen pack10ch\homework10ch\firstFile.txt pack10ch\homework10ch\secondFile.txt
    The files "firstFile.txt" and "secondFile.txt" must be in the same package as "CopyFileAndGapeToHyphen.class"
*/

package pack10ch.homework10ch;

import java.io.*;

class ByteCF {
    PrintWriter consoleOut = new PrintWriter(System.out, true);
    private FileInputStream fileIn = null;
    private FileOutputStream fileOut = null;

    boolean isHaveFiles(String[] mainArgs) {
        if (mainArgs.length != 2) {
            consoleOut.println("Using: CopyFile from where ");
            return true;
        }
        return false;
    }

    void mainProcess() {
        try {
            int charIndex;
            do {
                charIndex = fileIn.read();
                if (charIndex == -1) continue;
                if (charIndex == ' ') {
                    fileOut.write('-');
                    continue;
                }
                fileOut.write(charIndex);

            } while (charIndex != -1);
        } catch (IOException exc) {
            consoleOut.println(exc);
        }
    }

    void setFileIn(FileInputStream fileIn) {
        this.fileIn = fileIn;
    }

    void setFileOut(FileOutputStream fileOut) {
        this.fileOut = fileOut;
    }

    void finallyFileIn() {
        try {
            if (fileIn != null) fileIn.close();
        } catch (IOException exc) {
            consoleOut.println("Error closing input file!");
        }
    }

    void finallyFileOut() {
        try {
            if (fileOut != null) fileOut.close();
        } catch (IOException exc) {
            consoleOut.println("Error closing output file!");
        }
    }

}

public class CopyFileAndGapeToHyphen {
    public static void main(String[] args) {

        ByteCF operation = new ByteCF();

        if (operation.isHaveFiles(args)) return;

        try {

            operation.setFileIn(new FileInputStream(args[0]));
            operation.setFileOut(new FileOutputStream(args[1]));

            operation.mainProcess();

        } catch (IOException exc) {
            operation.consoleOut.println("IO exception: " + exc);
        } finally {
            operation.finallyFileIn();
            operation.finallyFileOut();
        }
    }
}
