//        Урок 8.  Оператор цикла for
//
//          Попросите пользователя ввести положительное целое число через JOptionPane.
//          Обработайте некорректные данные (ничего не ввёл, отрицательное число, 0, не
//        целое число), выведя соответствующие уведомления об ошибке.
//          Вычислите сумму всех чисел от 1 до числа, введённого пользователем, используя
//        цикл for.
//          Выведите результат пользователю через JOptionPane.

package VideoLessons.ch2;

import javax.swing.*;

public class Lesson8 {
    public static void main(String[] args) {
        String put;
        int sum = 0;

        put = JOptionPane.showInputDialog
                (null,
                        "Enter positive integer number.",
                        JOptionPane.QUESTION_MESSAGE);
        if (put != null && !put.equals("") && !put.equals(".")) {
            int parsePut = Integer.parseInt(put);
            if (parsePut > 0) {
                for (int n = 1; n <= parsePut; n++) {
                    sum = sum + n;
                }
                JOptionPane.showMessageDialog
                        (null,
                                "Sum of numbers from 1 to "
                                        + parsePut + " is " + sum);
            } else if (parsePut < 0) JOptionPane.showMessageDialog
                    (null,
                            "You entered a negative number!");
            else JOptionPane.showMessageDialog
                        (null,
                                "You entered a zero!");

        } else if (put == null)
            JOptionPane.showMessageDialog
                    (null,
                            "You interrupted the program!");
        else if (put.equals(""))
            JOptionPane.showMessageDialog
                    (null,
                            "You have not entered anything!");
        else if (!put.equals(".")) JOptionPane.showMessageDialog // don't work
                (null,
                        "You did not enter an integer!");
        else JOptionPane.showMessageDialog
                    (null,
                            "Shit happened...");

    }
}
