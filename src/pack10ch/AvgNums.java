package pack10ch;

import java.io.*;


class Average {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String str;

    private PrintWriter showMess() {
        return new PrintWriter(System.out, true);
    }
    private int howMuch() throws IOException {
        showMess().println("How much numbers you will input?");

        int numbers;
        str = br.readLine();

        try {
            numbers = Integer.parseInt(str);
        } catch (NumberFormatException exc) {
            showMess().println("Wrong format!");
            return 0;
        }
        return numbers;
    }

    void calculation() throws IOException {

        int num = howMuch();
        double intermediateValue, sum = 0;

        showMess().println("Input " + num + " number:");


        for (int i = 0; i < num; i++) {
            System.out.print("> ");
            str = br.readLine();
            try {
                intermediateValue = Double.parseDouble(str);
            } catch (NumberFormatException exc) {
                System.out.println("Wrong format!");
                intermediateValue = 0;
            }
            sum += intermediateValue;
        }

        showMess().println("Middle value: " + sum / num);

    }
}

public class AvgNums {
    public static void main(String[] args) throws IOException {

        Average tryIt = new Average();
        tryIt.calculation();

    }
}
