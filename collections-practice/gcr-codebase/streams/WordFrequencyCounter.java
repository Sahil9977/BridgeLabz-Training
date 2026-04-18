package streams;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "C:\\Eclipse-BT\\src\\streams\\source.txt";  

        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
              
                line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
            return;
        }

        List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("Top 5 most frequently occurring words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
        }
    }
}
