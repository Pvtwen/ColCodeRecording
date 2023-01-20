package dataStructure.Leetcode.NiuKe;
import java.lang.Math;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/6 10:28
 */
public class KY139 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int i=sc.nextInt();
            int idx=0;
            int[][] arr=new int[i][3];
            while(idx<i){
                arr[idx][0]=sc.nextInt();
                arr[idx][1]=sc.nextInt();
                arr[idx][2]=sc.nextInt();
                idx++;
            }
            solution(arr,i);
        }
    }
    public static void solution(int[][] arr,int n){
        int max=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i][2]);
        }
        // 因为每个bg的endtime相互制约 与朴素的01背包中各种'物品'有区别 所以先排序 保证外层循环的每次循环都得到最优解
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int ret=0;
        int[] f=new int[max+1];
        for(int i=0;i<n;i++){
            for(int j=arr[i][2];j-arr[i][1]>=0;j--){
                f[j]=Math.max(f[j-arr[i][1]]+arr[i][0],f[j]);
                ret=Math.max(f[j],ret);
            }
        }
        System.out.println(ret);
    }
}