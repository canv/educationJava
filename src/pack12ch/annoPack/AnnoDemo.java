
package pack12ch.annoPack;
import java.io.PrintWriter;
import static pack12ch.annoPack.AnnoClass.consoleOut;

@Deprecated
class AnnoClass {
    private String message;

    AnnoClass(String message) {
        this.message = message;
    }

    @Deprecated
    String getMessage() {
        return message;
    }

    @MyAnno(info = "info example", val = 100)
    public static void myMeth() {
    }

    static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}

class AnnoDemo {

    public static void main(String[] args) {

        AnnoClass testObj = new AnnoClass("test");
        consoleOut.println(testObj.getMessage());
    }

}