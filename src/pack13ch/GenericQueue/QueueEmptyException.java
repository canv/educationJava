package pack13ch.GenericQueue;

public class QueueEmptyException extends Exception {
    public String toString(){
        return "\n(Exception message) Queue is empty!";
    }

}