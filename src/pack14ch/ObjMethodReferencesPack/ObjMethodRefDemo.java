package pack14ch.ObjMethodReferencesPack;

import static packAlternative.AOutput.consoleOut;

interface IntPredicate {
    boolean test(int v);
}

interface MyIntNumPredicate {
    boolean test(MyIntNum mv, int n);
}

class MyIntNum {
    private int val;

    MyIntNum(int val) {
        this.val = val;
    }

    int getNum(){return val;}

    boolean isFactor(int n) {
        return (val % n) == 0;
    }
}

public class ObjMethodRefDemo {
    public static void main(String[] args) {
        IntPredicate ip;

        MyIntNum myNum1 = new MyIntNum(12);
        ip = myNum1::isFactor;
        if(ip.test(3))consoleOut.println("3 is divider " + myNum1.getNum());

        MyIntNum myNum2 = new MyIntNum(16);
        ip = myNum2::isFactor;
        if(!ip.test(3))consoleOut.println("3 is not divider " + myNum2.getNum());


        MyIntNumPredicate inp = MyIntNum::isFactor;

        MyIntNum myNum3 = new MyIntNum(27);
        if(inp.test(myNum3,3))consoleOut.println("3 is divider " + myNum3.getNum());

        MyIntNum myNum4 = new MyIntNum(28);
        if(!inp.test(myNum4,3))consoleOut.println("3 is not divider " + myNum4.getNum());
    }
}