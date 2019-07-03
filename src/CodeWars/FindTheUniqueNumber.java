//There is an array with some numbers. All numbers are equal except for one. Try to find it!
//
//        Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
//        Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
//        It’s guaranteed that array contains more than 3 numbers.
//
//        The tests contain some very huge arrays, so think about performance.

package CodeWars;

public class FindTheUniqueNumber {
    public static void main(String[] args) {
        double[] x1 = {1, 2, 1};
        double[] x2 = {1, 1, 1, 2, 1, 1};
        double[] x3 = {2, 1, 1, 1, 1, 1, 1};
        double[] x4 = {1, 1, 1, 1, 2};

        System.out.println(findUniq(x1));
        System.out.println(findUniq(x2));
        System.out.println(findUniq(x3));
        System.out.println(findUniq(x4));
    }

    private static double findUniq(double arr[]) {
        double a = arr[0];
        int aCount = 0;
        double b = arr[1];
        int bCount = 0;
        double outsider = 0;
        int ontCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int z = 1; z < arr.length; z++) {

                if ((arr[i] == arr[z])) {
                    outsider = arr[i];
                }
                if (arr[i] != arr[z]) {
                    if (arr[i] == outsider) return arr[z];
                    else return arr[i];
                }

            }
        }

        return arr[0];

//                if (arr[i] != arr[z]) {
//                    a = arr[i];
//                    aCount++;
//                    b = arr[z];
//                    bCount++;
//                }



//                if (arr[i] == b) {
//                    bCount++;
//                }

//                if (bCount > 1) return a;
//                if (aCount > 1) return b;
    }
}
