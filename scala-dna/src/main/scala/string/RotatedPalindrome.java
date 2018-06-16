package string;

import java.util.LinkedList;
import java.util.Queue;

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
