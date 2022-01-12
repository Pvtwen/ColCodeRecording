package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/12/28 16:43
 */
public class Question553 {
    public String optimalDivision(int[] nums) {
        int length = nums.length;
        if(length==1) return ""+nums[0];
        if(length==2) return nums[0]+"/"+nums[1];
        StringBuilder str=new StringBuilder();
        for(int i=0;i<length;i++){
            if(i==0){
                str.append(nums[i]+"/(");
            }else if(i==length-1){
                str.append(nums[length-1]+")");
            }else str.append(nums[i]+"/");
        }
        return str.toString();
    }
    // 区间dp  较复杂 这里还是采用 数学方法
//    public static void main(String[] args) {
//        optimalDivision(new int[]{1000,100,10,2});
//    }
//    public static String optimalDivision(int[] nums) {
//        int length = nums.length;
//        // 分别存储最大值和最小值
//        int[][][] dp=new int[length][length][2];
//        String[][][] str=new String[length][length][2];
//        // 区间dp
//        for(int i=0;i<length;i++){
//            dp[i][i][0] = nums[i];
//            dp[i][i][1]= nums[i];
//            str[i][i][0]=""+nums[i];
//            str[i][i][1]=""+nums[i];
//        }
//        for(int len=2;len<=length;len++){
//            for(int l=0;l+len-1<length;l++){
//                int r=l+len-1;
//                for(int k=l;k<r;k++){
//                    // 左边最大值/右边的最小值
//                    // 同时存储最大和最小值
//                    dp[l][r][0]=Math.max(dp[l][k][0]/dp[k+1][r][1],dp[l][r][0]);
//                    //
//                    if(dp[l][r][0]==dp[l][k][0]/dp[k+1][r][1]){
//                        str[l][r][0]="("+str[l][k][0]+"/"+str[k+1][r][1]+")";
//                    }
//
//                    if(dp[l][r][1]==0){
//                        dp[l][r][1]=dp[l][k][1]/dp[k+1][r][0];
//                        str[l][r][1]="("+str[l][k][1]+"/"+str[k+1][r][0]+")";
//                    }
//                    else{
//                        dp[l][r][1]=Math.min(dp[l][k][1]/dp[k+1][r][0],dp[l][r][1]);
//                        if(dp[l][r][1]==dp[l][k][1]/dp[k+1][r][0]){
//                            str[l][r][1]="("+str[l][k][0]+"/"+str[k+1][r][0]+")";
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(dp[0][3][0]);
//        // 去除多余的括号
//        System.out.println(str[0][3][0]);
//        String s = str[0][3][0];
//        StringBuilder stringBuilder = new StringBuilder(s);
//        stringBuilder.deleteCharAt(0);
//        stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        int idx=0;
//        while(idx<stringBuilder.length()){
//            char c = stringBuilder.charAt(idx);
//            int num=0;
//            while(c=='('){
//                num++;
//                if(num>1){
//                    stringBuilder.deleteCharAt(idx);
//                }
//                idx++;
//                // 一旦大于一 就开始删除
//                c=stringBuilder.charAt(idx);
//            }
//            // 大于一个连续括号 删除多余的括号 及对应的 右括号
//            if(num>1){
//                int delete=num-1;
//                while(idx<stringBuilder.length() && delete>0){
//                    char c1 = stringBuilder.charAt(idx);
//                    if(c1==')') {
//                        stringBuilder.deleteCharAt(idx);
//                        delete--;
//                    }
//                    idx++;
//                }
//            }
//            idx++;
//        }
//        System.out.println(stringBuilder.toString());
//        return null;
//    }
}
