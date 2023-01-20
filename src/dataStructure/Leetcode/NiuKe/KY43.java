package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/7 14:15
 */
public class KY43 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        solution(s);
    }
    public static void solution(String s){
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] visited=new int[30];
        dfs(s,0,arr,visited);
    }
    // cur:当前位置
    public static void dfs(String s,int cur,char[] arr,int[] visited){
        if(cur==s.length()){
            String ret = new String(arr, 0, arr.length);
            System.out.println(ret);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(visited[c-'a']==0){
                arr[cur]=c;
                visited[c-'a']=1;
                dfs(s,cur+1,arr,visited);
                visited[c-'a']=0;
            }else continue;
        }
    }
}
