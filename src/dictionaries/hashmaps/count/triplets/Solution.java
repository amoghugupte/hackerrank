package dictionaries.hashmaps.count.triplets;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        HashMap <Long, Long> rightMap = new HashMap<>();
        for (Long num:arr) {
            Long count = 0l;
            if (rightMap.containsKey(num)) {
                count = rightMap.get(num);
            }
            rightMap.put(num, count + 1);
        }

        Long tripCnt = 0l;
        HashMap <Long, Long> leftMap = new HashMap<>();
        for (Long num:arr) {
            Long valLeft = num / r;
            Long valRight = num * r;

            Long count = rightMap.get(num);
            rightMap.put(num, count - 1);

            if (leftMap.containsKey(valLeft) && rightMap.containsKey(valRight)) {
                tripCnt = tripCnt + (leftMap.get(valLeft) * rightMap.get(valRight));
            }

            count = 0l;
            if (leftMap.containsKey(num)) {
                count = leftMap.get(num);
            }
            leftMap.put(num, count + 1);
        }

        return tripCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
