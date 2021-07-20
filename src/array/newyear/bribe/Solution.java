package array.newyear.bribe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

        List <Integer> q2 = new ArrayList<>();
        int size = q.size();
        for (int i = 0; i< size;i++)
            q2.add(i + 1);

        for (int i = 0; i< size; i++) {
            int diff = getDisplacement (q, q2, i);
            if (diff > 0) {
                bribes = bribes + diff;
                q2 = move(q2, q.get(i), i);
            }

            if (diff > 2) {
                tooChaotic = true;
                bufferedWriter.write("Too chaotic");
                bufferedWriter.newLine();
                return;
            }
        }

        if (tooChaotic) {
            bufferedWriter.write("Too chaotic");
        } else {
            bufferedWriter.write("" + bribes);
        }
        bufferedWriter.newLine();
    }

    static int getDisplacement(List<Integer> q, List<Integer> q2, int i) {
        int num = q.get(i);
        int loc = q2.indexOf(num);
        return loc - i;
    }

    static List <Integer> move (List <Integer> q2, int num, int i) {
        List <Integer> q3 = new ArrayList<>();
        int loc = q2.indexOf(num);
        for (int j = 0 ; j < q2.size (); j++) {
            if (j < i) {
                q3.add(q2.get(j));
            } else if (j == i) {
                q3.add(num);
            } else if (j > i && j <= loc) {
                q3.add(q2.get(j - 1));
            } else if (j > i && j > loc) {
                q3.add(q2.get(j));
            }
        }
        return q3;
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
