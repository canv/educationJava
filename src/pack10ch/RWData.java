package pack10ch;

import java.io.*;

public class RWData {
    public static void main(String[] args) {
        int intVal = 10;
        double doubVal = 1023.56;
        boolean boolVal = true;

        try (DataOutputStream dataOut =
                     new DataOutputStream(
                             new FileOutputStream("testRWData"))) {

            System.out.println("Record: " + intVal);
            dataOut.writeInt(intVal);

            System.out.println("Record: " + doubVal);
            dataOut.writeDouble(doubVal);

            System.out.println("Record: " + boolVal);
            dataOut.writeBoolean(boolVal);

            System.out.println("Record: " + 12.2 * 7.4);
            dataOut.writeDouble(12.2 * 7.4);

            System.out.println("Record: " + -1);
            dataOut.writeDouble(-1);

        } catch (IOException exc) {
            System.out.println("Recording error!");
            return;
        }

        try (DataInputStream dataIn =
                     new DataInputStream(
                             new FileInputStream("testRWData"))) {

            intVal = dataIn.readInt();
            System.out.println("\nRead: " + intVal);

            doubVal = dataIn.readDouble();
            System.out.println("Read: " + doubVal);

            boolVal = dataIn.readBoolean();
            System.out.println("Read: " + boolVal);

            doubVal = dataIn.readDouble();
            System.out.println("Read: " + doubVal);

            doubVal = dataIn.readDouble();
            System.out.println("Read: " + doubVal);


        } catch (IOException exc) {
            System.out.println("Reading error!");
        }
    }
}