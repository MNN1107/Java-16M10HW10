import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PhoneNumberWriter {

    public static void main(String[] args) {
        String[] phoneNumbers = {"987-123-4567", "123 456 7890", "(123) 456-7890", "(367)-123-4567"};
        String fileName = "file.txt";

        writePhoneNumbersToFile(phoneNumbers, fileName);

    }

    public static void writeFile() {
        File file = new File("file.txt");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }

    public static void writePhoneNumbersToFile(String[] phoneNumbers, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String phoneNumber : phoneNumbers) {
                writer.write(phoneNumber + "\n");
            }
            System.out.println("Номери телефонів записані в файл");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
