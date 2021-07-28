package sorting.fraudulent.activity.notifications;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int countSort [] = new int [201];
        for (int i = 0 ; i < d ; i++) {
            countSort [expenditure.get (i)]++;
        }

        int countNoti = 0;
        for (int i = d; i < expenditure.size (); i++) {
            int num = expenditure.get (i);
            int median = getMedian (countSort, d);
            if (num >= median) {
                countNoti++;
            }

            countSort [expenditure.get (i - d)]--;
            countSort [expenditure.get (i)]++;
        }
        return countNoti;
    }

    static int getMedian (int countSort [], int d) {
        if (d % 2 == 1) {
            int i1 = d/2;

            int m1 = 0;
            for (int i = 0, k = 0; i < countSort.length; i++) {
                k = k + countSort [i];
                if (k > i1) {
                    m1 = i;
                    break;
                }
            }

            return 2 * m1 ;
        } else {
            int i1 = d/2;
            int m1 = 0;

            for (int i = 0, k = 0; i < countSort.length; i++) {
                k = k + countSort [i];
                if (k > i1) {
                    m1 = i;
                    break;
                }
            }

            int i2 = i1 - 1;
            int m2 = 0;
            for (int i = 0, k = 0; i < countSort.length; i++) {
                k = k + countSort [i];
                if (k > i2) {
                    m2 = i;
                    break;
                }
            }

            return m1 + m2;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
