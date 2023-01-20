package dataStructure.Leetcode.dp1.LineStructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/22 11:37
 */
public class Uva11400 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            int[][] arr=new int[n][4];
            int idx=0;
            while(idx<n){
                arr[idx][0]=sc.nextInt();
                arr[idx][1]=sc.nextInt();
                arr[idx][2]=sc.nextInt();
                arr[idx][3]=sc.nextInt();
                idx++;
            }
            solution(arr,n);
            n=sc.nextInt();
        }
    }
    public static void solution(int[][] arr,int n){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] dp=new int[n];
        // 记录前i个灯泡需要的数量
        int[] prefix=new int[n+1];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i][3];
            prefix[i+1]=sum;
        }
        int cost=0;
        for(int i=0;i<n;i++){
            // 这里一定要将dp[i]预定义为这个 因为内层循环是从 1~i全部替换为i这个状态开始. 否则会漏掉一个状态
            dp[i]=prefix[i+1]*arr[i][2]+arr[i][1];
            // j+1到i的灯泡用i的电源 并且用相同数量的i灯泡去替换之
            for(int j=0;j<=i;j++){
                dp[i]=Math.min(dp[i],dp[j]+(prefix[i+1]-prefix[j+1])*arr[i][2]+arr[i][1]);
            }
        }
        System.out.println(dp[n-1]);
    }
}
