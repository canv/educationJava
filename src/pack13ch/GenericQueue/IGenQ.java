package pack13ch.GenericQueue;

public interface IGenQ<T> {

    void put(T val) throws QueueFullException;

    T get() throws QueueEmptyException;
}