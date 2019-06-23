package VideoLessons.ch2;

public class Lesson12 {
    public static void main(String[] args) {

        double[] arr = {2, 6, 2.3, 77, 0.3};
        int i = 0;
        double sum1 = 0;
        double sum2 = 1;
        while (i < arr.length) {
            sum1 += arr[i];
            i++;
        }
        System.out.println(sum1);


        for (double x : arr) {
            sum2 *= x;
        }
        System.out.println(sum2);
    }
}
