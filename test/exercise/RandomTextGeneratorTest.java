package exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomTextGeneratorTest {
    private RandomTextGenerator randomTextGenerator;

    @Before
    public void setUp() {
        randomTextGenerator = new RandomTextGenerator();
    }

    @Test
    public void shouldSingleFollowUpReturnDeterministicOutput() throws Exception {
        String source = "I wish I";
        String start = "I wish";
        String expected = "I wish I";

        TreeMap indexedSource = randomTextGenerator.initialise(source);
        String sentence = randomTextGenerator.generate(indexedSource, start);

        assertEquals(expected, sentence);
    }

    @Test
    public void shouldTwoFollowUpsReturnUnDeterministicOutput() throws Exception {
        String source = "I wish I may I wish I might";
        String start = "I wish";
        String expected1 = "I wish I may I wish I might";
        String expected2 = "I wish I may I wish I may I wish I might";
        String expected3 = "I wish I might";
        String expected4 = "I wish I may I wish I may I wish I may I wish I might";

        TreeMap indexedSource = randomTextGenerator.initialise(source);
        String sentence = randomTextGenerator.generate(indexedSource, start);
        assertTrue(sentence.equals(expected1) || sentence.equals(expected2) || sentence.equals(expected3) || sentence.equals(expected4));
    }

    @Test
    public void shouldNonRepeatedPairReturnDeterministicOutput() throws Exception {
        String source = "I wish I may I wish I might";
        String start = "wish I";
        String expected1 = "wish I may I wish I might";
        String expected2 = "wish I might";
        String expected3 = "wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I might";

        TreeMap indexedSource = randomTextGenerator.initialise(source);
        String sentence = randomTextGenerator.generate(indexedSource, start);
        assertTrue(sentence.equals(expected1) || sentence.equals(expected2) || sentence.equals(expected3));
    }

    @Test
    public void shouldReturnTrueWhenNoMatchForTheStartWordPair() {
        String source = "I wish I may I wish I might";
        TreeMap indexedSource = randomTextGenerator.initialise(source);
        assertFalse(randomTextGenerator.anyMatchForTheStart(indexedSource, "I", "like"));
    }

    @Test
    public void shouldReturnTrueWhenMatchFoundForTheStartWordPair() {
        String source = "I wish I may I wish I might";
        TreeMap indexedSource = randomTextGenerator.initialise(source);
        assertTrue(randomTextGenerator.anyMatchForTheStart(indexedSource, "I", "may"));
    }
}