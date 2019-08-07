package pack14ch;

import static packAlternative.AOutput.consoleOut;

class NegativeFactorialException extends Exception {
    private int val;

    NegativeFactorialException(int val) {
        this.val = val;
    }

    public String toString() {
        return "\n\tFactorial cannot be negative! Your input: " + val + "!";
    }
}

interface GenNumericFunc<T extends Number> {
    T func(T n) throws NegativeFactorialException;
}

public class GenFactorialLambda {
    public static void main(String[] args){
        GenNumericFunc<Integer> intFac = (n) -> {
            if (n < 0) throw new NegativeFactorialException(n);
            if (n == 1 | n == 0) return 1;

            int result = 1;
            for (int i = 1; i <= n; i = i + 1)
                result *= i;
            return result;
        };

        try {
            consoleOut.println("Factorial 4: " + intFac.func(4));
            consoleOut.println("Factorial 6: " + intFac.func(6));
            consoleOut.println("Factorial 6: " + intFac.func(0));
            consoleOut.println("Factorial 6: " + intFac.func(-2));
        }catch (NegativeFactorialException exc){
            consoleOut.println(exc);
        }
    }
}