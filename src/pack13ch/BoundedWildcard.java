package pack13ch;

import java.io.*;

class A {}
class B extends A {}
class C extends A {}
class D {}

class BWGen<T> {

    void testUpBound(BWGen<? extends A> ob) {
        BoundedWildcard.consoleOut.println("Class extended class A");
    }

    void testDownBound(BWGen<? super B> ob) {
        BoundedWildcard.consoleOut.println("Class super class B");
    }
}


class BoundedWildcard {
    public static void main(String[] args) {
        BWGen<A> bw1 = new BWGen<>();
        BWGen<B> bw2 = new BWGen<>();
        BWGen<C> bw3 = new BWGen<>();
        BWGen<D> bw4 = new BWGen<>();

        bw1.testUpBound(bw1);
        bw2.testUpBound(bw2);
        bw3.testUpBound(bw3);
//      bw4.testUpBound(bw4);  // not extend class A

        bw1.testDownBound(bw1);
        bw2.testDownBound(bw2);
//      bw3.testDownBound(bw3); // not super class B
    }
    static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
