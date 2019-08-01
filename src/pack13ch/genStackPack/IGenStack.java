package pack13ch.genStackPack;

public interface IGenStack <T> {
    void push (T object)throws StackFullException;
    T pop() throws StackEmptyException;
}