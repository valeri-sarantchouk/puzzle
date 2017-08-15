package valeri.palindrome;

/**
 * PalindromeUtils class contains utility methods that handle 'symmetrical' or 'mirror' words and phrases,
 * aka palindromes, e.g.: "kayak", "Able was I ere I saw Elba", "A man, a plan, a canal, Panama!", etc.
 *
 * created August 9, 2017
 * @author Valeri Sarantchouk
 */
public class Palindrome {

    public boolean isMirrorSequence(String s) {
        // check input for nulls and empty strings
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int leftIndex = 0, rightIndex = s.length() - 1; leftIndex < rightIndex;) {
            // skip punctuation marks
            if (!Character.isLetter(s.charAt(leftIndex))) {
                leftIndex++;
                continue;
            }
            if (!Character.isLetter(s.charAt(rightIndex))) {
                rightIndex--;
                continue;
            }

            char leftChar = Character.toLowerCase(s.charAt(leftIndex));
            char rightChar = Character.toLowerCase(s.charAt(rightIndex));

            if (leftChar != rightChar) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
