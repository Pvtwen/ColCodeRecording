package dataStructure.Leetcode.dp.Pack;

/**
 * @author Yawen Cao
 * @data 2021/11/24 10:32
 */
public class Multipack {
    // 二进制优化写法二 B站 https://www.bilibili.com/video/BV1xv411H7ST?from=search&seid=5746018590538583752&spm_id_from=333.337.0.0
    static int N=20010; // log2(2000) * 1000 ≈ 11000
    int[] num;
    int[] v;
    int[] value;
    int[] dp;
    public void dpPack(int n,int V,int[] paramV,int[] paramValue){
        num=new int[n];
        v=new int[N];
        value=new int[N];
        dp=new int[V+1];
        // 第一步先将多个物品直接拆分成01背包问题
        int k=1;
        for(int i=1;i<=n;i++){
            int t=1;
            int temp = num[i];
            while(t<=temp){
                v[k]=t*paramV[i];
                value[k]=t*paramValue[i];
                t*=2;
                temp-=t;
                k++;
            }
            if(temp>0){
                v[k]=temp*paramV[i];
                value[k]=temp*paramValue[i];
                k++;
            }
        }

        //01 pack
        for(int i=1;i<=k;i++){
            for(int j=V;j>=v[i];j--){
                dp[j]=Math.max(dp[j],dp[j-v[i]]+value[i]);
            }
        }
        System.out.println(dp[V]);
    }
    // 二进制优化写法1 牛客网 https://www.nowcoder.com/questionTerminal/6ce78d70a25347058004691035d7540b
//    public void dpPack(int V,int[] num,int[] v,int[] value){
        // 物品数量 体积 价值  V:背包体积
//        int[] dp=new int[V+1];
//        int length = num.length;
//        for(int i=1;i<length;i++){
//            // 完全背包问题
//            if(v[i]*num[i]>=V){
//                for(int j=v[i];j<=V;j++){
//                    dp[j]=Math.max(dp[j],dp[j-v[i]]+value[i]);
//                }
//            }else{
    // 二进制优化 01背包问题
//                int k=1;
//                int temp=num[i];
//                while(k<temp){
//                    int v_tmp=k*v[i];
//                    for(int j=V;j>=v[i];j--){
//                        dp[j]=Math.max(dp[j],dp[j-v_tmp]+k*value[i]);
//                    }
//                    temp-=k;
//                    k*=2;
//                }
//                // 没用完的01背包 剩下temp
//                for(int j=V;j>=temp*v[i];j--){
//                    dp[j]=Math.max(dp[j],dp[j-temp*v[i]]+temp*value[i]);
//                }
//            }
//        }
//        System.out.println(dp[V]);
//    }

    //时间复杂度最高的写法
    public void multiPack(int[] num,int V,int[] v,int[] value){
        int[] dp=new int[V+1];
        int length = num.length;
        for(int i=1;i<length;i++){
            for(int j=V;j>=1;j--){
                for(int k=0;k<=num[i]&&j>=k*v[i];k++){
                    dp[j]=Math.max(dp[j],dp[j-k*v[i]]+k*value[i]);
                }
            }
        }
        System.out.println(dp[V]);
    }
}
