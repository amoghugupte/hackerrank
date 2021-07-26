package dictionaries.hashmaps.frequency.queries;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> ds = new HashMap<>();
        Map<Integer, Set<Integer>> dsOccurance = new HashMap<>();
        for (List<Integer> query:queries) {
            Integer commandType = query.get(0);
            Integer commandData = query.get(1);

            if (commandType == 1) {
                int count = 0;
                if (ds.containsKey(commandData)) {
                    count = ds.get(commandData);
                }

                if (dsOccurance.containsKey(count)) {
                    dsOccurance.get(count).remove(commandData);
                }
                ds.put(commandData, count + 1);


                if (dsOccurance.containsKey(count + 1)) {
                    dsOccurance.get(count + 1).add (commandData);
                } else {
                    Set<Integer> newSet = new HashSet<>();
                    newSet.add(commandData);
                    dsOccurance.put(count + 1, newSet);
                }
            } else if (commandType == 2) {
                if (ds.containsKey(commandData)) {
                    int count = ds.get(commandData);


                    if (dsOccurance.containsKey(count)) {
                        dsOccurance.get(count).remove(commandData);
                    }

                    if (count - 1 == 0) {
                        ds.remove(commandData);
                    } else {
                        ds.put(commandData, count -1);
                        if (dsOccurance.containsKey(count - 1)) {
                            dsOccurance.get(count - 1).add(commandData);
                        } else {
                            Set<Integer> newSet = new HashSet<>();
                            newSet.add(commandData);
                            dsOccurance.put(count - 1, newSet);
                        }
                    }
                }
            } else if (commandType == 3) {
                if (dsOccurance.containsKey(commandData) && !dsOccurance.get(commandData).isEmpty()) {
                    output.add(1);
                } else {
                    output.add(0);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
