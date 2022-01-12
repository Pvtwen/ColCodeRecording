package dataStructure.Leetcode.Match265;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/31 10:37
 */
public class Question5915 {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> idxList=new ArrayList<>();
        ListNode q=head;
        ListNode cur=head.next;
        ListNode p=cur.next;
        int idx=1;
        if(p==null) return new int[]{-1,-1};

        while(p!=null){
            if(cur.val>q.val && cur.val>p.val) idxList.add(idx);
            if(cur.val<q.val && cur.val<p.val) idxList.add(idx);
            q=cur;
            cur=p;
            p=p.next;
            idx++;
        }
        Integer[] arr=new Integer[idxList.size()];
        idxList.toArray(arr);
        int length=arr.length;
        if(length==2) return new int[]{-1,-1};
        int minLength=Integer.MAX_VALUE;

        int[] res=new int[2];
        res[1]=arr[length-1]-arr[0];
        for(int i=1;i<length;i++){
            int len=arr[i]-arr[i-1];
            if(len<minLength) minLength=len;
        }
        res[0]=minLength;
        return res;
    }
}

