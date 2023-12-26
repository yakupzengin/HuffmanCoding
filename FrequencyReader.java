import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrequencyReader {
    // This method takes a file name and returns a Map structure that shows
    // how many times each character appears in the file.
    public static Map<String, Integer> readFrequencies(String fileName) throws IOException {

        // Map to stores the frequencies of characters
        Map<String, Integer> frequencies = new HashMap<>();
        // BufferedReader to read the file
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        // Reads the line until end of the line
        while ((line = reader.readLine()) != null) {
            // For each character in the line
            for (char character : line.toCharArray()) {
                String charKey = String.valueOf(character);

                // Updates the frequency of the character in the map
                frequencies.put(charKey, frequencies.getOrDefault(charKey, 0) + 1);
            }
        }
        reader.close();
        // Returns the map of character frequencies
        return frequencies;
    }
}
