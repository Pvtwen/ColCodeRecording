package dataStructure.Leetcode.PointToOffer;

import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2021/11/29 9:37
 */
public class Question856 {
// 分治(递归)实现
    public static int scoreOfParentheses(String s) {
        return dfs(s,0,s.length()-1);
    }
    // 闭区间
    public static int dfs(String s,int l,int r){
        int bal=0;int ans=0;
        for(int i=l;i<r+1;i++){
            bal+=(s.charAt(i)=='(')?1:-1;
            if(bal==0){
                if(i-l==1) ans+=1;
                else ans+=2*dfs(s,l+1,i-1);
                l=i+1;
            }
        }
        return ans;
    }

    // stack实现
//    public int scoreOfParentheses(String s) {
//        int length = s.length();
//        Stack<Integer> stack=new Stack<>();
//        stack.push(0);
//
//        for(int i=0;i<length;i++){
//            char c = s.charAt(i);
//            if(c=='(') stack.push(0);
//            else{
//                Integer fir = stack.pop();
//                Integer sec = stack.pop();
//                sec+=Math.max(2*fir,1);
//                stack.push(sec);
//            }
//        }
//        return stack.pop();
//    }

    // 数组实现
    //    public static int scoreOfParentheses(String s) {
//        int length = s.length();
//        int curDepth=0;
//        int[] arr=new int[length];
//        for(int i=0;i<length;i++) {
//            char c = s.charAt(i);
//            if(c==')'){
//                arr[curDepth-1]+=(arr[curDepth]*2);
//                arr[curDepth]=0;
//                curDepth--;
//            }else if(c=='('){
//                char c1 = s.charAt(i + 1);
//                curDepth++;
//                if(c1==')'){
//                    arr[curDepth-1]+=1;
//                    arr[curDepth]=0;
//                    curDepth--;
//                    i++;
//                }
//            }
//        }
//        return arr[0];
//    }

//    public int scoreOfParentheses(String s) {
//        int leftK=0;
//        int length = s.length();
//        int res=0;
//        for(int i=0;i<length;i++){
//            char c = s.charAt(i);
//            if(c=='(') leftK++;
//            else {
//                leftK--;
//                char c1 = s.charAt(i - 1);
//                if(c==')' && c1=='(') res+=Math.pow(2,leftK);
//            }
//        }
//        return res;
//    }

}
