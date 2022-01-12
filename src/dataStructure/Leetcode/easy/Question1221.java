package dataStructure.Leetcode.easy;

/**
 * @author 86153
 * @data 2021/9/7 17:05
 */
public class Question1221 {
//方法一
    //    public int balancedStringSplit(String s) {
//        int res=0;
//        int countR=0,countL=0;
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='R') countR++;
//            else countL++;
//            if(countR==countL){
//                countR=0;
//                countL=0;
//                res++;
//            }
//        }
//        return res;
//    }

    //方法二
//    public static int balancedStringSplit(String s) {
//        int res=0;
//        for(int i=0;i<s.length();){
//            i+=dfs(s,i,0,0);
//            res++;
//        }
//        return res;
//    }
//
//    public static int dfs(String s,int i,int countL,int countR){
//        if(countL==countR && countL!=0) return countL+countR;
//        else{
//            if(s.charAt(i)=='R') countR++;
//            else countL++;
//            return dfs(s,i+1,countL,countR);
//        }
//    }

    //方法三
     static int res=0;
    public static int balancedStringSplit(String s) {
        dfs(s,0,0,0);
        return res;
    }

    public static void dfs(String s,int i,int countL,int countR){
        if(countL==countR && countL!=0){
            if(i==s.length()){
                res++;
                return;
            }else{
                dfs(s,i,0,0);
            }
        }

        else{
            if(s.charAt(i)=='R'){
                countR++;
                dfs(s,i+1,countL,countR);
            }else{
                countL++;
                dfs(s,i+1,countL,countR);
            }
        }
    }
}
