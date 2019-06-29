package pack9ch;

public class ThrowsDemo {
    private static char prompt()
        throws java.io.IOException{

        System.out.println("Enter a letter: ");
        return (char) System.in.read();
    }

    public static void main(String[] args) {
        char ch;

        try {
            ch = prompt();
        }
        catch (java.io.IOException exc) {
            System.out.println("I/O exception has occurred");
            ch  = 'X';
        }
        System.out.println("You will press " + ch);
    }
}
