package pack10ch.helperPack;

import java.io.*;

class Help {
    private String helpTXT;
    static PrintWriter consoleOut = new PrintWriter(System.out, true);

    Help(String helpTXT) {
        this.helpTXT = helpTXT;
    }

    boolean helpOn(String what) {
        int conditionTag;
        String operatorName;
        String operatorInfo;

        try (BufferedReader helpRdr = new BufferedReader
                (new FileReader(helpTXT))) {
            do {
                conditionTag = helpRdr.read();

                if (conditionTag != '#') continue;
                operatorName = helpRdr.readLine();

                if (what.compareTo(operatorName) != 0) continue;
                do {
                    operatorInfo = helpRdr.readLine();
                    if (operatorInfo != null) consoleOut.println(operatorInfo);
                } while ((operatorInfo != null) && (operatorInfo.compareTo("") != 0));

                return true;

            } while (conditionTag != -1);

        } catch (IOException exc) {
            consoleOut.println("File access error!");
            return false;
        }
        return false;
    }

    String getSelection() {
        String topic = "";
        BufferedReader InputStream = new BufferedReader
                (new InputStreamReader(System.in));

        consoleOut.println("Enter operator:");
        try {
            topic = InputStream.readLine();
        } catch (IOException exc) {
            consoleOut.println("Input error!");
        }
        return topic;
    }

    void greeting() {
        consoleOut.println("You use the help system\n" +
                "Enter 'stop' to exit");
    }
}

public class FileHelp {
    public static void main(String[] args) {

        Help manual = new Help(myAddress() + "help.txt");
        manual.greeting();

        String topic;
        do {
            topic = manual.getSelection();

            if (!manual.helpOn(topic)) Help.consoleOut.println("Operator not found\n");
        } while (topic.compareTo("stop") != 0);
    }

    private static String myAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\myfirstproj\\src\\pack10ch\\helperPack\\";
    }
}
