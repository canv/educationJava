package pack9ch.QueueException;

public class QueueEmptyException extends Exception {
    public String toString(){
        return "\n(Exception message) Queue is empty!";
    }

}
