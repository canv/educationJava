package VideoLessons.ch2;

import javax.swing.*;

class Support2 {
    private String first;
    private String second;
    private String operation;

//    Support2(String op) {
//        operation = op;
//    }


    private boolean isNull(String who) {
        switch (who) {
            case "first":
                return first == null;
            case "second":
                return second == null;
            default:
                return operation == null;
        }
    }
    private boolean isEmptyString(String who) {
        switch (who) {
            case "first":
                return first.equals("");
            case "second":
                return second.equals("");
            default:
                return operation.equals("");
        }
    }

    private String showInput(String message) {
        return JOptionPane.showInputDialog(null, message, JOptionPane.QUESTION_MESSAGE);
    }
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private int strToInt(String value) {
        return Integer.parseInt(value);
    }

    private void plus() {
        showMessage(first + " + " + second + " = "
                + (strToInt(first) + strToInt(second)));
    }

    private void showError(String type) {
        switch (type) {
            case "empty":
                showMessage("Error! Value is empty");
                break;

            case "null":
                showMessage("Error. Value is interrupt");
                break;

            default:
                break;
        }
    }

    void save(String who) {
        switch (who) {
            case "first":
                first = showInput("Enter first positive number");
                break;

            case "second":
                second = showInput("Enter second positive number");
                break;

            default:
                operation = showInput("Enter operation: '+', '-', '*', '/':");
                break;
        }
    }


//        for my Lesson11_2
//         boolean isInvalid(String who) {
//        if (isInterrupt(who)) {
//            showError("interrupt");
//            return true;
//        }
//        if (isEmptyStr(who)) {
//            showError("emptyStr");
//            return true;
//        }
//        if (isLessZero(who)) {
//            showError("lessZero");
//            return true;
//        }
//        if (isEqualZero(who)) {
//            showError("equalZero");
//            return true;
//        }
//
//        return false;
//
    boolean isInvalid(String who) {
        if (isEmptyString(who)) {
            showError("empty");
            return true;
        }

        if (isNull(who)) {
            showError("null");
            return true;
        }

        return false;
    }
    void result() {
        switch (operation) {
            case "+":
                plus();
                break;

            default:
                break;
        }
    }
}

public class Lesson11_1 {
    public static void main(String[] args) {
        Support2 cal = new Support2();

        cal.save("first");

        if (cal.isInvalid("first")) {
            return;
        }

        cal.save("second");

        if (cal.isInvalid("second")) {
            return;
        }

        cal.save("operation");

        if (cal.isInvalid("operation")) {
            return;
        }

        cal.result();
    }
}

