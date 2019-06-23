package VideoLessons.ch2;

import javax.swing.*;

public class Lesson7 {
    public static void main(String[] args) {
        String put1, put2;

        put1 = JOptionPane.showInputDialog
                (null,
                        "Enter first positive number.",
                        JOptionPane.QUESTION_MESSAGE);
        if (put1 != null && !put1.equals("")) {
            double put1pars = Double.parseDouble(put1);
            JOptionPane.showMessageDialog
                    (null,
                            "You entered " + put1pars);

            put2 = JOptionPane.showInputDialog
                    (null,
                            "Enter second non-zero number.",
                            JOptionPane.QUESTION_MESSAGE);

            if (put2 != null && !put2.equals("")) {
                double put2pars = Double.parseDouble(put2);

                if (put2pars != 0) {
                    JOptionPane.showMessageDialog
                            (null,
                                    "You entered " + put2pars);
                    JOptionPane.showMessageDialog(null,
                            put1pars + " / " + put2pars +
                                    " = " + (put1pars / put2pars));

                } else JOptionPane.showMessageDialog(null,
                        "This isn't a non-zero number! ");

            } else JOptionPane.showMessageDialog(null,
                    "This isn't a number! ");

        } else JOptionPane.showMessageDialog(null,
                "This isn't a positive number! ");
    }
}
