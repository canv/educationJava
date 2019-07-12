package pack10ch.fileWriterPack;

import java.io.*;

public class KtoD {
    public static void main(String[] args) {
        String str;

        BufferedReader stringValue =
                new BufferedReader(
                        new InputStreamReader(System.in));

        System.out.println("Input \"stop\" for complete");

        try (FileWriter testFWtxt = new FileWriter(
                myAddress() + "testFW.txt")) {
            do {

                System.out.println("next input:");
                str = stringValue.readLine();

                if (str.compareTo("stop") == 0) break;

                str = str + "\r\n";
                testFWtxt.write(str);

            } while (str.compareTo("stop") != 0);
        } catch (IOException exc) {
            System.out.println("IO Exception: " + exc);
        }
    }

    private static String myAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\myfirstproj\\src\\pack10ch\\fileWriterPack\\";
    }
}
