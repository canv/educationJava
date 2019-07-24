package pack12ch.enumConstructorAndMethodsPack;

import java.io.PrintWriter;

enum Transport {

    CAR(65),
    TRUCK(55),
    AIRPLANE(600),
    TRAIN(70),
    BOAT(22);

    /*
    A semicolon is required if the enum class
    contains other members along with constants.
    */

    private int speed;

    Transport(int speed) {
        this.speed = speed;
    }

    int getSpeed() {
        return speed;
    }
}

public class enumDemo2 {
    public static void main(String[] args) {
        Transport transports1 = Transport.AIRPLANE;
        Transport transports2 = Transport.TRAIN;
        Transport transports3 = Transport.AIRPLANE;

        if (transports1.compareTo(transports2) < 0)
            consoleOut.println(transports1 + " comes before " + transports2);
        if (transports1.compareTo(transports2) > 0)
            consoleOut.println(transports2 + " comes before " + transports1);
        if (transports1.compareTo(transports3) == 0)
            consoleOut.println(transports1 + " is the same as " + transports3);

        consoleOut.println("\nDefault transports speed:\n");
        for (Transport x : Transport.values()) {
            consoleOut.println(x + ": " + x.getSpeed() + " mph");
        }

        consoleOut.println("\nEnum Transport constants and their ordinal values:\n");
        for (Transport x : Transport.values()) {
            consoleOut.println(x + ": " + x.ordinal());
        }
    }

    private static PrintWriter consoleOut =
            new PrintWriter(System.out, true);
}
