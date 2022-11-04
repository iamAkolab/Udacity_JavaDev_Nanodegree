/*
Write a method with a random string input, returns a String containing only vowels.
Example:

Input: “Hello World!” -> output: “eoo”

Input: “Udacity Course” -> output: “Uaioue
*/

public class VowelOnly {
    public static String vowelOnly(String input) {
        String vowel = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (vowel.contains(String.valueOf(c).toLowerCase())) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
