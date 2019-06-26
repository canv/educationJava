package pack8ch;

import pack8ch.qpack.ICharQ;

class CQTest implements ICharQ {
    private char[] q;
    private int putloc, getloc;

    CQTest (int size) {
        q = new char[size+1];
        putloc = getloc =0;
    }

    @Override
    public void reset() {

    }

    public void put(char ch) {
        /*очередь считается полной, если индекс putloc на единицу
         * меньше инедкса getloc или если индекс putloc указывает
         * на конец массива, а индекс getloc - на его начало.
         */
        if(putloc+1==getloc | ((putloc==q.length-1) & (getloc==0))){
            System.out.println(" - Queue is full.");
            return;
        }
        putloc++;
       // System.out.println("<"+putloc+">");
        if (putloc==q.length) putloc=0;//перейти в начало массива
        q[putloc]=ch;


    }
    //извлечь символ из очереди
    public char get() {

        if(getloc==putloc){
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        getloc++;
        if(getloc==q.length) getloc=0;//вернутьсь в начало очереди
        System.out.print(" <"+getloc+">=");
        return q[getloc];
    }

}


public class CircularQTest {
    public static void main(String[] args) {
        CQTest qt = new CQTest(10);
        ICharQ iQ = qt;


        for (int i=0; i<10; i++) {
            iQ.put((char)('A'+i));
        }

        for (int i =0; i<10; i++){
            System.out.print(iQ.get());
        }

        for (int i=10; i<20; i++) {
            iQ.put((char)('A'+i));
        }

        for (int i =0; i<10; i++){
            System.out.print(iQ.get());
        }
    }
}
