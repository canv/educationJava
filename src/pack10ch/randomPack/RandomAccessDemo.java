package pack10ch.randomPack;

import java.io.*;

class Support {

    private double[] data;

    Support(double... values) {

        this.data = new double[6];

        for (int i = 0; i < values.length; i++) {
            data[i] = values[i];
        }
    }

    private long truePositionForDouble(int pos) {
        /*
            Since the storage of a double value requires 8 bytes,
        each of the following values begins at the 8-byte boundary of
        the previous value. In other words, the first numeric value
        starts at zero byte, the second at 8-ro byte, the third at 16-ro byte,
        and so on.
            see: book Java8,6thEdition-10chapter page 376
        */
        if (pos == 1) return 0;
        if (pos == 2) return 8;
        return ((pos - 1) * 8);
    }

    void writeInFile(RandomAccessFile raf) throws IOException {
        for (double val : data) raf.writeDouble(val);
    }

    void readInFile(int position, RandomAccessFile raf) throws IOException {
        raf.seek(truePositionForDouble(position));
        System.out.println("The " + position + " position: " + raf.readDouble());
    }

    void showEvenNumbers(RandomAccessFile raf) throws IOException {
        System.out.println("\nReading not even numbered values:");
        for (int i = 0; i < data.length; i += 2) {
            raf.seek(truePositionForDouble(i + 1));
            System.out.print(raf.readDouble() + " ");
        }
    }

    static String myAdress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\myfirstproj\\src\\pack10ch\\randomPack\\";
    }
}

public class RandomAccessDemo {
    public static void main(String[] args) {

        Support data1 =
                new Support(19.4, 10.1, 123.54, 33.0, 87.9, 74.25);

        try (RandomAccessFile randomDAT =
                     new RandomAccessFile(Support.myAdress() + "random.dat",
                             "rw")) {

            data1.writeInFile(randomDAT);

            data1.readInFile(1, randomDAT);
            data1.readInFile(2, randomDAT);
            data1.readInFile(4, randomDAT);
            data1.showEvenNumbers(randomDAT);

        } catch (IOException exc) {
            System.out.println("IO exception: " + exc);
        }
    }
}
