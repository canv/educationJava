package pack13ch.GenericQueue;

public class GenQueueDemo {
    public static void main(String[] args)
            throws QueueEmptyException, QueueFullException {

        Integer[] intObject = new Integer[6]; // size+1 for correct using queues
        LineQueue<Integer> intLineQueue = new LineQueue<>(intObject, "IntegerLineQueue");
        Integer[] intData = {10, 20, 30, 40, 500};
        intLineQueue.operation(intData);


        LineQueue<String> strLineQueue =
                new LineQueue<>(new String[6], "StringLineQueue");
        strLineQueue.operation(
                new String[]{"Tinky-Winky","Laa-Laa","Dipsy","Po","and HOOVER!"});


        CircularQueue<Character> charCircularQueue =
                new CircularQueue<>(new Character[6],"CharacterLineQueue");
        charCircularQueue.operation(
                new Character[]{'A','B','C','D','E'});
        charCircularQueue.circularPropertyDemo(
                new Character[]{'A','B','C','D','E','F','G','H','I','J'});


        DynamicQueue<Number> numberDynamicQueue =
                new DynamicQueue<>(new Number[4],"NumberDynamicQueue");
        numberDynamicQueue.operation(
                new Number[]{1f,1.5,2,2.5,3,3.5,4L});

        DynamicQueue<String> strDynamicQueue =
                new DynamicQueue<>(new String[4],"StringDynamicQueue");
        strDynamicQueue.operation(
                new String[]{"One","Two","three","four","five","six","seven"});

        DynamicQueue<Character> charDynamicQueue =
                new DynamicQueue<>(new Character[4],"CharacterDynamicQueue");
        charDynamicQueue.operation(
                new Character[]{'A','B','C','D','E','F','G'});


        DynCirQueue<Character> charDynCirQueue =
                new DynCirQueue<>(new Character[4],"CharacterDynCirQueue");
        charDynCirQueue.operation(
                new Character[]{'1','2','3'});

        charDynCirQueue.reset();
        charDynCirQueue.operation(
                new Character[]{'1','2','3','A','B','C','♥'});

        charDynCirQueue.reset();
        charDynCirQueue.circularPropertyDemo(
                new Character[]{'1','2','3','A','B','C','♥','♦','♣','♠','☺'});
    }
}