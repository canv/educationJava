package pack10ch.fileReaderPack;

import java.io.*;

public class DtoS {
    public static void main(String[] args) {
        String str;

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(
                                     myAddress() + "testFW.txt"))) {

            while ((str = br.readLine()) != null)
                System.out.println(str);

        } catch (IOException exc) {
            System.out.println("IO Exception: " + exc);
        }
    }

    private static String myAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\myfirstproj\\src\\pack10ch\\fileWriterPack\\";
    }
}