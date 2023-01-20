package dataStructure.Leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/2 10:14
 */
public class P2082 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr=new long[n][2];
        int idx=0;
        while(n>0){
            arr[idx][0]=sc.nextLong();
            arr[idx][1]=sc.nextLong();
            idx++;
            n--;
        }
        solution(arr);
    }
    public static void solution(long[][] arr){
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0]!=o2[0]){
                    return (int) (o1[0]-o2[0]);
                }else{
                    return (int) (o1[1]-o2[1]);
                }
            }
        });
        long temp=arr[0][1]-arr[0][0]+1,sum=0;
        long l=arr[0][0],r=arr[0][1];
        for(int i=1;i<arr.length;i++){
            long a2 = arr[i][0];
            long b2 = arr[i][1];
            if(r>=a2 && r<=b2){
                r=b2;
                temp=r-l+1;
            }else if(a2>r){
                sum+=temp;
                temp=b2-a2+1;
                l=a2;
                r=b2;
            }
        }
        sum+=temp;
        System.out.println(sum);
    }
}
