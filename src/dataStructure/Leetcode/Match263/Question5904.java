package dataStructure.Leetcode.Match263;

public class Question5904 {
	public static int countMaxOrSubsets(int[] nums) {
		int max = 0;
		int length = nums.length;
		int size = 1 << length;
		int[] dp = new int[size];

		for (int num : nums) {
			max |= num;
		}

		return dfs(nums,0,0,max,0);
	}

	public static int dfs(int[] nums,int val, int idx, int max,int sum){
		// 超出数组长度 剪枝
		// 中间某时刻已经到达最大值  再往后遍历都不可能超过这个最大值  剪枝
		if(val==max){
			sum+=(1<<(nums.length-idx));
			return sum;
		}
		if(idx==nums.length) return sum;
		return dfs(nums,val,idx+1,max,sum)+dfs(nums,val|nums[idx],idx+1,max,sum);
	}

//	public static void dfs(int[] nums,int val, int idx, int max){
//		// 超出数组长度 剪枝
//		// 中间某时刻已经到达最大值  再往后遍历都不可能超过这个最大值  剪枝
//		if(val==max){
//			res+=(1<<(nums.length-idx));
//			return ;
//		}
//		if(idx==nums.length) return;
//
//		dfs(nums,val|nums[idx],idx+1,max);
//		dfs(nums,val,idx+1,max);
//	}

//		int res=0;
//		for(int i=0;i<size;i++){
//			int temp=0;
//			for(int j=0;j<length;j++){
//				if(((1<<j)&i)>0){
//					temp|=nums[j];
//				}
//			}
//			if(temp==max) res++;
//		}
//		return res;

//		for(int i=0;i<length;i++){
//			dp[1<<i]=nums[length-i-1];
//			max=Math.max(max,dp[1<<i]);
//		}
//
//		for(int i=0;i<size;i++){
//			if(dp[i]!=0) continue;
//			int base=0;
//			for(int j=(i-1)&i;j>0;j=(j-1)&i){
//				dp[i]=dp[i]|dp[j];
//			}
//			max=Math.max(max,dp[i]);
//		}

//		for(int i=0;i<size;i++) {
//			int base=0;
//			int index=length-1;
//			int num=i;
//			while(num!=0) {
//				int bit=num&1;
//				if(bit==1) {
//					base=base|nums[index];
//
//				}
//				index--;
//				num=num>>1;
//			}
//
//			dp[i]=base;
//			if(base>max) max=base;
//		}
		
//		int res=0;
//		for(int i=0;i<size;i++) {
//			if(dp[i]==max) res++;
//		}
//		return res;
}
