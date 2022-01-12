package dataStructure.Leetcode.Match62;

/**
 * @author Yawen Cao
 * @data 2021/10/3 17:04
 * 类比1004题
 */
public class Question5873 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n=answerKey.length();
        int i=0,j=0;
        int res=1;
        int numT=0,numF=0;

        char[] arr = answerKey.toCharArray();

        while(j<n){
            if(arr[j]=='T') numT++;
            else numF++;
            if(numT<=k || numF<=k){
                res=Math.max(res,j-i+1);
            }else{
                while((numF>k && numT>k) && i<n){
                    if(arr[i]=='T') numT--;
                    else numF--;
                    i++;
                }
            }
            j++;
        }
        return res;
    }
}
