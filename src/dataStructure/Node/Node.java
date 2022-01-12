package dataStructure.Node;

public class Node {
    public Object val;
    public Node next;

    public Node(Object val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }
}
