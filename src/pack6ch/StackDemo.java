package pack6ch;

class Stack0 {
    private char[] arrKeep;
    private int index;

    Stack0(int size) {
        arrKeep = new char[size];
        index = 0;
    }
    Stack0(char[] makeArr) {
        arrKeep = new char[makeArr.length];

        for (int i = 0; i < makeArr.length; i++)
            push(makeArr[i]);
    }
    Stack0(Stack0 copyThat) {
        index = copyThat.index;
        arrKeep = new char[copyThat.arrKeep.length];

        for (int i = 0; i < index; i++) arrKeep[i] = copyThat.arrKeep[i];
    }

    private void push(char value) {
        if (index == arrKeep.length) {
            System.out.println("-- Stack is full");
            return;
        }
        arrKeep[index] = value;
        index++;
    }
    private char pop() {
        if (index == 0) {
            System.out.println("-- Stack is empty");
            return (char) 0;
        }
        index--;
        return arrKeep[index];
    }

    void showContent() {
        for (int i = 0; i < arrKeep.length; i++) {
            System.out.print(pop());}
        System.out.println();
    }
    void fillArray() {
        for (int i = 0; i < arrKeep.length; i++) {
            push((char) ('A' + i));
        }
    }
}

public class StackDemo {
    public static void main(String[] args) {
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