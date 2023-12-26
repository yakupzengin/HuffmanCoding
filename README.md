# Huffman Coding Project With Files

This project implements Huffman coding, a popular algorithm used for lossless data compression. 
The implementation includes the creation of a Huffman tree, encoding and decoding text files, and generating Huffman codes for each character.

## Project Structure

The project consists of the following Java classes:

1. **FrequencyReader:** Reads a text file and calculates the frequency of each character.

2. **LinkedListHuffman:** Implements a sorted linked list to store Huffman nodes based on their frequencies.

3. **HuffmanNode:** Represents a node in the Huffman tree, containing information about the character, frequency, and left/right child nodes.

4. **HuffmanTree:** Creates a Huffman tree by merging nodes from a sorted linked list and generates Huffman codes for each character.

5. **HuffmanEncoder:** Encodes a source text file using Huffman codes and writes the encoded text to a new file.

6. **HuffmanDecoder:** Decodes an encoded file using a Huffman tree and writes the decoded text to a new file.

7. **Test:** Demonstrates the usage of the implemented classes by encoding and decoding a sample text file.

8. **Node:** Generic linked list node used in the LinkedListHuffman class.
