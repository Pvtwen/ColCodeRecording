package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/26 16:06
 */
public class Question376 {
    //dp
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        int[][] dp=new int[length][3];  //[][1]:差值为负 //[][2]:正
        for(int i=0;i<length;i++){
            dp[i][0]=1;
        }
        int ans=1;
        for(int i=0;i<length;i++){
            for(int j=i-1;j>=0;j--){
                int sub=nums[i]-nums[j];
                if(sub>0){
                    dp[i][2]=Math.max(dp[i][2],Math.max(dp[j][1]+1,dp[j][0]+1));
                    ans=Math.max(ans,dp[i][2]);
                }else if(sub<0){
                    dp[i][1]=Math.max(dp[i][1],Math.max(dp[j][2]+1,dp[j][0]+1));
                    ans=Math.max(ans,dp[i][1]);
                }
            }
        }
        return ans;
    }
//    int ans=1;
//    public int wiggleMaxLength(int[] nums) {
//        int length = nums.length;
//        for(int i=0;i+1<length;i++){
//            dfs(nums,0,i,i+1,2);
//        }
//        return ans;
//    }
//    public void dfs(int[] nums,int sub,int preIdx,int curIdx,int len){
//        int subs=nums[curIdx]-nums[preIdx];
//        if(subs==0) return;
//        if(sub>0 && subs>0) return;
//        if(sub<0 && subs<0) return;
//        ans=Math.max(ans,len);
//        for(int i=curIdx+1;i<nums.length;i++){
//            dfs(nums,subs, curIdx, i, len+1);
//        }
//    }
}
