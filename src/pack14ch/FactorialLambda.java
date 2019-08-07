package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface NumericFunc {
    int func(int n);
}

public class FactorialLambda {
    public static void main(String[] args) {
        NumericFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result *= i;
            return result;
        };

        consoleOut.println("Factorial 4: " + factorial.func(4));
        consoleOut.println("Factorial 6: " + factorial.func(6));
        consoleOut.println("Factorial 12: " + factorial.func(12));
    }
}