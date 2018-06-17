package string;

import java.util.LinkedList;
import java.util.Queue;


/**
 * A palindrome is a string that reads the same forward and backward; for instance “abcdedcba” is a
 * palindrome. A rotated palindrome is a string that reads the same forward and backward, either
 * directly or in any rotation of the string; for instance, “dedcbaabc” is a rotated palindrome,
 * because if the last three letters at the end of the string are rotated to the beginning of the
 * string, it becomes “abcdedcba” which is a palindrome.
 */
public class RotatedPalindrome {

    private static String buildStr(Character[] cs) {
        StringBuilder sb = new StringBuilder();
        for (Character c: cs) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static Boolean isRotated(String input) {

        Queue<Character> q = new LinkedList<>();

        // Make queue from string
        for (char i : input.toCharArray()) {
            q.add(i);
        }

        for (int i = 0; i < input.length(); i++) {

            // Coerce the queue to a character array
            Character[] c = q.toArray(new Character[0]);

            String s = buildStr(c);
            if (Palindrome.isPalindrome(s)) {
                return true;
            }
            char dq = q.remove();
            q.add(dq);
        }
        return false;
    }
}
