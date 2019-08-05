package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface GenTest<T>{
    boolean test(T a, T b);
}

public class GenLambdaDemo {
    public static void main(String[] args) {

        consoleOut.println();
        GenTest<Integer> isFactor = (a, b) -> (a % b) == 0;
        consoleOut.println(isFactor.test(10, 2) ? "2 is divider 10" : "2 not divider 10");
        consoleOut.println(isFactor.test(10, 3) ? "3 is divider 10" : "3 not divider 10");

        consoleOut.println();
        GenTest<Double> lessThan = (x, y) -> (x < y);
        consoleOut.println(lessThan.test(2.5, 10.1) ? "2.5 < 10.1" : "2.5 !< 10.1");
        consoleOut.println(lessThan.test(-5.2, 10.10) ? "-5.2 < 10.10" : "-5.2 !< 10.10");

        consoleOut.println();
        GenTest<Integer> absEqual = (x, y) -> (x < 0 ? -x : x) == (y < 0 ? -y : y);
        consoleOut.println(absEqual.test(4, -4) ? "Reciprocal 4 and -4 is equal" : "Reciprocal 4 and -4 is not equal");
        consoleOut.println(absEqual.test(4, -5) ? "Reciprocal 4 and -5 is equal" : "Reciprocal 4 and -5 is not equal");

        consoleOut.println();
        GenTest<String> isIn = (a,b) -> {
            return a.indexOf(b) != -1;
        };
        consoleOut.println(isIn.test("This is test", "is") ? "'is' is found" : "'is' is not found");
        consoleOut.println(isIn.test("This is test", "name") ? "'name' is found" : "'name' is not found");
    }
}