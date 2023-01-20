package dataStructure.Leetcode.dp.Easy;

/**
 * @author Yawen Cao
 * @data 2022/1/29 16:51
 */
public class Question53 {
    public int maxSubArray(int[] nums) {
        return dfs(nums,0,nums.length);
    }
    // [l,r)
    public int dfs(int[] nums,int l,int r){
        if(r-l==1) return nums[l];
        int mid=(l+r)/2;
        // 左: [l,mid) 右[mid,r)
        int dL = dfs(nums, l, mid);
        int dR = dfs(nums, mid, r);
        int max = Math.max(dL, dR);
        int val=0,L=nums[mid-1],R=nums[mid];
        for(int i=mid-1;i>=l;i--){
            L=Math.max(L,val+=nums[i]);
        }
        val=0;
        for(int i=mid;i<r;i++){
            R=Math.max(R,val+=nums[i]);
        }
        return Math.max(L+R,max);
    }
    // 贪心
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int ret=Integer.MIN_VALUE;
//        int temp=0;
//        for(int i=0;i<n;i++){
//            temp+=nums[i];
//            if(temp<0){
//                ret=Math.max(ret,temp);
//                temp=0;
//            }else{
//                ret=Math.max(ret,temp);
//            }
//        }
//        return ret;
//    }
//    public int maxSubArray(int[] nums) {
//        int length = nums.length;
//        int[][] dp=new int[length][length];
//
//        int ans=Integer.MIN_VALUE;
//        for(int i=0;i<length;i++){
//            dp[i][i]=nums[i];
//            ans = Math.max(dp[i][i], ans);
//            for(int j=i+1;j<length;j++){
//                dp[i][j]=dp[i][j-1]+nums[j];
//                ans=Math.max(ans,dp[i][j]);
//            }
//        }
//        return ans;
//    }
}
