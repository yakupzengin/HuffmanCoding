public class Node<T> {
    public HuffmanNode node;
    public Node next;

    public Node(HuffmanNode node){
        this.node=node;
        this.next=null;
    }
    public String toString(){
        return String.valueOf(node);
    }
}