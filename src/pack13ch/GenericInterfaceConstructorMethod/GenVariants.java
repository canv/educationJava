package pack13ch.GenericInterfaceConstructorMethod;

import static packAlternative.AOutput.consoleOut;

class GImplementer<T> implements Containment<T> {
//  To implement a generic interface, a class must also be generic.

    private T[] maskArray;

    GImplementer(T[] checkedArray) {
        maskArray = checkedArray;
    }

    @Override
    public void showMatches(T checkedVal) {
        for (T x:maskArray)
            if(x.equals(checkedVal)){
                consoleOut.println(checkedVal + " is contained in an array");
                return;}

        consoleOut.println(checkedVal + " is not contained in an array");
    }
}

class Summation {
//  To create of a generic constructor,
//  the class does not have to be generic
    <T extends Number> Summation(T argument) {
        int sum = 0;

        for (int i = 0; i <= argument.intValue(); i++)
            sum += i;

        consoleOut.println("\nSum of numbers from 0 to " +
                argument.intValue() + ": " + sum + "\n");
    }

}

public class GenVariants {
//  To create a generic method also does not need a generic class
    private static <T extends Comparable<T>, V extends T>
    boolean arraysEqual(T[] firstArr, V[] secondArr) {

        if (firstArr.length != secondArr.length) return false;
        for (int i = 0; i < firstArr.length; i++)
            if (!firstArr[i].equals(secondArr[i])) return false;
        return true;
    }

    public static void main(String[] args) {

        Integer[] testArray = {1, 2, 3};
        GImplementer<Integer> checker = new GImplementer<>(testArray);
        checker.showMatches(1);
        checker.showMatches(5);
//      checker.showMatches(9.25); // only Integer!

        Summation argOne = new Summation(4.0);

        Integer[] nums1 = {1, 2, 3, 4, 5};
        Integer[] nums2 = {1, 2, 3, 4, 5};
        Integer[] nums3 = {1, 2,-3, 4, 5};
        Integer[] nums4 = {1, 2, 3, 4, 5, 6};
        if (arraysEqual(nums1, nums1)) consoleOut.println("nums1 equal nums1");
        if (arraysEqual(nums1, nums2)) consoleOut.println("nums1 equal nums2");
        if (arraysEqual(nums1, nums3)) consoleOut.println("nums1 equal nums3");
        if (arraysEqual(nums1, nums4)) consoleOut.println("nums1 equal nums4");
    }
}
