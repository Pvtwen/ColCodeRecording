package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2021/11/16 15:17
 */
public class Question11Review {
    public int maxArea(int[] height) {
        int res=Integer.MIN_VALUE;
        int length = height.length;
        int i=0,j=length-1;
        while(i<j){
            int l = height[i];
            int r = height[j];
            if(l<r){
                res=Math.max(res,(j-i)*l);
                i++;
            }else{
                res=Math.max(res,(j-i)*r);
                j--;
            }
        }
        return res;
    }
}
