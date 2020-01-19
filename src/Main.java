import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner consoleScanner = new Scanner(System.in);
        String filePath = consoleScanner.next();
        Path file = Paths.get(filePath);
        Scanner scanner = new Scanner(file);
        Map<String, Integer> statistics = new TreeMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+|[.,?!]+|\\t+").next().toLowerCase();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
        }
        System.out.println(statistics.toString());
        int maxCount = 0;
        ArrayList<String> wordWithMaxIter = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
            }
        }

        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            if (maxCount == entry.getValue()) {
                wordWithMaxIter.add(entry.getKey());
            }
        }
        int finalMaxCount = maxCount;
        wordWithMaxIter.forEach(str -> System.out.println("Слово, которое встречается больше всего- " + str + " " + finalMaxCount + " раза"));
    }
}
