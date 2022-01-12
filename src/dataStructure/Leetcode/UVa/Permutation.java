package dataStructure.Leetcode.UVa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/6 16:33
 * 全排列
 */
public class Permutation {
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        visited= new boolean[i + 1];
        for(int start=1;start<=i;start++){
            visited[start]=true;
            List<Integer> list=new ArrayList<>();
            list.add(start);
            dfs(list,i);
            visited[start]=false;
        }
    }
    static int idx=1;
    public static void dfs(List<Integer> list,int val){
        int flag=-1;
        for(int i=1;i<=val;i++){
            if(!visited[i]){
                flag=1;
                List<Integer> copy=new ArrayList<>(list);
                copy.add(i);
                visited[i]=true;
                dfs(copy,val);
                visited[i]=false;
            };
        }
        // 遍历完
        if(flag==-1){
            System.out.println(idx+++":");
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
