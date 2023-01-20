package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/6 9:35
 */
public class KY66 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int V = sc.nextInt();
            int n = sc.nextInt();
            int idx=0;
            int[][] sorts=new int[n][2];
            while(idx<n){
                sorts[idx][0]=sc.nextInt();
                sorts[idx][1]=sc.nextInt();
                idx++;
            }
            solution(V,sorts);
        }
    }
    public static void solution(int V,int[][] sorts){
        int n = sorts.length;
        int[][] f=new int[n+1][V+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=V;j++){
                if(j>=sorts[i-1][0]) f[i][j]=Math.max(f[i-1][j-sorts[i-1][0]]+sorts[i-1][1],f[i-1][j]);
                else f[i][j]=f[i-1][j];
            }
        }
        System.out.println(f[n][V]);
    }
}
