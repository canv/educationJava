package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface MyValue {
    double getValue();
}

interface MyParamValue {
    double getValue(double v);
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyValue myVal;

        myVal = () -> 98.6;

        consoleOut.println("Constant value: " + myVal.getValue());

        MyParamValue myPVal = (n) -> (1.0 / n);

        consoleOut.println("4 reciprocal: " + myPVal.getValue(4));

        consoleOut.println("8 reciprocal: " + myPVal.getValue(8));

    }
}