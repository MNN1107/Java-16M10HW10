import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class UserWriter {
    public static void main(String[] args) {

        String fileName = "file1.txt";
        writeFile(fileName);
        writeUsersToFile(fileName);
        System.out.println("Дані записані в файл: " + fileName);
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

    public static void writeUsersToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("name age");
            writer.println("alice 21");
            writer.println("ryan 30");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}