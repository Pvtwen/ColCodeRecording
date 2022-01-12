package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2022/1/10 9:51
 */
public class Question2024Review {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        int nT=0,nF=0;
        int i=0,j=0;
        int ret=1;
        // 每次外层循环j++，也就意味着内层存在着关于缩小窗口的while循环
        while(j<arr.length){
            if(arr[j]=='T') nT++;
            else nF++;
            int min = Math.min(nT, nF);
            if(min<=k){
                ret = Math.max(ret, j - i + 1);
            }else{
                while(min>k){
                    if(arr[i]=='T') nT--;
                    else nF--;
                    i++;
                    min=Math.min(nT,nF);
                }
            }
            j++;
        }
        return ret;
    }
//    public int maxConsecutiveAnswers(String answerKey, int k) {
//        int length = answerKey.length();
//        int numT=0,numF=0;
//        int i=0,j=0;
//        char c1 = answerKey.charAt(0);
//        if(c1=='T') numT++;
//        else numF++;
//        int ret=1;
//        while(i<=j && j<length){
//            int min = Math.min(numT, numF);
//            // 继续扩大窗口
//            if(min<=k){
//                ret=Math.max(ret,j-i+1);
//                j++;
//                if(j<length){
//                    char c = answerKey.charAt(j);
//                    if(c=='T') numT++;
//                    else numF++;
//                }
//            }
//            // 缩小窗口
//            else{
//                char c = answerKey.charAt(i);
//                i++;
//                if(c=='T') numT--;
//                else numF--;
//            }
//        }
//        return ret;
//    }
}
