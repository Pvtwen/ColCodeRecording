package dataStructure.Leetcode.dp1.LineStructure;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/22 17:26
 */
public class Uva1625 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        int idx=0;
        while(idx<i){
            String a = sc.next();
            String b = sc.next();
            solution(a,b);
            idx++;
        }
    }
    static int INF=Integer.MAX_VALUE;
    public static void solution(String a,String b){
        int[] sa,sb,ea,eb;
        int lena = a.length();
        int lenb = b.length();
        // 记录每个字符的开始结束位置 sa:字符在a的开始位置
        sa=new int[26];
        sb=new int[26];
        ea=new int[26];
        eb=new int[26];
        for(int i=0;i<26;i++){
            sa[i]=sb[i]=INF;
            ea[i]=eb[i]=0;
        }
        for(int i=0;i<lena;i++){
            char c = a.charAt(i);
            sa[c-'A']=Math.min(sa[c-'A'],i+1);
            ea[c-'A']=i+1;
        }
        for(int i=0;i<lenb;i++){
            char c = b.charAt(i);
            sb[c-'A']=Math.min(sb[c-'A'],i+1);
            eb[c-'A']=i+1;
        }
        int[][] cnt=new int[lena+1][lenb+1];
        for(int i=0;i<=lena;i++){
            for(int j=0;j<=lenb;j++){
                if(i!=0){
                    char c = a.charAt(i-1);
                    cnt[i][j]=cnt[i-1][j];
                    if(i==sa[c-'A'] && j<sb[c-'A']) cnt[i][j]++;
                    if(i==ea[c-'A'] && j>=eb[c-'A'])cnt[i][j]--;
                }
                if(j!=0){
                    char c = b.charAt(j - 1);
                    cnt[i][j]=cnt[i][j-1];
                    if(j==sb[c-'A'] && i<sa[c-'A']) cnt[i][j]++;
                    if(j==eb[c-'A']&& i>=ea[c-'A']) cnt[i][j]--;
                }
            }
        }
        int[][] dp=new int[lena+1][lenb+1];
        for(int i=0;i<=lena;i++){
            for(int j=0;j<=lenb;j++){
                if(i==0 && j==0)continue;
                dp[i][j]=INF;
                if(i!=0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+cnt[i-1][j]);
                }
                if(j!=0){
                    dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+cnt[i][j-1]);
                }
            }
        }
        System.out.println(dp[lena][lenb]);
    }
}
