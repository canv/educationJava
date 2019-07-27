package pack13ch;

import java.io.PrintWriter;

class Numeric<T extends Number, V extends T> {

    private T extObjectNumber;
    private V extObjectT;

    Numeric(T extObjectNumber, V extObjectT) {
        this.extObjectNumber = extObjectNumber;
        this.extObjectT = extObjectT;
    }

    double reciprocal() {
        return 1 / extObjectNumber.doubleValue();
    }

    double fraction() {
        return extObjectNumber.doubleValue() - extObjectNumber.intValue();
    }

    double difference() {
        return extObjectNumber.doubleValue() - extObjectT.doubleValue();
    }

    T getExtObjectNumber() {
        return extObjectNumber;
    }

    V getExtObjectT() {
        return extObjectT;
    }
}

public class BoundsDemo {
    public static void main(String[] args) {

        Numeric<Integer, Integer> exampleOne =
                new Numeric<>(5, 15);

        consoleOut.println("\nReciprocal value of " + exampleOne.getExtObjectNumber() +
                " = " + exampleOne.reciprocal() +
                "\nFraction of " + exampleOne.getExtObjectNumber() +
                " = " + exampleOne.fraction() +
                "\nDifference between " + exampleOne.getExtObjectNumber() +
                " and " + exampleOne.getExtObjectT() +
                " = " + exampleOne.difference());

        Numeric<Double, Double> exampleTwo =
                new Numeric<>(5.25, 8.75);

        consoleOut.println("\nReciprocal value of " + exampleTwo.getExtObjectNumber() +
                " = " + exampleTwo.reciprocal() +
                "\nFraction of " + exampleTwo.getExtObjectNumber() +
                " = " + exampleTwo.fraction() +
                "\nDifference between " + exampleTwo.getExtObjectNumber() +
                " and " + exampleTwo.getExtObjectT() +
                " = " + exampleTwo.difference());
    }

    private static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
