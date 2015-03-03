import exercise.FileHelper;
import exercise.RandomTextGenerator;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        FileHelper fileHelper = new FileHelper();
        String source = fileHelper.getContent("sample.txt");
        String start = args[0];

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator();
        TreeMap indexedSource = randomTextGenerator.initialise(source);
        String randomString = randomTextGenerator.generate(indexedSource, start);

        if (randomString == null) {
            System.out.println("No match to generate a random string starting with '" + start + "'");
        } else {
            System.out.println("RandomTextGenerator generate string start with  '" + start + "'");
            System.out.println("===============================================================");
            System.out.println(randomString);
        }
    }

}
