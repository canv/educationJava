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
        consoleOut.println("intObj value: " + intObj);

        Gen<String> stringObj = new Gen<>("Generic test");
        stringObj.showType();
        String strObj = stringObj.getObject();
        consoleOut.println("strObj value: " + strObj);
    }

    static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
