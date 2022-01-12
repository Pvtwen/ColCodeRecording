package dataStructure.Leetcode.UVa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/6 20:30
 */
public class Subset {
    static boolean[] visited;
    public static void main(String[] args) {
        solution(new int[]{1,2,3});
    }
    public static void solution(int[] arr){
        int length = arr.length;
        visited= new boolean[length];
//        dfs(arr,new ArrayList<>(),0);
//        dfs2(arr);

        int[] pointer=new int[length];
        dfs3(arr,pointer,0);
    }
    // 构造位向量
    public static void dfs3(int[] arr,int[] pointer,int cur){
        // 遍历结束
        if(cur==arr.length){
            System.out.println("subset=");
            for(int i=0;i<arr.length;i++){
                if(pointer[i]==1){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        pointer[cur]=1;
        dfs3(arr,pointer,cur+1);
        pointer[cur]=0;
        dfs3(arr,pointer,cur+1);
    }
    public static void dfs2(int[] arr){
        int length = arr.length;
        int maximum=(1<<length)-1;
        for(int i=0;i<=maximum;i++){
            int idx=length-1;
            int temp=i;
            System.out.println("subset: ");
            while(temp>0){
                int bit = temp & 1;
                if(bit==1){
                    System.out.print(arr[idx]);
                }
                temp>>=1;
                idx--;
            }
            System.out.println();
        }
    }
    static HashSet<Integer> set=new HashSet<>();
    static int num=0;
    public static void dfs1(int[] arr,int val){
        if(!set.contains(val)){
            System.out.println("num="+num);
            set.add(val);
            int temp=val;
            int idx=arr.length-1;
            while(temp>0){
                int bit = temp & 1;
                if(bit==1){
                    System.out.print(arr[idx]+" ");
                }
                temp>>=1;
                idx--;
            }
            System.out.println();
        }
        if(val==(1<<arr.length)-1) return;
        for(int i=0;i<arr.length;i++){
            if(((1<<(arr.length-i-1))&val)==0)
                dfs1(arr,val|(1<<(arr.length-i-1)));
        }
    }
    // 列表中存下标 而不是值!
    public static void dfs(int[] arr, List<Integer> list,int cur){
        System.out.println("subset:");
        for (Integer integer : list) {
            System.out.print(arr[integer]+" ");
        }
        System.out.println();
        // 已经遍历完了
        if(list.size()!=0 && list.get(list.size()-1)==arr.length-1) return;
        int maxIdx;
        if(list.size()!=0){
            maxIdx = list.get(list.size() - 1);
        }else maxIdx=-1;
        for(int i=maxIdx+1;i<arr.length;i++){
            List<Integer> copy=new ArrayList<>(list);
            copy.add(i);
            dfs(arr,copy,cur+1);
        }
    }
}
