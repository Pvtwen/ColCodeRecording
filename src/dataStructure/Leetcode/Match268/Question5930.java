package dataStructure.Leetcode.Match268;

/**
 * @author Yawen Cao
 * @data 2021/11/21 10:32
 */
public class Question5930 {
    public int maxDistance(int[] colors) {
        int res=Integer.MIN_VALUE;
        int length = colors.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(colors[i]!=colors[j]){
                    res=Math.max(res,j-i);
                }
            }
        }
        return res;
    }
}
