package VideoLessons.ch2;

import javax.swing.*;

class Supp {
    private String first;
    private String second;
    private String operation;
    private int count;

    private String showInput(String message) {
        return JOptionPane.showInputDialog(
                null, message,
                JOptionPane.QUESTION_MESSAGE);
    }
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(
                null, message);
    }
    private void showError(String type) {
        switch (type) {
            case "emptyStr":
                showMessage("You haven't entered anything!");
                break;
            case "interrupt":
                showMessage("You interrupted the program!");
                break;
            case "negative":
                showMessage("Only positive numbers allowed!");
                break;
            default:
                showMessage("Unknown input error, try again");
        }
    }

    private int parseToInt(String val) {
        return Integer.parseInt(val);
    }

    private void resultPlus() {
        showMessage(first + " + " + second + " = "
                + (parseToInt(first) + parseToInt(second)));
        count++;
    }
    private void resultMinus() {
        showMessage(first + " - " + second + " = "
                + (parseToInt(first) - parseToInt(second)));
        count++;
    }
    private void resultMultiply() {
        showMessage(first + " * " + second + " = "
                + (parseToInt(first) * parseToInt(second)));
        count++;
    }
    private void resultDivide() {
        showMessage(first + " / " + second + " = "
                + (parseToInt(first) / parseToInt(second)));
        count++;
    }

    private boolean isInterrupt(String who) {
        switch (who) {
            case "first":
                return first == null;
            case "second":
                return second == null;
            default:
                return operation == null;
        }
    }
    private boolean isEmptyStr(String who) {
        switch (who) {
            case "first":
                return first.equals("");
            case "second":
                return second.equals("");
            default:
                return operation.equals("");
        }
    }
    private boolean isPositive(String who) {
        switch (who) {
            case "first":
                return parseToInt(first) <= 0;
            case "second":
                return parseToInt(second) <= 0;
            default:
                return true; //"operation" and "repeat" can't be integer
        }
    }

    private boolean isInvalid(String who) {
        if (isInterrupt(who)) {
            showError("interrupt");
            return true;
        }
        if (isEmptyStr(who)) {
            showError("emptyStr");
            return true;
        }
//        if ((who.equals("first")
//                | who.equals("second"))
//                && isPositive(who)) {
//            showError("negative");
//            return true;
//        }
        if (who.equals("first") || who.equals("second")){
            if(isPositive(who)) {
                showError("negative");
                return true;
            }
        }

        return false;
    }

    boolean input(String who) {
        switch (who) {
            case "first":
                first = showInput("Enter first positive integer number.");
                if (isInvalid("first")) return true;
                break;

            case "second":
                second = showInput("Enter second positive integer number");
                if (isInvalid("second")) return true;
                break;

            case "operation":
                operation = showInput("Enter operation: '+', '-', '*', '/':");
                if (isInvalid("operation")) return true;
                break;

            default:
                String repeat = showInput("You use " + count + " operations" +
                        "\nContinue work?" +
                        "\ny / n");
                return repeat.equals("y");
        }
        return false;
    }
    void result() {
        switch (operation) {
            case "+":
                resultPlus();
                break;

            case "-":
                resultMinus();
                break;

            case "*":
                resultMultiply();
                break;

            case "/":
                resultDivide();
                break;

            default:
                break;
        }
    }
}

public class Lesson11_2 {
    public static void main(String[] args) {
        Supp calc = new Supp();
        do {
            if (calc.input("first")) return;
            if (calc.input("second")) return;
            if (calc.input("operation")) return;
            calc.result();

        } while (calc.input("repeat"));
    }
}