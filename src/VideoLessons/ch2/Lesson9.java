package VideoLessons.ch2;

import javax.swing.*;

public class Lesson9 {
    public static void main(String[] args) {
        String put;
        int flag = 1;
        long factorial = 1;

        put = JOptionPane.showInputDialog
                (null,
                        "Enter positive integer number.",
                        JOptionPane.QUESTION_MESSAGE);
        if (put != null && !put.equals("") && !put.equals(".")) {
            int parsePut = Integer.parseInt(put);
            if (parsePut > 0) {
                while (flag < parsePut) {
                    flag++;
                    factorial *= flag;
                }
                JOptionPane.showMessageDialog
                        (null,
                                "factorial of "
                                        + parsePut + "!  is " + factorial);
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
