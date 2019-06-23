package pack5ch;

public class HomeWork3 {
    public static void main(String[] args) {
        double[] arr = {1, 12,
                457, 55.5,
                4574, 4,
                -3, -443.3,
                14.88, -1};
        double sum = 0;

        for(double x: arr) sum+=x;

        System.out.println("Arithmetical mean of array: " + sum / arr.length);


    }
}
