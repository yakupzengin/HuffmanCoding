import java.util.HashMap;
import java.util.Map;

class HuffmanTree {


    // This method creates a Huffman tree by merging nodes from a sorted linked list.
    public HuffmanNode createHuffmanTree(LinkedListHuffman list) {

        // Merges nodes until the list has only one node
        while (list.head.next != null) {

            // Extract the two nodes with the lowest frequencies from the linked list.
            HuffmanNode left = list.head.node;
            list.head = list.head.next;

            HuffmanNode right = list.head.node;
            list.head = list.head.next;

            // Create a new node by merging the two extracted nodes.
            HuffmanNode merged = new HuffmanNode(null, left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;

            // Insert the merged node back into the sorted linked list.
            list.insertSorted(merged);
        }
        return list.head.node;
    }

    // This method generates Huffman codes for each leaf node in the Huffman tree.
    public Map<String, String> getHuffmanCodes(HuffmanNode root, String code) {
        Map<String, String> huffmanCodes = new HashMap<>();

        // Call the recursive helper method to generate codes for each leaf node.
        generateCodes(root, code, huffmanCodes);
        return huffmanCodes;
    }


    // Helper method to recursively generate Huffman codes for each leaf node.
    private void generateCodes(HuffmanNode root, String code,  Map<String, String> huffmanCodes) {
        if (root != null) {

            // If the node is a leaf node, add its value and corresponding code to the map.
            if (root.left == null && root.right == null) {
                huffmanCodes.put(root.value, code);
            }

            // Recursively generate codes for the left and right subtrees.
            generateCodes(root.left, code + "0", huffmanCodes);
            generateCodes(root.right, code + "1", huffmanCodes);
        }
    }
}