package dataStructure.Leetcode;

import dataStructure.Node.ListNode;

/**
 * @author 86153
 * @data 2021/7/26 10:01
 * 反转链表
 */
public class Question206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode node=head;
        ListNode p=new ListNode();
        ListNode q=new ListNode();

        while(node.next!=null){
            node=node.next;
        }
        while(node!=head){
            p=node.next;
            q=head;
            head=head.next;
            q.next=p;
            node.next=q;
        }
        return head;
    }
}
