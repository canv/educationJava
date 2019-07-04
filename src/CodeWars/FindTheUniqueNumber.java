//There is an array with some numbers. All numbers are equal except for one. Try to find it!
//
//        Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
//        Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
//        It’s guaranteed that array contains more than 3 numbers.
//
//        The tests contain some very huge arrays, so think about performance.

// Timed Out (16000 ms)
// may be use recursion?

package CodeWars;

public class FindTheUniqueNumber {
    public static void main(String[] args) {
        double[] x1 = {2, 1, 1, 1, 1, 1, 1};
        double[] x2 = {1, 2, 1};
        double[] x3 = {1, 1, 1, 2, 1, 1};
        double[] x4 = {1, 1, 1, 1, 2};
        double[] x5 = {1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 2};

        System.out.println(findUniq(x1));
        System.out.println(findUniq(x2));
        System.out.println(findUniq(x3));
        System.out.println(findUniq(x4));
        System.out.println(findUniq(x5));
    }

    private static double findUniq(double[] arr) {

        int tt;
        for (double value : arr) {
            tt = 0;
            for (double v : arr) {

                if (value != v) tt++;
                if (tt == 2) return value;
            }
        }
        return 404;
    }
}
