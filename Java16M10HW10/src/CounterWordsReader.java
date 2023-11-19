import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CounterWordsReader {
    public static void main(String[] args) {
        String fileName = "words.txt";
        counterWords(fileName);
    }
    public static void counterWords(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            Map<String, Integer> wordCounterMap = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words){
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    wordCounterMap.put(word, wordCounterMap.getOrDefault(word, 0) + 1);
                }
            }
            Map<String, Integer> sortedwordCounterMap = wordCounterMap.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, HashMap::new));
            sortedwordCounterMap.forEach((word, counter) -> System.out.println(word + ": " + counter));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
