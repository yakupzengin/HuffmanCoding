public class Node<T> {
    public HuffmanNode node;
    public Node next;

    public Node(HuffmanNode node){
        this.node=node;
        this.next=null;
    }
}