package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface MyValue {
    double getValue();
}
interface MyParamValue {
    double getValue(double v);
}
interface NumericTest {
    boolean numTest(int x, int y);
}
interface StringTest {
    boolean strTest(String a, String b);
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyValue myVal = () -> 98.6;
        consoleOut.println("Constant value: " + myVal.getValue());

        MyParamValue myPVal = (n) -> (1.0 / n);
        consoleOut.println("4 reciprocal: " + myPVal.getValue(4) +
                "\n8 reciprocal: " + myPVal.getValue(8));

        consoleOut.println();
        NumericTest isFactor = (x, y) -> (x % y) == 0;
        consoleOut.println(isFactor.numTest(10, 2) ? "2 is divider 10" : "2 not divider 10");
        consoleOut.println(isFactor.numTest(10, 3) ? "3 is divider 10" : "3 not divider 10");

        consoleOut.println();
        NumericTest lessThan = (x, y) -> (x < y);
        consoleOut.println(lessThan.numTest(2, 10) ? "2 < 10" : "2 !< 10");
        consoleOut.println(lessThan.numTest(10, 2) ? "3 < 10" : "3 !< 10");

        consoleOut.println();
        NumericTest absEqual = (x, y) -> (x < 0 ? -x : x) == (y < 0 ? -y : y);
        consoleOut.println(absEqual.numTest(4, -4) ? "Reciprocal 4 and -4 is equal" : "Reciprocal 4 and -4 is not equal");
        consoleOut.println(absEqual.numTest(4, -5) ? "Reciprocal 4 and -5 is equal" : "Reciprocal 4 and -5 is not equal");

        consoleOut.println();
        StringTest isIn = (a,b) -> a.indexOf(b) != -1;
        consoleOut.println(isIn.strTest("This is test", "is") ? "'is' is found" : "'is' is not found");
        consoleOut.println(isIn.strTest("This is test", "name") ? "'name' is found" : "'name' is not found");
    }
}