package pack14ch;

import static packAlternative.AOutput.consoleOut;

interface MyFuncStr {
    MyClass func (String str);
}
interface MyFuncEmpty {
    MyClass func ();
}
interface MyFuncArr {
    MyClass[] func (int x);
}

class MyClass {
    private String str;

    MyClass (String str){
        this.str = str;
    }

    MyClass (int x){
        consoleOut.println("~(input " + x + " is successful)~");
    }

    MyClass () {
        this.str = "null!";
    }

    public String getStr() { return str; }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {

        MyFuncStr myClassCons = MyClass::new;
        MyClass mc = myClassCons.func("testing!");
        consoleOut.println("str in mc: " + mc.getStr());

        MyFuncEmpty myClassNull = MyClass::new;
        MyClass mce = myClassNull.func();
        consoleOut.println("str in mce: " + mce.getStr());

        MyFuncArr myClassArr = MyClass[]::new;
        MyClass[] mca = myClassArr.func(3);
        consoleOut.println("mca array process:");
        for (int i =0; i<mca.length; i++) mca[i] = new MyClass(i);
    }
}