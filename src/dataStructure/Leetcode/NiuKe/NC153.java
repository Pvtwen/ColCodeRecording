package dataStructure.Leetcode.NiuKe;

/**
 * @author Yawen Cao
 * @data 2022/2/6 15:56
 */
public class NC153 {
    //[[3,4],[2,3],[4,5],[3,6],[2,4],[4,7]]
    int[] dp;
    int len;
    public int maxLetters (int[][] letters) {
        int n = letters.length;
        len=n;
        dp=new  int[n];
        // 邻接矩阵
        int[][] G=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int w1 = letters[i][0];
                int h1 = letters[i][1];
                int w2 = letters[j][0];
                int h2 = letters[j][1];
                if(w1<w2 && h1<h2){
                    G[i][j]=1;
                }
                if(w2<w1 && h2<h1){
                    G[j][i]=1;
                }
            }
        }
        int ret=1;
        for(int i=0;i<n;i++){
            ret=Math.max(ret,dfs(letters,G,i));
        }
        // self-define
        // 打印字典序
        //1. 找到最大的dp[i]
        int maxVal=dp[0];
        int maxIdx=0;
        for(int i=1;i<n;i++){
            // 为了找到最小的字典序 必须保证i由小到大，且不小于maxVal
            if(dp[i]>maxVal){
                maxVal=dp[i];
                maxIdx=i;
            }
        }
        int[] routes=new int[maxVal];
        print_ans(G,maxIdx,routes,0);
        return ret;
    }
    //《算法》P263
    public void print_ans(int[][] G,int i,int[] routes,int idx){
        routes[idx]=i;
        // 因为下标事先确定，或者说需要经过if的判断才能继续递归，所以到不了routes.length
        // 所以事先判断idx==length-1;打印路径
        if(idx==routes.length-1){
            for(int k=0;k<routes.length;k++){
                System.out.print(routes[k]+"---");
            }
            System.out.println();
            return;
        }
        for(int j=0;j<len;j++){
            if(G[i][j]==1 && dp[j]+1==dp[i]) {
                print_ans(G,j,routes,idx+1);
//                break;
            }
        }
    }
    public int dfs(int[][] letters,int[][] G,int i){
        if(dp[i]>0) return dp[i];
        int sum=1;
        for(int j=0;j<letters.length;j++){
            if(G[i][j]==1) sum=Math.max(sum,dfs(letters,G,j)+1);
        }
        dp[i]=sum;
        return sum;
    }
}
