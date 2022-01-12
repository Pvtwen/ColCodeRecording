package dataStructure.Review;

/**
 * @author Yawen Cao
 * @data 2021/12/1 17:31
 */
public class Question2063 {
    public long countVowels(String word) {
        int length = word.length();
        int[] dp=new int[length];
        int sum=0;
        dp[0] = (condition(word.charAt(0))) ? 1 : 0;
        sum+=dp[0];
        for(int i=1;i<length;i++){
            char c = word.charAt(i);
            if(condition(c)){
                dp[i]=dp[i-1]+i+1;
            }else{
                dp[i]=dp[i-1];
            }
            sum+=dp[i];
        }
        return sum;
    }
    // 只是单纯的统计含有元音字符串的个数 而不是元音个数
//    public long countVowels(String word) {
//        int length = word.length();
//        long sum=0;
//        long[] dp=new long[length];
//        dp[0]=(condition(word.charAt(0)))?1:0;
//    sum+=dp[0];
//        for(int i=1;i<length;i++){
//            char c = word.charAt(i);
//            if(condition(c)){
//                dp[i]=i+1;
//            }else{
//                dp[i]=dp[i-1];
//            }
//            sum+=dp[i];
//        }
//        return sum;
//    }
    public boolean condition(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
