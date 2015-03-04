package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Source {
    public Source() {}

    public String getContent(File sourceFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(sourceFile.getAbsoluteFile());
        String content = getTextWithoutPunctuation(scanner);
        return content;
    }

    protected String getTextWithoutPunctuation(Scanner scanner) {
        return scanner.useDelimiter("\\Z").next().    //extract all of the text
                replaceAll("\\n", " ").  //remove the end of line character with a space
                replaceAll("[^a-zA-Z ]", ""). // strip off any character other than letters
                toLowerCase();
    }
}
