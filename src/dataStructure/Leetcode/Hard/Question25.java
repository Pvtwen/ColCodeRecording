package dataStructure.Leetcode.Hard;

import dataStructure.Leetcode.Match267.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/15 16:20
 */
public class Question25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        List<ListNode> nodeList=new ArrayList<>();
        int idx=1,count=k,num=0;
        ListNode p=head,temp;
        ListNode dummy=new ListNode();
        dummy.next=head;
        temp=dummy;
        while(p!=null){
            num++;
            if(idx==count){
                nodeList.add(temp);
                num=0;
                count+=k;
                temp=p;
            }
            p=p.next;
            idx++;
        }
        ListNode[] arr= new ListNode[nodeList.size()];
        arr= nodeList.toArray(arr);
        for(int i=nodeList.size()-1;i>=0;i--){
            reverse(arr[i],k);
        }
        return head;
    }
    public static void reverse(ListNode head,int k){
        int idx=1;
        ListNode p=head.next,q=p;
        while(p.next!=null && idx<k){
            ListNode r=p.next;
            p.next=r.next;
            head.next=r;
            r.next=q;
            q=r;
            idx++;
        }
    }
}
