package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/6 15:26
 */
public class Uva11059 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Cases=1;
        while(sc.hasNextInt()){
            int i = sc.nextInt();
            int[] arr=new int[i];
            int idx=0;
            while(i>0){
                int i1 = sc.nextInt();
                arr[idx]=i1;
                idx++;
                i--;
            }
            long maxPro = solution(arr);
            System.out.println("Case #"+Cases+": The maximum product is "+maxPro+".");
            System.out.println();
            Cases++;
        }
    }
// break
    public static long solution(int[] arr){
        int length = arr.length;
        // two nested loop
        long ret=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            ret=Math.max(ret,arr[i]);
            long base=arr[i];
            for(int j=i+1;j<length;j++){
                base*=arr[j];
                ret = Math.max(base, ret);
            }
        }
        if(ret<0) return 0;
        return ret;
    }
    // dp
//    public static long solution(int[] arr){
//        int length = arr.length;
//        long[][] dp= new long[length][2];
//        dp[0][0]=arr[0];
//        dp[0][1]=arr[0];
//        long maxVal=Integer.MIN_VALUE;
//        maxVal=Math.max(dp[0][0],dp[0][1]);
//        for(int i=1;i<length;i++){
//            if(arr[i]<0){
//                dp[i][0]=Math.min(dp[i-1][1]*arr[i],arr[i]);
//                dp[i][1]=Math.max(dp[i-1][0]*arr[i],arr[i]);
//            }else{
//                dp[i][0]=Math.min(dp[i-1][0]*arr[i],arr[i]);
//                dp[i][1]=Math.max(dp[i-1][1]*arr[i],arr[i]);
//            }
//            maxVal=Math.max(maxVal,Math.max(dp[i][0],dp[i][1]));
//        }
//        if(maxVal<0) return 0;
//        return maxVal;
//    }
}
