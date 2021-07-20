package array.newyear.bribe.bribe;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q, BufferedWriter bufferedWriter) throws IOException {
        // Write your code here
        boolean tooChaotic = false;
        int bribes = 0;
        int size = q.size();
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i< size; i++) {
            int diff = q.get(i) - i - 1;
            if (diff > 2) {
                bufferedWriter.write("Too chaotic");
                bufferedWriter.newLine();
                return;
            }

            for (int j = Math.max(q.get(i) -1, 0); j <= i;j++) {
                if (q.get(j) > q.get(i))
                    bribes += 1;
            }
        }

        if (tooChaotic) {
            bufferedWriter.write("Too chaotic");
        } else {
            bufferedWriter.write("" + bribes);
        }
        bufferedWriter.newLine();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter (System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q, bufferedWriter);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
