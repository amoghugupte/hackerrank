package string.manipulation.special.string.again;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s, BufferedWriter bufferedWriter) throws IOException {
        long strCount = 0l;
        long consec = 1l;
        boolean added = false;
        for (int i = 1; i < n; i++) {
            added = false;
            if (s.charAt (i) == s.charAt (i - 1)) {
                consec++;
            } else {
                long count = 0l;
                int finalCount = Math.min (((int)(i + consec)), n - 1);
                for (int j = i + 1 ; j <= finalCount; j++) {
                    if (s.charAt (j) == s.charAt (i -1)) {
                        count ++;
                    } else {
                        break;
                    }
                }

                if (strCount == 0) {
                    strCount = 1;
                }

                strCount = strCount + count + ((consec * (consec + 1))/2);

                //  bufferedWriter.write ("count:" + String.valueOf(count) + "\tfinalCount:" + finalCount + "\ti:" + i + "\tstrCount:" + strCount + "\tconsec:" + consec);
                //  bufferedWriter.newLine();

                added = true;
                consec = 1;
            }
        }

        //bufferedWriter.write ("strCount:" + strCount + "\tconsec:" + consec);
        //bufferedWriter.newLine();

        if (!added && strCount != 0) {
            strCount--;
        }
        if (!added) {
            strCount = strCount + ((consec * (consec + 1))/2);
        }
        //bufferedWriter.write ("strCount:" + strCount + "\tconsec:" + consec);
        //    bufferedWriter.newLine();
        return strCount;
    }


    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s, bufferedWriter);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
