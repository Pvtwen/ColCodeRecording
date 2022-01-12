package dataStructure.Leetcode.easy;

import dataStructure.Leetcode.Match267.ListNode;

/**
 * @author Yawen Cao
 * @data 2021/11/14 16:26
 */
public class Question206Review {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode p=dummy.next;
        ListNode q=p;
        while(p.next!=null){
            ListNode r=p.next;
            p.next=r.next;
            r.next=q;
            dummy.next=r;
            q=r;
        }
        return dummy.next;
    }
}
