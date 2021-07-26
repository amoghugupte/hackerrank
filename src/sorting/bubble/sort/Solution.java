package sorting.bubble.sort;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a, BufferedWriter bufferedWriter) throws IOException {
        int size = a.size();
        Integer [] arr = new Integer[size];
        a.toArray(arr);
        int swaps = 0;
        for (int i = 0; i < size; i++) {
            int low = arr[i];
            for (int j = i; j < size; j++) {
                if (low > arr [j]) {
                    swaps++;
                    int tmp = arr [j];
                    arr [j] = low;
                    low = tmp;
                }
            }
            arr[i] = low;
        }

        bufferedWriter.write("Array is sorted in " + swaps + " swaps.");
        bufferedWriter.newLine();
        bufferedWriter.write("First Element: " + arr [0]);
        bufferedWriter.newLine();
        bufferedWriter.write("Last Element: " + arr [size -1]);
        bufferedWriter.newLine();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.countSwaps(a, bufferedWriter);
        bufferedReader.close();
        bufferedWriter.close();
    }
}
