package exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomTextGeneratorTest {

    @Test
    public void shouldSingleFollowUpReturnDeterministicOutput() throws Exception {
        String source = "I wish I";
        String firstWord = "I";
        String secondWord = "wish";
        String expected = "I wish I";

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator(source);
        String sentence = randomTextGenerator.generate(firstWord, secondWord);

        assertEquals(expected, sentence);
    }

    @Test
    public void shouldRepeatedPairReturnUnDeterministicOutput() throws Exception {
        String source = "I wish I may I wish I might";
        String firstWord = "I";
        String secondWord = "wish";
        String expected1 = "I wish I may I wish I might";
        String expected2 = "I wish I may I wish I may I wish I might";
        String expected3 = "I wish I might";
        String expected4 = "I wish I may I wish I may I wish I may I wish I might";
        String expected5 = "I wish I may I wish I may I wish I may I wish I may I wish I might";
        String expected6 = "I wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I may I wish I might";

        String[] expectedVariations = {expected1, expected2, expected3, expected4, expected5, expected6};

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator(source);
        String sentence = randomTextGenerator.generate(firstWord, secondWord);
        System.out.println("print out generated sentence: " + sentence);
        assertTrue(Arrays.asList(expectedVariations).contains(sentence));
    }

    @Test
    public void shouldReturnTrueWhenNoMatchForTheStartWordPair() {
        String source = "I wish I may I wish I might";

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator(source);
        Map indexedSource = randomTextGenerator.getIndexedSource();
        assertFalse(randomTextGenerator.anyMatchForTheStart(indexedSource, "I", "like"));
    }

    @Test
    public void shouldReturnTrueWhenMatchFoundForTheStartWordPair() {
        String source = "I wish I may I wish I might";

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator(source);
        Map indexedSource = randomTextGenerator.getIndexedSource();
        assertTrue(randomTextGenerator.anyMatchForTheStart(indexedSource, "I", "may"));
    }
}