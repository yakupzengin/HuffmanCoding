import java.io.*;
import java.util.Map;

public class HuffmanEncoder {


    // This method reads the source file, encodes its content using Huffman codes, and writes the encoded text to a new file.
    public static void encodeAndWrite(String sourceFileName, String encodedFileName, Map<String, String> huffmanCodes) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(encodedFileName));
        BufferedReader readerCodes = new BufferedReader(new FileReader(encodedFileName));

        int ch;

        // Reads each character from the source file
        while ((ch = reader.read()) != -1) {

            // Converts the character to a string.
            String character = String.valueOf((char) ch);
            String code = huffmanCodes.get(character);

            // Writes the Huffman code to the encoded file.
            writer.write(code);
        }
        writer.close();


        System.out.print("Encoded : ");
        int ch2;
        while ((ch2 = readerCodes.read()) != -1) {

            // Converts the character to a string.
            String code = String.valueOf((char) ch2);
            System.out.print(code);
        }
        System.out.println();
        System.out.println("Encoded the given txt and writed the coded text into encoded.txt file.");

        reader.close();
    }
}
