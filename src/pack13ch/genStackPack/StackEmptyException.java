package pack13ch.genStackPack;

public class StackEmptyException extends Exception {
    public String toString(){
        return "\n(Alert) Stack is empty!";
    }
}