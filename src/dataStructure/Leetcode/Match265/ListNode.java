package dataStructure.Leetcode.Match265;

/**
 * @author Yawen Cao
 * @data 2021/10/31 10:48
 */
  public class ListNode {
      int val;

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    ListNode next;
      public ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
