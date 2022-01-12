package dataStructure.Leetcode.Match261;

/**
 * @author Yawen Cao
 * @data 2021/10/3 10:37
 */
public class Question5890 {
    public int minimumMoves(String s) {
        int res=0;
        char[] arr = s.toCharArray();
        int n=arr.length;

        int i=0;
        while(i<n){
            if(arr[i]=='X'){
                res++;
                i+=3;
            }else i++;
        }
        return res;
    }
}
