package array.minimum.swaps2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        while (true) {
            int currSwaps = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != (i + 1)) {
                    swaps++;
                    currSwaps++;
                    swap(arr, i, arr[i] - 1);
                }
            }

            if (currSwaps == 0)
                return swaps;
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0;i < arr.length; i++)
            System.out.print(arr [i] + " ");

        System.out.println();
    }

    static void swap (int [] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    public static void main2(String[] args) {
//        System.out.println(minimumSwaps(new int []{2,3, 4, 1, 5}));
        System.out.println(minimumSwaps(new int []{1,3,5,2,4,6,7}));
    }
}
