import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner consoleScanner = new Scanner(System.in);
        String filePath = consoleScanner.next();
        Path file = Paths.get(filePath);
        if (!Files.isRegularFile(file) || !Files.isWritable(file)) {
            throw new IllegalArgumentException((filePath + " is not directory or is not writable"));
        }
        Scanner scanner = new Scanner(file);
        Map<String, Integer> statistics = new TreeMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+|[.,?!]+|\\t+|\\n").next().toLowerCase();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
        }
        System.out.println(statistics.toString());

        Integer[] array = statistics.values().toArray(new Integer[0]);
        Arrays.sort(array);

        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            if (array[array.length - 1].equals(entry.getValue())) {
                System.out.println("Слово, которое встречается чаще всего- " + entry.getKey() + " " + array[array.length - 1]);
            }
        }
    }
}
