package exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;


public class IndexTest {
    Index index;

    @Before
    public void setUp() {
       index = new Index();
    }

    @Test
    public void testIndexingSourceWithASingleFollowingWord() throws Exception {
        String source = "I wish";

        TreeMap output = index.indexing(source);

        HashSet<String> possibleWordsForIWish = (HashSet<String>) output.get("I wish");
        assertTrue(possibleWordsForIWish.size() == 0);
    }

    @Test
    public void testIndexingSourceWithNoRepeatedPairs() throws Exception {
        String source = "I wish I may I might";
        TreeMap output = index.indexing(source);

        HashSet<String> possibleWordsForIWish = (HashSet<String>) output.get("I wish");
        assertTrue(possibleWordsForIWish.size() == 1);
        assertTrue(possibleWordsForIWish.contains("I"));
    }

    @Test
    public void testIndexingSourceWhenAWordHasMultipleSuccessors() throws Exception {
        String source = "I wish I may I wish I might";
        TreeMap output = index.indexing(source);

        HashSet<String> possibleWordsForWishI = (HashSet<String>) output.get("wish I");
        assertTrue(possibleWordsForWishI.size() == 2);
        assertTrue(possibleWordsForWishI.contains("may"));
        assertTrue(possibleWordsForWishI.contains("might"));
    }

    @Test
    public void testIndexingSourceWhenAWordHasNoSuccessors() throws Exception {
        String source = "I wish I may I wish I might";
        TreeMap output = index.indexing(source);

        HashSet<String> possibleWordsForIMight = (HashSet<String>) output.get("I might");
        assertTrue(possibleWordsForIMight.size() == 0);
    }

    @Test
    public void testIndexingSourceWithAPairIsAtTheEndAndWithASuccessor() throws Exception {
        String source = "I wish I";
        TreeMap output = index.indexing(source);

        HashSet<String> possibleWordsForIWish = (HashSet<String>) output.get("I wish");
        assertTrue(possibleWordsForIWish.size() == 1);
        assertTrue(possibleWordsForIWish.contains("I"));
    }

    @Test
    public void testIndexingSourceWhenAPairIsAtTheEndAndWithSuccessors() throws Exception {
        String source = "I wish I may I wish I may";
        TreeMap output = index.indexing(source);

        HashSet<String> possibleWordsForIMight = (HashSet<String>) output.get("I may");
        assertTrue(possibleWordsForIMight.size() == 1);
    }
}