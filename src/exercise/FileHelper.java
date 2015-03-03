package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {
    public FileHelper() {}

    public String getContent(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(getSourceFromFile(fileName));
        String content = getTextWithoutPunctuation(scanner);
        return content;
    }

    protected String getTextWithoutPunctuation(Scanner scanner) {
        return scanner.useDelimiter("\\Z").next().    //extract all of the text
                replaceAll("\\n", " ").  //remove the end of line character with a space
                replaceAll("[^a-zA-Z ]", ""). // strip off any character other than letters
                toLowerCase();
    }

    private File getSourceFromFile(String fileName) {
        return new File(FileHelper.class.getResource("../" + fileName).getFile());
    }
}
