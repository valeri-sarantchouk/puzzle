package valeri.palindrome;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PalindromeTest {

    private Palindrome fixture;

    @Before
    public void setUp() {
        fixture = new Palindrome();
    }

    // negative test with null input
    @Test
    public void testIsMirrorSequenceWithNull() {
        boolean isMirrorSequence = fixture.isMirrorSequence(null);
        assertThat(isMirrorSequence, is(false));
    }

    // negative test with empty string input
    @Test
    public void testIsMirrorSequenceWithEmptyString() {
        boolean isMirrorSequence = fixture.isMirrorSequence("");
        assertThat(isMirrorSequence, is(false));
    }

    // negative test with a single word (no spaces) that is not a palindrome
    @Test
    public void testIsMirrorSequenceWithInvalidString() {
        boolean isMirrorSequence = fixture.isMirrorSequence("canoe");
        assertThat(isMirrorSequence, is(false));
    }

    // positive test with a single palindrome word (no spaces)
    @Test
    public void testIsMirrorSequenceWithValidWord() {
        boolean isMirrorSequence = fixture.isMirrorSequence("kayak");
        assertThat(isMirrorSequence, is(true));
    }

    // positive test with a palindrome phrase (with spaces)
    // expecting spaces to be mirrored as well
    // TODO: clarify Capitalization rules with business
    @Test
    public void testIsMirrorSequenceWithValidPhrase() {
        String testString = "Able was I ere I saw Elba";
        boolean isMirrorSequence = fixture.isMirrorSequence(testString);
        assertThat(isMirrorSequence, is(true));
    }

    // positive test with a palindrome phrase (with spaces)
    // expecting spaces to be mirrored as well
    // TODO: clarify punctuation rules with business
    @Test
    public void testIsMirrorSequenceWithValidPhrasePunctuation() {
        String testString = "A man, a plan, a canal, Panama!";
        boolean isMirrorSequence = fixture.isMirrorSequence(testString);
        assertThat(isMirrorSequence, is(true));
    }

    // positive test with a numeric palindrome string (no spaces)
    @Test
    public void testIsMirrorSequenceWithNumbericString() {
        boolean isMirrorSequence = fixture.isMirrorSequence("12321");
        assertThat(isMirrorSequence, is(true));
    }

}
