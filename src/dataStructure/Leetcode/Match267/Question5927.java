package dataStructure.Leetcode.Match267;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yawen Cao
 * @data 2021/11/14 11:39
 */
public class Question5927 {
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        if(head.next==null) return head;
        //强调：这里不能用哈希表来做 因为哈希表的entry遍历是随机的，但是只有逆序遍历才能保证不乱序
//        HashMap<ListNode,Integer> map=new HashMap<>();

        //list用来存放ListNode
        //list1存放Integer 也就是序列出现的节点的个数
        List<ListNode> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        // 下标从idx=1开始
        int idx=1,count=1,time=2,num=0;
        ListNode q=head,temp=q;
        while(q!=null){
            num++;
            if(idx==count){
                if(num%2==0){
                    list.add(temp);
                    list1.add(num);
                }
                num=0;
                count+=time;
                time++;
                temp=q;
            }
            q=q.next;
            idx++;
        }
        if(num%2==0){
            list.add(temp);
            list1.add(num);
        }
        ListNode[] nodeArr=new ListNode[list.size()];
        Integer[] intArr=new Integer[list1.size()];
        nodeArr = list.toArray(nodeArr);
        intArr= list1.toArray(intArr);
        for(int i=nodeArr.length-1;i>=0;i--){
            reverse(nodeArr[i],intArr[i]);
        }
//        for (Map.Entry<ListNode, Integer> entry : map.entrySet()) {
//            ListNode node = entry.getKey();
//            Integer n = entry.getValue();
//            reverse(node,n);
//        }
        return head;
    }

    // 参考Question206反转链表的思路
    public static void reverse(ListNode head,int i){
        // tail尾指针是head的下一个元素
        ListNode tail=head.next;
        if(tail==null || tail.next==null) return;
        int idx=1;
        while(tail.next!=null && idx<i){
            ListNode p = tail.next;
            ListNode q = head.next;
            tail.next=p.next;
            head.next=p;
            p.next=q;
            idx++;
        }
    }
}
