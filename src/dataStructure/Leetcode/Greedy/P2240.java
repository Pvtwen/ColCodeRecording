package dataStructure.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/1 10:29
 */
public class P2240 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[][] arr= new int[N][2];
        int idx=0;
        while(N>0){
            arr[idx][0]=sc.nextInt();
            arr[idx][1]=sc.nextInt();
            N--;
            idx++;
        }
        solution(arr,T);
    }
    public static void solution(int[][] arr,double T){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[1]*o2[0]-o2[1]*o1[0]);
            }
        });
        double val=0;
        for(int i=0;i<arr.length;i++){
            if(T>=arr[i][0]){
                T-=arr[i][0];
                val+=arr[i][1];
            }else if(T<arr[i][0] && T>0){
                // 总价值
                double v = ((double)arr[i][1]/arr[i][0]*T);
                val+=v;
                break;
            }
        }
        String format = String.format("%.2f", val);
        System.out.println(format);
    }
}
