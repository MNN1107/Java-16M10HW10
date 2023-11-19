import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserSerialization {
    public static void main(String[] args){
        String inputFileName = "file1.txt";
        String outputFileName = "user.json";

        List<User> userList = readUsersFromFile(inputFileName);
        writeUsersToJsonFile(userList, outputFileName);

        System.out.println("Дані з файлу file1.txt записано у файл user.json");

    }

    private static List<User> readUsersFromFile(String inputFileName){
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))){
            String header = reader.readLine();
            String[] columns = header.split("\\s+");
            String line;
            while ((line = reader.readLine()) != null){
                String[] values = line.split("\\s+");
                User user = new User("", "");
                for (int i = 0; i < columns.length; i++){
                    switch (columns[i]) {
                        case "name":
                            user.setName(values[i]);
                            break;
                        case "age":
                            user.setAge(values[i]);
                            break;
                }
            }
                userList.add(user);

        }
    }catch (IOException e) {
            e.printStackTrace();
        }
        return userList;

}
    private static void writeUsersToJsonFile(List<User> userLists, String outputFileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type listType = new TypeToken<List<User>>() {}.getType();
        String json = gson.toJson(userLists, listType);

        try (Writer writer = new FileWriter(outputFileName)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
