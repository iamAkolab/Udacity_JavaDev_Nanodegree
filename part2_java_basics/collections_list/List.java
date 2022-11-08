/* Task Description:
Please complete the coding exercise for List.

Give a list of strings, all in lowercase, and all start with an alphabet character, please group them based on their first character. If the first character is a, group them in a list 0. If the first character is ‘b’, group them in a list 1; other characters, group them in a list 2.

Example1 : input: {“bcd”, “abc”, “cde”}, output: [{“abc”}, {“bcd”}, {“cde”}]

Example2: Input: List: {“abc”, “bcd”, “bbb”, “ace”, “snb”, “aaaa”, “bbbbb”, “eeee”}
Output: [{“abc”, “ace”, “aaaa”}, {“bcd”, “bbb”, “bbbb”}, {“snb”, “eeee”}]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {

    public static List<String>[] groupString(List<String> input) {
        List<String>[] ans = new List[3];
        for (String in : input) {
            if (in.charAt(0) == 'a') {
                List<String> lst;
                if (ans[0] == null) {
                    lst = new ArrayList<>();
                } else {
                    lst = ans[0];
                }
                lst.add(in);
                ans[0] = lst;
            } else if (in.charAt(0) == 'b') {
                List<String> lst;
                if (ans[1] == null) {
                    lst = new ArrayList<>();
                } else {
                    lst = ans[1];
                }
                lst.add(in);
                ans[1] = lst;
            } else {
                List<String> lst;
                if (ans[2] == null) {
                    lst = new ArrayList<>();
                } else {
                    lst = ans[2];
                }
                lst.add(in);
                ans[2] = lst;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("abc", "bcd", "bbb", "ace", "snb", "aaaa", "bbbbb", "eeee");
        for (List<String> lst : groupString(input)) {
            System.out.println(lst);
            System.out.println();
        }
    }
}
