package pack13ch;

import java.io.PrintWriter;

class WGen<T extends Number> {
    private T object;

    WGen(T object) {
        this.object = object;
    }

    void absEqual(WGen<?> ob) {
        if (Math.abs(object.doubleValue()) == Math.abs(ob.object.doubleValue()))
            WildcardDemo.consoleOut.println("Absolute values are same");
        else WildcardDemo.consoleOut.println("Absolute values are different");
    }
}

class WildcardDemo {
    public static void main(String[] args) {

        WGen<Integer> integerObj = new WGen<>(6);
        WGen<Double> doubleObj = new WGen<>(-6.0);
        WGen<Long> longObj = new WGen<>(5L);

        integerObj.absEqual(doubleObj);
        integerObj.absEqual(longObj);
    }

    static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
