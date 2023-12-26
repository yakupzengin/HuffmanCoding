class LinkedListHuffman {
    Node<HuffmanNode> head;

    // Inserts a HuffmanNode into the sorted linked list based on frequency.
    public void insertSorted(HuffmanNode node) {

        // Create a new LinkedList Node with the given HuffmanNode.
        Node<HuffmanNode> newNode = new Node<>(node);

        // If the linkedlist is empty or the node's frequency is smaller than the head's frequency,
        // the new linkedlist Node becomes the head.
        if (head == null || node.frequency < head.node.frequency) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<HuffmanNode> current = head;
            Node<HuffmanNode> prev = null;

            while (current != null && node.frequency >= current.node.frequency) {
                prev = current;
                current = current.next;
            }

            // Insert the new node in the sorted position.
            prev.next = newNode;
            newNode.next = current;
        }
    }

    // Displays the values and frequencies of nodes in the linked list.
    public void display(){
        Node<HuffmanNode> iterator = head;
        while(iterator !=null){
            System.out.println("-> Values: " + iterator.node.value+ " & " +"frequency: " + iterator.node.frequency+ " ");
            iterator = iterator.next;
        }
        System.out.println();
    }
}