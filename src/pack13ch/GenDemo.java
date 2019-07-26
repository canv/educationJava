package pack13ch;

import java.io.PrintWriter;

class Gen<T> {
    private T object;

    Gen(T object) {
        this.object = object;
    }

    T getObject() {
        return object;
    }

    void showType() {
        GenDemo.consoleOut.println("T type - is " + object.getClass().getName());
    }
}

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> integerObj = new Gen<>(88);
        integerObj.showType();

        int intObj = integerObj.getObject();
        //int intObj = integerObj; - don't work! this is important!

        consoleOut.println("intObj value: " + intObj);

        Gen<String> StringObj = new Gen<>("Generic test");
        StringObj.showType();
        String strObj = StringObj.getObject();
        consoleOut.println("strObj value: " + strObj);
    }

    static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
