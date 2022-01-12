package dataStructure.Leetcode.easy;

import dataStructure.Node.ListNode;
/**
 * @author 86153
 * @data 2021/8/9 14:14
 */
public class Question141 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=null && fast!=null){
            if(slow==fast){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}