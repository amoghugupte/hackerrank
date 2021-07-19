package dictionaries.hashmaps.ransom;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note, bufferedWriter);

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note, BufferedWriter bufferedWriter) throws IOException {
        if (note.size() > magazine.size()) {
            bufferedWriter.write("No");
            bufferedWriter.newLine();
            return;
        }

        HashMap <String, Integer> magWordMap = new HashMap<>();
        for (String word: magazine) {
            int count = 1;
            if (magWordMap.containsKey(word)) {
                count = magWordMap.get(word) + 1;
            }

            magWordMap.put(word, count);
        }

        for (String word:note) {
            Integer count = magWordMap.get(word);
            if (count == null || count == 0 ) {
                bufferedWriter.write("No");
                bufferedWriter.newLine();
                return;
            } else {
                magWordMap.put(word, count - 1);
            }
        }

        bufferedWriter.write("Yes");
        bufferedWriter.newLine();
    }
}