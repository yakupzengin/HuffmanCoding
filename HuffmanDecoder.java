import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanDecoder {
    public static void decodeAndWrite(String encodedFileName, String decodedFileName, HuffmanNode root) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(encodedFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFileName));

        HuffmanNode current = root;
        int bit;
        while ((bit = reader.read()) != -1) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                writer.write(current.value);
                current = root;
            }
        }
        System.out.println("Decoded the given txt and writed the decoded text into decoded.txt file.");

        reader.close();
        writer.close();
    }
}
