package pack13ch.genStackPack;

public class StackFullException extends Exception {

    private int size;

    StackFullException(int size) {this.size = size;}

    public String toString() {
        return "\n (Alert) Stack is full, max size: " + size + "!";
    }
}