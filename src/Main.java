import exercise.Source;
import exercise.RandomTextGenerator;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Source fileHelper = new Source();
        String source = fileHelper.getContent(new File(args[0]));
        String firstWord = args[1];
        String secondWord = args[2];

        RandomTextGenerator randomTextGenerator = new RandomTextGenerator(source);
        String randomString = randomTextGenerator.generate(firstWord, secondWord);

        String start = firstWord + " " + secondWord;

        if (randomString == null) {
            System.out.println("No match to generate a random string starting with '" + start + "'");
        } else {
            System.out.println("RandomTextGenerator generate string start with  '" + start + "'");
            System.out.println("===============================================================");
            System.out.println(randomString);
        }
    }

}
