package pack13ch.GenericQueue;

public class QueueFullException extends Exception {
    private int size;

    QueueFullException(int size) {this.size = size;}

    public String toString() {
        return "\n (Exception message) Queue is full, max size: " + size + "!";
    }
}