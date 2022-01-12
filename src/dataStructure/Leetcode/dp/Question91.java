package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/8 17:55
 */
public class Question91 {
    public int numDecodings(String s) {
        int q=1,p=1,k;
        int length=s.length();
        if(s.charAt(0)=='0') return 0;
        for(int i=1;i<length;i++){
            char c = s.charAt(i);
            char c1 = s.charAt(i - 1);
            if(c=='0'){
                if(c1=='1' || c1=='2') k=q;
                else return 0;
            }
            else if(c1=='1' || (c1=='2' && c>='1' && c<='6')) k=q+p;
            q=p;
        }
        return p;
    }
//    static int ans=0;
//    public static int numDecodings(String s) {
//        if(s.length()==1 && s.charAt(0)!='0') return 1;
//        if(s.charAt(0)=='0') return 0;
//        dfs(s,1,""+s.charAt(0));
//        return ans;
//    }
////    public static void newDfs(String s,int idx,String res){
////
////    }
//    public static void dfs(String s,int idx,String res){
//        // 如果res.len=0  该元素为0 剪枝
//        if(res.length()==0 && s.charAt(idx)=='0') return;
//        if(idx==s.length()-1){
//           if(res.length()==0) ans++;
//           else if(res.length()==1){
//               res+=s.charAt(idx);
//               int i = Integer.parseInt(res);
//               if(i<=26) ans++;
//               // 因为是最后一个元素 所以还最后一个元素单独成数字
//               if(Integer.parseInt(""+s.charAt(idx))!=0) ans++;
//           }
//            // 如果之和大于26 剪枝
//            return;
//        }
//
//        // res.len=0
//        if(res.length()==0){
//            dfs(s,idx+1,res+s.charAt(idx));
//        } else if(res.length()==1){
//            res+=s.charAt(idx);
//            // idx与res合并 或者 不合并
//            // 合并
//            int i = Integer.parseInt(res);
//            if(i<=26){
//                dfs(s,idx+1,"");
//            }
//            // 大于26 不管 不剪枝
//            // 不合并
//            res=""+s.charAt(idx);
//            if(Integer.parseInt(res)!=0) dfs(s,idx+1,res);
//        }
//    }
}
