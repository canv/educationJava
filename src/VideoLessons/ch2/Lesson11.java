//Урок 11. Оператор switch-case
//          Попросите пользователя ввести первое число через JOptionPane, а затем аналогично
//        второе.
//          Попросите пользователя ввести одну из операций: «+», «-», «*», «/».
//          Используя switch-case выполните соответствующую операцию между двумя
//        введёнными числами и выведите результат через JOptionPane.
//        Примечание: При вводе некорректных данных выведите информацию об ошибке в
//        консоль и завершите программу.


package VideoLessons.ch2;
import javax.swing.*;


class Support {
    String num1;
    String num2;
    String operation;

//    Support(String fNum, String sNum, int res) {
//        firstNum = fNum;
//        secondNum = sNum;
//        result = res;
//    }

    String put1(){
        return JOptionPane.showInputDialog
                (null,
                        "Enter first positive integer number.",
                        JOptionPane.QUESTION_MESSAGE);
    }
    String put2() {
        return JOptionPane.showInputDialog
                (null,
                        "Enter second positive integer number.",
                        JOptionPane.QUESTION_MESSAGE);
    }
    String putOp() {
        return JOptionPane.showInputDialog
                (null,
                        "Enter operation: '+', '-', '*', '/':",
                        JOptionPane.QUESTION_MESSAGE);
    }

    private int justParse(String val) {
        return Integer.parseInt(val);
    }

    void plus() {
        JOptionPane.showMessageDialog
                (null,
                        num1 +
                                " + " + num2 +
                                " = " + (justParse(num1)
                                + justParse(num2)));
    }
    void minus() {
        JOptionPane.showMessageDialog
                (null,
                        num1 +
                                " - " + num2 +
                                " = " + (justParse(num1)
                                - justParse(num2)));
    }
    void multiply() {
        JOptionPane.showMessageDialog
                (null,
                        num1 +
                                " * " + num2 +
                                " = " + (justParse(num1)
                                * justParse(num2)));
    }
    void divide() {
        JOptionPane.showMessageDialog
                (null,
                        num1 +
                                " / " + num2 +
                                " = " + (justParse(num1)
                                / justParse(num2)));
    }

    boolean unNone(String inPut) {
        return (!inPut.equals(""));
    }
    boolean unInterrupt(String inPut) {
        return (inPut != null);
    }
    boolean aboveZero(String inPut) {
        return (justParse(inPut) > 0);
    }

    boolean lessZero(String inPut) {
        return (justParse(inPut) < 0);
    }
    boolean equalZero(String inPut) {
        return (justParse(inPut) == 0);
    }
    boolean Interrupt(String inPut) {
        return (inPut == null);
    }
    boolean None(String inPut) {
        return (inPut.equals(""));
    }

    void errNull() {
        JOptionPane.showMessageDialog
                (null,
                        "You interrupted the program!");
    }
    void errNone() {
        JOptionPane.showMessageDialog
                (null,
                        "You have not entered anything!");
    }
    void errZero() {
        JOptionPane.showMessageDialog
                (null,
                        "You entered a zero!");
    }
    void errNegative() {
        JOptionPane.showMessageDialog
                (null,
                        "You entered a negative number!");
    }
    void errDefault() {
        JOptionPane.showMessageDialog
                (null,
                        "Incorrectly input! Try again, please.");
    }
}

public class Lesson11 {
    public static void main(String[] args) {
        Support cal = new Support();

        for (int i = 0; i < 5; i++) {    //just a counter for testing

            cal.num1 = cal.put1();
            if (cal.unInterrupt(cal.num1) && cal.unNone(cal.num1)) {
                if (cal.aboveZero(cal.num1)) {

                    cal.num2 = cal.put2();
                    if (cal.unInterrupt(cal.num2) && cal.unNone(cal.num2)) {
                        if (cal.aboveZero(cal.num2)) {

                            cal.operation = cal.putOp();
                            if (cal.unInterrupt(cal.operation)) {

                                switch (cal.operation) {
                                    case ("+"):
                                        cal.plus();
                                        break;
                                    case ("-"):
                                        cal.minus();
                                        break;
                                    case ("*"):
                                        cal.multiply();
                                        break;
                                    case ("/"):
                                        cal.divide();
                                        break;
                                    default:
                                        cal.errDefault();
                                }
                            } else cal.errNull();

                        } else if (cal.lessZero(cal.num2)) cal.errNegative();
                        else if (cal.equalZero(cal.num2)) cal.errZero();
                    } else if (cal.Interrupt(cal.num2)) cal.errNull();
                    else if (cal.None(cal.num2)) cal.errNone();

                } else if (cal.lessZero(cal.num1)) cal.errNegative();
                else if (cal.equalZero(cal.num1)) cal.errZero();
            } else if (cal.Interrupt(cal.num1)) cal.errNull();
            else if (cal.None(cal.num1)) cal.errNone();
        }
    }
}