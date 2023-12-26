import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
            // Step 1: Reads characters and calculates their frequencies from the letter file.
            Map<String, Integer> frequencies = FrequencyReader.calculateFruquencies("letter.txt");

            // Step 2: Creates a linked list and inserts frequiencies in sorted order.
            LinkedListHuffman linkedList = new LinkedListHuffman();
            for (String key : frequencies.keySet()) {
                linkedList.insertSorted(new HuffmanNode(key, frequencies.get(key)));
            }
            // Displays the characters and their frequencies in the linked list
            System.out.println("Character and their frequiencies");
            linkedList.display();

            // Step 3: Construct the Huffman tree
            HuffmanTree huffmanTree = new HuffmanTree();
            HuffmanNode root = huffmanTree.createHuffmanTree(linkedList);

            // Step 4: Display Huffman codes for each characher
            System.out.println("Huffman codes for each characher");
            Map<String, String> huffmanCodes = huffmanTree.getHuffmanCodes(root, "");
            for (String key : huffmanCodes.keySet()) {
                String value = huffmanCodes.get(key);
                System.out.println(key + " : " + value);
            }


            // Step 5: Encode the source text and write to encoded.txt
            HuffmanEncoder.encodeAndWrite("source.txt", "encoded.txt", huffmanCodes);

            // Step 6: Decode the encoded text and write to decoded.txt
            HuffmanDecoder.decodeAndWrite("encoded.txt", "decoded.txt", root);

        }
    }