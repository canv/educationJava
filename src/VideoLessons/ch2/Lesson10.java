package VideoLessons.ch2;

import javax.swing.*;

public class Lesson10 {
    public static void main(String[] args) {
        String put;

        do {

            put = JOptionPane.showInputDialog
                    (null,
                            "Enter positive integer number.",
                            JOptionPane.QUESTION_MESSAGE);

            if (put != null && !put.equals("")) {
                int parsePut = Integer.parseInt(put);
                if (parsePut > 0) {
                    JOptionPane.showMessageDialog
                            (null,
                                    "Thank you :)");
                    break;
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

        } while (true);
    }
}
