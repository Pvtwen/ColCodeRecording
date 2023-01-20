package dataStructure.Leetcode.dp1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/8 19:44
 */
public class Uva437 {
    static HashMap<String,Integer> map=new HashMap<>();
    static int tot=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            int[][] arr=new int[n][3];
            int idx=0;
            while(idx<n){
                arr[idx][0]=sc.nextInt();
                arr[idx][1] = sc.nextInt();
                arr[idx][2]=sc.nextInt();
                idx++;
            }
            solution(arr);
            tot++;
            map=new HashMap<>();
        }
    }
    public static void solution(int[][] arr){
        int ret=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<3;j++){
                ret=Math.max(ret,dfs(arr,i,j));
            }
        }
        System.out.println("Case "+tot+": maximum height = "+ret);
    }
    // 立方体序号 边序号
    public static int dfs(int[][] arr,int cubeIdx,int edgeIdx){
        String cur=cubeIdx+","+edgeIdx;
        if(map.containsKey(cur)) return map.get(cur);
        int height=arr[cubeIdx][edgeIdx];
        int ans=height;
        int[] v=new int[2];
        int[] v1=new int[2];
        getDimension(arr,v,cubeIdx,edgeIdx);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<3;j++){
                getDimension(arr,v1,i,j);
                // 图中的两个状态联通
                if((v[0]>v1[0] && v[1]>v1[1])||(v[0]>v1[1] && v[1]>v1[0])) ans=Math.max(ans,dfs(arr,i,j)+height);
            }
        }
        map.put(cur,ans);
        return ans;
    }
    // 获取维度
    public static void getDimension(int[][] arr,int[] v,int cuebIdx,int edgeIdx){
        int idx=0;
        for(int k=0;k<3;k++){
            // 选取不是作为高度的边来比较
            if(k!=edgeIdx){
                v[idx++]=arr[cuebIdx][k];
            }
        }
    }
}
