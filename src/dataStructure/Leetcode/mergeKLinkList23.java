package dataStructure.Leetcode;

import dataStructure.Node.ListNode;

/**
 * @author 86153
 * @data 2021/7/21 11:06
 */
public class mergeKLinkList23 {
    public ListNode mergeKLists(ListNode[] lists){
        return fen(lists,0,lists.length-1);
    }

    public static ListNode fen(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        ListNode node1 = fen(lists, l, mid);
        ListNode node2 = fen(lists, mid + 1, r);
        return zhi(node1,node2);
    }

    public static ListNode zhi(ListNode node1,ListNode node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }

        ListNode node = new ListNode(0);
        ListNode tail=node;
        while(node1!=null && node2!=null){
            if(node1.val<node2.val){
                tail.next=node1;
                node1=node1.next;
            }
            else{
                tail.next=node2;
                node2=node2.next;
            }
            tail=tail.next;
        }

        if(node1!=null){
            tail.next=node1;
        }
        if(node2!=null){
            tail.next=node2;
        }

        return node.next;
    }
}
