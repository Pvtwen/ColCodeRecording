package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/15 16:54
 */
public class Question341 {
    public int integerBreak(int n) {
        int y = n % 3;
        long mul=1;
        if(y==0){
            for(int i=1;i<=n/3;i++){
                mul*=3;
            }
        }else if(y==2){
            for(int i=1;i<=n/3-1;i++){
                mul*=3;
            }
            mul*=2;
        }else if(y==1){
            for(int i=1;i<=n/3-2;i++){
                mul*=3;
            }
            mul*=4;
        }
        return (int) mul;
    }
}
