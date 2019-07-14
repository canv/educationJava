package pack10ch;

import java.io.*;


class Average {
    private PrintWriter consoleOut = new PrintWriter(System.out, true);
    private BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
    private String str;

    private int howMuch() throws IOException {
        consoleOut.println("How much numbers you will input?");

        int numbers;
        str = consoleIn.readLine();

        try {
            numbers = Integer.parseInt(str);
        } catch (NumberFormatException exc) {
            consoleOut.println("Wrong format!");
            return 0;
        }
        return numbers;
    }

    void calculation() throws IOException {

        int num = howMuch();
        double intermediateValue, sum = 0;

        consoleOut.println("Input " + num + " number:");

        for (int i = 0; i < num; i++) {
            System.out.print("> ");
            str = consoleIn.readLine();
            try {
                intermediateValue = Double.parseDouble(str);
            } catch (NumberFormatException exc) {
                consoleOut.println("Wrong format!");
                intermediateValue = 0;
            }
            sum += intermediateValue;
        }
        consoleOut.println("Middle value: " + sum / num);
    }
}

public class AvgNums {
    public static void main(String[] args) throws IOException {

        Average findAvg = new Average();
        findAvg.calculation();
    }
}
