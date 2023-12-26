import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {

            // Step 1: Read characters and frequencies from letter.txt
            Map<String, Integer> frequencies = FrequencyReader.readFrequencies("letter.txt");

            // Step 2: Create a linked list and insert frequencies in sorted order
            LinkedListHuffman linkedList = new LinkedListHuffman();
            for (String key : frequencies.keySet()) {
                linkedList.insertSorted(new HuffmanNode(key, frequencies.get(key)));
            }
            System.out.println("Character and their frequiencies");
            linkedList.display();

            // Step 3: Construct the Huffman tree
            HuffmanTree huffmanTree = new HuffmanTree();
            HuffmanNode root = huffmanTree.createHuffmanTree(linkedList);

            // Step 4: Display Huffman codes
            System.out.println("The code of every character");
            Map<String, String> huffmanCodes = huffmanTree.getHuffmanCodes(root, "");
            for (String key : huffmanCodes.keySet()) {
                String value = huffmanCodes.get(key);
                System.out.println(key + ": " + value);
            }
            System.out.println();


            // Step 5: Encode source text and write to encoded.txt
            HuffmanEncoder.encodeAndWrite("source.txt", "encoded.txt", huffmanCodes);

            // Step 6: Decode encoded text and write to decoded.txt
            HuffmanDecoder.decodeAndWrite("encoded.txt", "decoded.txt", root);

        }
    }