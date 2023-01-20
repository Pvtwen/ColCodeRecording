package dataStructure.Leetcode.NiuKe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/2 9:13
 */
public class KY9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr=new int[n][2];
        int idx=0;
        while(idx<n){
            arr[idx][0]=sc.nextInt();
            arr[idx][1]=sc.nextInt();
            idx++;
        }
        solution(arr,n);
    }
    public static void solution(int[][] arr,int n){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]) return o1[1]-o2[1];
                else {
                    return o1[0]-o2[0];
                }
            }
        });
        for(int i=0;i<n;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}
