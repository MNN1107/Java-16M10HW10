import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WordsWriter {
    public static void main(String[] args){
        String fileName = "words.txt";
        writeFile(fileName);
        writeWordsToFile(fileName);
        System.out.println("Слова записані в файл: " + fileName);
    }
    public static void writeFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public static void writeWordsToFile (String fileName){
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("the day is sunny the the");
            writer.println("the sunny is Day is");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
