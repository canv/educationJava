package pack12ch;

import java.io.PrintWriter;

enum Transport{
    CAR, TRUCK, AIRPLANE, TRAIN, BOAT
}

public class EnumDemo {
    public static void main(String[] args) {

        Transport transportEnum;

        transportEnum = Transport.TRAIN;
        consoleOut.println("\ntransportEnum = Transport.TRAIN: " + transportEnum);

        transportEnum = Transport.valueOf("AIRPLANE");
        consoleOut.println("\ntransportEnum = Transport.valueOf(\"AIRPLANE\"): " + transportEnum);

        switch (transportEnum){
            case CAR:
                consoleOut.println("\nswitch (transportEnum) case CAR");
                break;
            case TRUCK:
                consoleOut.println("\nswitch (transportEnum) case TRUCK");
                break;
            case AIRPLANE:
                consoleOut.println("\nswitch (transportEnum) case AIRPLANE");
                break;
            case TRAIN:
                consoleOut.println("\nswitch (transportEnum) case TRAIN");
                break;
            case BOAT:
                consoleOut.println("\nswitch (transportEnum) case BOAT");
                break;
        }

        consoleOut.println("\nfor (Transport x:Transport.values()):");
        for (Transport x:Transport.values())
            consoleOut.println(x);

    }
    private static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
