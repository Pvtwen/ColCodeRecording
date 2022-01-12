package dataStructure.Leetcode.Match270;

/**
 * @author Yawen Cao
 * @data 2021/12/5 10:40
 */
public class Question5943 {
    public ListNode deleteMiddle(ListNode head) {
        int size=0;
        ListNode dummy=head;
        while(dummy!=null){
            size++;
            dummy=dummy.next;
        }
        if(size==1) return null;
        if(size==2){
            head.next=null;
            return head;
        }
        dummy=head;
        int midIdx = size / 2;
        ListNode q = head;
        head=head.next;
        ListNode p=head.next;
        int cur=1;
        while (cur < midIdx) {
            p=p.next;
            head=head.next;
            q=q.next;
            cur++;
        }
        q.next=p;
        return dummy;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }