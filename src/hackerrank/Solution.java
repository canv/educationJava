package hackerrank;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer[] aArr = a.toArray(new Integer[0]);
        Integer[] bArr = b.toArray(new Integer[0]);

        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] > bArr[i]) aScore++;
            if (aArr[i] < bArr[i]) bScore++;
        }

        List<Integer> totalScore = new LinkedList<>();
        totalScore.add(aScore);
        totalScore.add(bScore);

        //in future try with Stream API

        return totalScore;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
