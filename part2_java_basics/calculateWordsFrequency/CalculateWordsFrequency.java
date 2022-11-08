/* Task Description:
Please complete the “words frequency” coding problem.

Give a list of strings, calculate and print the frequency of each string based on alphabetical order.

Example1: input {“abc”, “bcd”, “abc”}, output “abc”|2, “bcd”|1
*/

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class CalculateWordsFrequency {

    public static void calculateWorldsFrequency(List<String> input) {
        TreeMap<String, Integer> freqMap = new TreeMap<>();
        for (String str : input) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }

        for (String word : freqMap.keySet()) {
            System.out.println(word + "|" + freqMap.get(word));
        }
    }

    public static void main(String[] args) {
        calculateWorldsFrequency(Arrays.asList("abc", "bcd", "abc"));
    }
}
