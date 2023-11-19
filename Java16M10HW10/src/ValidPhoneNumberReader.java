import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidPhoneNumberReader {
    public static void main(String[] args){
        String fileName = "file.txt";
        validPhoneNumbers (fileName);

    }
    public static void validPhoneNumbers(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String phoneNumber;
            while ((phoneNumber = reader.readLine()) != null) {
                    if (isValidPhoneNumber(phoneNumber)) {
                        System.out.println(phoneNumber);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isValidPhoneNumber(String phoneNumber){
        String numberRegex1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        String numberRegex2 = "\\d{3}-\\d{3}-\\d{4}";

        Pattern pattern1 = Pattern.compile(numberRegex1);
        Pattern pattern2 = Pattern.compile(numberRegex2);

        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);

        return matcher1.matches() || matcher2.matches();
    }
}
