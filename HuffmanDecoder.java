import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanDecoder {

    // This method reads the encoded file
    // decodes it using a Huffman tree and writes the decoded text to a new file.
    public static void decodeAndWrite(String encodedFileName, String decodedFileName, HuffmanNode root) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(encodedFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFileName));

        HuffmanNode current = root;
        int bit;

        // Read each bit from the encoded file.
        while ((bit = reader.read()) != -1) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            // If a leaf node is reached, write its value to the decoded file
            // and reset the current node to the root.
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
