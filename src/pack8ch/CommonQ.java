package pack8ch;

public interface CommonQ {

    void put(char ch);

    default void fullQError() {
        System.out.println(" - Can't save, queue is full");
    }

    char get();

    default void emptyQError() {
        System.out.println("(!) - Can't continue extract, queue is empty");
    }
}
