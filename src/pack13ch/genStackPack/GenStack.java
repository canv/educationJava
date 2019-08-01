package pack13ch.genStackPack;

import static packAlternative.AOutput.consoleOut;

class Stack<T> implements IGenStack<T> {
    private T[] stackArr;
    private int index;

    Stack(T[] makeEmptyArr) {

        stackArr = makeEmptyArr;
        index = 0;
    }

    Stack(T[] makeFillArr, T[]than) {
        stackArr = makeFillArr;

        for (T x : than) {
            try {
                push(x);
            } catch (StackFullException exc) {
                consoleOut.println(exc);
            }
        }
    }

    Stack(T[] makeCopyArr, Stack<T> object) {
        index = object.index;
        stackArr = makeCopyArr;

        try {
            if (stackArr.length < object.stackArr.length)
                throw new StackFullException(stackArr.length);
        }catch (StackFullException exc) {
            consoleOut.println(exc);
        }

        for (int i =0; i < index; i++)
            stackArr[i]=object.stackArr[i];
    }

    @Override
    public void push(T object) throws StackFullException {
        if (index == stackArr.length) {
            throw new StackFullException(stackArr.length);
        }
        stackArr[index] = object;
        index++;
    }

    @Override
    public T pop() throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }
        index--;
        return stackArr[index];
    }

    void showContent() throws StackEmptyException {
        for (int i = 0; i < stackArr.length; i++) {
            consoleOut.print(pop() + " ");
        }
        consoleOut.println();
    }
}

public class GenStack {
    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>(new Integer[10]);
        try {
            for (int i = 0; i < 10; i++) {
                stack1.push(i);
            }
        } catch (StackFullException exc) {
            consoleOut.println(exc);
        }

        String[] name = {"One","Two","Three"};
        Stack<String> stack2 = new Stack<>(new String[3],name);

        Stack<Integer> stack3 = new Stack<>(new Integer[10],stack1);

        Stack<?> stack4 = new Stack<>(new String[3],stack2);

        try {
            stack1.showContent();
            stack2.showContent();
            stack3.showContent();
            stack4.showContent();
        } catch (StackEmptyException exc) {
            consoleOut.println(exc);
        }
    }
}