package dataStructure.luogu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/21 11:07
 */
public class P1763 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        solution(a,b);
    }
    static long[] cur= new long[1000];
    static long[] ans= new long[1000];
    public static void solution(int a,int b){
        Arrays.fill(ans,-1);
        for(int i=0;;i++){
            if(dfs(0,i,getFirst(a,b),a,b)) {
                for(int j=0;j<i;j++){
                    System.out.print(ans[j]+" ");
                }
                System.out.print(ans[i]);
                return;
            }
        }
    }
    // from:分母从from开始枚举 剩下的和为a/b 当前深度为depth
    public static boolean dfs(int depth,int maxDepth,int from,long a,long b){
        if(depth==maxDepth){
            // 如果不是埃及分数 false
            if(b%a!=0) return false;
            cur[depth]=b/a;
            if(better(depth)) ans=Arrays.copyOf(cur,cur.length);
            return true;
        }
        // 剩下maxDepth+1-depth
        boolean ok=false;
        // 不能绝对地从from开始枚举，因为这可能是二次递归之后
        from=Math.max(from,getFirst(a,b));
        for(int i=from;;i++){
            // 题干条件
            if(i>1e7) break;
            // 这里是break 不是return false的原因有两个
            // 1. 如果继续往后枚举 也不可能在剩下的depth内等于a/b
            // 2. 如果是return false，并且在i<from之前已经找到了至少一个解，会产生错误答案
            if(b*(maxDepth+1-depth)<=i*a) break;
            cur[depth]=i;
            long fz=a*i-b;
            long fm=b*i;
            long gcd = gcd(fm,fz);
            if(dfs(depth+1,maxDepth,i+1,fz/gcd,fm/gcd)) ok=true;
        }
        return ok;
    }
    // 找到最小c, 1/c<=a/b
    public static int getFirst(long a,long b){
        for(int i=1;i<=1e7;i++){
            if(a*i>=b) return i;
        }
        return -1;
    }
    public static long gcd(long a,long b){
        while(b!=0){
            long temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
    public static boolean better(int depth){
        for(int i=depth;i>=0;i--){
            if(cur[i]!=ans[i]) return ans[i]==-1 || cur[i]<ans[i];
        }
        return true;
    }
}
