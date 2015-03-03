package exercise;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeMap;

public class RandomTextGenerator {

    public TreeMap initialise(String source) {
        Index index = new Index();
        return index.indexing(source);
    }

    public String generate(TreeMap indexedSource, String start) throws Exception {
        StringBuffer output = new StringBuffer();

        String firstWord = start.split(" ")[0];
        String secondWord = start.split(" ")[1];

        if (anyMatchForTheStart(indexedSource, firstWord, secondWord)) {
            return null;
        } else {
            output.append(start);
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

    protected boolean anyMatchForTheStart(TreeMap indexedSource, String firstWord, String secondWord) {
        return getPossibleSuccessorsForPair(indexedSource, firstWord, secondWord) != null;
    }

    private Object bingo(Object[] listOfWords) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(listOfWords.length);
        //System.out.println("generate number: " + randomInt);
        return listOfWords[randomInt];
    }

    private HashSet<String> getPossibleSuccessorsForPair(TreeMap indexedSource, String firstWord, String secondWord) {
        String pairToSearch = firstWord + " " + secondWord;
        return (HashSet<String>) indexedSource.get(pairToSearch);
    }
}
