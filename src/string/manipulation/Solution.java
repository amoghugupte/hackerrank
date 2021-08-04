package string.manipulation;
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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        if (s.isEmpty ()) return "NO";
        // Write your code here
        int charCount [] = new int [26];
        for (int i = 0; i < s.length (); i++) {
            charCount [s.charAt (i) - 'a']++;
        }

        Arrays.sort (charCount);

        for (int i = 0; i < charCount.length; i++) {
            System.out.print(charCount [i] + " ");
        }
        System.out.println();
        int minIndex = -1;

        for (int i = 0; i < charCount.length; i++) {
            if (charCount [i] != 0) {
                if (minIndex == -1) {
                    minIndex = i;
                    break;
                }
            }
        }
        int min = charCount [minIndex];
        int max = charCount [25];

        if (min == max) return "YES";
        if (max - min > 1) {
            if (min == 1  && charCount [minIndex + 1] == max) return "YES";
            return "NO";
        }
        if (max - min == 1)  {
            if (charCount [minIndex + 1] == min && charCount [24] == max) return "NO";
            else return "YES";
        }

        return "YES";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("I:\\github\\hackerrank\\src\\string\\manipulation\\input13.txt"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
