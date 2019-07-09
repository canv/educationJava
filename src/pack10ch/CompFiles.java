/*  If at some stage the comparison operation fails,
        it means that the contents of both files are not the same.
    If the end of both files is reached simultaneously,
        it means that they contain the same data.*/

package pack10ch;

import java.io.*;

public class CompFiles {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Using:\n...>java CompFiles first_file_name.expansion second_file_name.expansion");
            return;
        }

        compare(args);
    }

    private static void compare(String[] mainArgs) {
        int firstFileIndex, secondFileIndex;

        try (FileInputStream firstFile = new FileInputStream(mainArgs[0]);
             FileInputStream secondFile = new FileInputStream(mainArgs[1])) {

            do {
                firstFileIndex = firstFile.read();
                secondFileIndex = secondFile.read();

                if (firstFileIndex != secondFileIndex) break;
            } while (firstFileIndex != -1 & secondFileIndex != -1);

            System.out.println((firstFileIndex != secondFileIndex) ?
                    "Files content is not equal" : "Files content is equal");

        } catch (IOException exc) {
            System.out.println("IO exception: " + exc);
        }
    }
}
