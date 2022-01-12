package dataStructure.Leetcode.dp;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/18 18:31
 */
public class Question357 {
    public int countNumbersWithUniqueDigits(int n) {
//        if(n==0) return 1;
//        int[] dp=new int[n+1];
//        dp[1]=9;
//        int sum=10;
//        for(int i=2;i<=n;i++){
//            dp[i]=dp[i-1]*(11-i);
//            sum+=dp[i];
//        }
//        return sum;
        if(n==0) return 1;
        int dp=9;
        int sum=10;
        for(int i=2;i<=n;i++){
            dp=dp*(11-i);
            sum+=dp;
        }
        return sum;
    }

//    static int res=9;
//    public static int countNumbersWithUniqueDigits(int n) {
//        if(n==0) return 1;
//        if(n==1) return 10;
//        if(n==2) return 91;
//        Deque<Integer> queue=new ArrayDeque<>();
//        queue.offer(11);queue.offer(22);queue.offer(33);
//        queue.offer(44);queue.offer(55);queue.offer(66);
//        queue.offer(77);queue.offer(88);queue.offer(99);
//        while(!queue.isEmpty()){
//            Integer value = queue.poll();
//            for(int i=0;i<=9;i++){
//                combine(value,i,queue,n);
//            }
//        }
//        return (int) (Math.pow(10,n)-res);
//    }
//    public static void combine(int value, int partial, Deque<Integer> queue,int n){
//        String str = String.valueOf(value);
//        int length = str.length();
//        if(length==n) return;
//        int partialCount=0;
//        while(value!=0){
//            int rem = value % 10;
//            if(rem==partial) partialCount++;
//            value/=10;
//        }
//        char[] arr = str.toCharArray();
//        for(int i=length-1;i>=0;i--){
//            String string=new String(arr,0,i+1);
//            String string1=new String(arr,i+1,length-i-1);
//            String string2=string+""+partial+""+string1;
//            queue.offer(Integer.parseInt(string2));
//            res++;
//        }
//        if(partial!=0){
//            queue.offer(Integer.parseInt(""+partial+""+str.toString()));
//            res++;
//        }
//        res-=partialCount;
//    }

//    static int res=0;
//    public static int countNumbersWithUniqueDigits(int n) {
//        if(n==0) return 1;
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=1;i<=9;i++){
//            set.add(i);
//            res++;
//            dfs(i,set,n);
//            set.remove(i);
//        }
//        return res+1;
//    }
//    public static void dfs(int val, Set<Integer> set,int n){
//        String str=String.valueOf(val);
//        int length = str.length();
//        if(length==n) return;
//        for(int i=0;i<=9;i++){
//            if(set.contains(i)) continue;
//            String copy=str;
//            set.add(i);
//            copy=str+""+i+"";
//            res++;
//            int value=Integer.parseInt(copy);
//            dfs(value,set,n);
//            set.remove(i);
//        }
//    }
}
