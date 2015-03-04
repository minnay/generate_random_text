package exercise;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class RandomTextGenerator {
    Map indexedSource;

    public RandomTextGenerator(String source) {
        Index index = new Index();
        indexedSource = index.indexing(source);
    }

    public String generate(String firstWord, String secondWord) throws Exception {
        StringBuffer output = new StringBuffer();

        if (!anyMatchForTheStart(indexedSource, firstWord, secondWord)) {
            return null;
        } else {
            output.append(firstWord + " " + secondWord);
        }

        while (true) {
            HashSet<String> successors = getPossibleSuccessorsForPair(indexedSource, firstWord, secondWord);

            if (successors == null || successors.size() == 0) { // no luck
                break;
            }
            else {
                output.append(" ");

                Object[] listOfSuccessors = successors.toArray();
                String next = bingo(listOfSuccessors).toString();

                output.append(next);

                firstWord = secondWord;
                secondWord = next;

                if (output.toString().split(" ").length > 50) {
                    break;
                }
            }
        }

        return output.toString();
    }

    public Map getIndexedSource() {
        return indexedSource;
    }

    protected boolean anyMatchForTheStart(Map indexedSource, String firstWord, String secondWord) {
        return getPossibleSuccessorsForPair(indexedSource, firstWord, secondWord) != null;
    }

    private Object bingo(Object[] listOfWords) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(listOfWords.length);
        return listOfWords[randomInt];
    }

    private HashSet<String> getPossibleSuccessorsForPair(Map indexedSource, String firstWord, String secondWord) {
        String pairToSearch = firstWord + " " + secondWord;
        return (HashSet<String>) indexedSource.get(pairToSearch);
    }

}
