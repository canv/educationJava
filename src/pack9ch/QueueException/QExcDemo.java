package pack9ch.QueueException;

public class QExcDemo {
    public static void main(String[] args) {
        LineQueue q = new LineQueue(10);

        try{
            q.filling(0,11);
        }catch (QueueFullException e) {
            System.out.println(e);
        }

        try {
            q.extraction(0,11);
        }catch (QueueEmptyException z) {
            System.out.println(z);
        }
    }
}
