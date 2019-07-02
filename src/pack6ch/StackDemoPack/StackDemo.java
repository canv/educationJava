package pack6ch.StackDemoPack;


class Stack0 {
    private char[] arrKeep;
    private int index;

    Stack0(int size) {
        arrKeep = new char[size];
        index = 0;
    }

    Stack0(char[] makeArr) {
        arrKeep = new char[makeArr.length];

        for (char c : makeArr) {
            try {
                push(c);
            }catch (StackFullException exc) {
                System.out.println(exc);
            }
        }
    }

    Stack0(Stack0 copyThat) {
        index = copyThat.index;
        arrKeep = new char[copyThat.arrKeep.length];

        for (int i = 0; i < index; i++) arrKeep[i] = copyThat.arrKeep[i];
    }

    private void push(char value) throws StackFullException {
        if (index == arrKeep.length) {
            throw new StackFullException(arrKeep.length);
        }
        arrKeep[index] = value;
        index++;
    }

    private char pop() throws StackEmptyException {
        if (index == 0) {
           throw new StackEmptyException();
        }
        index--;
        return arrKeep[index];
    }

    void showContent() throws StackEmptyException {
        for (int i = 0; i < arrKeep.length; i++) {
            System.out.print(pop());
        }
        System.out.println();
    }

    void fillArray() {
        try {
            for (int i = 0; i < arrKeep.length; i++) {
                push((char) ('A' + i));
            }
        } catch (StackFullException exc) {
            exc.printStackTrace();
        }
    }

    void errFillArray() {
        try {
            for (int i = 0; i < arrKeep.length+1; i++) {
                push((char) ('A' + i));
            }
        } catch (StackFullException exc) {
            exc.printStackTrace();
        }
    }
}

public class StackDemo {
    public static void main(String[] args) throws StackFullException, StackEmptyException {

        Stack0 stkTest1 = new Stack0(10);
        stkTest1.errFillArray();


        Stack0 stk1 = new Stack0(10);
        stk1.fillArray();

        char[] name = {'T', 'o', 'm'};
        Stack0 stk2 = new Stack0(name);

        Stack0 stk3 = new Stack0(stk1);

        stk1.showContent();
        stk2.showContent();
        stk3.showContent();

    }
}