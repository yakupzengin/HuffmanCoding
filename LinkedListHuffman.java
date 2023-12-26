class LinkedListHuffman {
    Node<HuffmanNode> head;

    // Inserts a HuffmanNode into the sorted linked list based on frequency.
    public void insertSorted(HuffmanNode newHNode) {
        // Create a new LinkedList Node with the given HuffmanNode.
        Node<HuffmanNode> newNode = new Node<>(newHNode);

        // If the linkedlist is empty or the node's frequency is smaller than the head's frequency,
        // the new linkedlist Node becomes the head.
        if (head == null || newHNode.frequency < head.node.frequency) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<HuffmanNode> iterator = head;
            Node<HuffmanNode> prev = null;

            // Pay attention to the order within the loop!
            while (iterator != null && newHNode.frequency >= iterator.node.frequency) {
                prev = iterator;
                iterator = iterator.next;
            }

            // Insert the new node in the sorted position.
            prev.next = newNode;
            newNode.next = iterator;
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