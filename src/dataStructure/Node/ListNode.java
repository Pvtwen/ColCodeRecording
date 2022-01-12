package dataStructure.Node;

/**
 * @author 86153
 * @data 2021/7/21 11:06
 */
  public class ListNode {
      public int val;
      public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }