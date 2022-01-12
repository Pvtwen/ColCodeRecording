package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/4 10:46
 */
public class Question784 {
    List<String> ret=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        dfs(s,0,"");
        return ret;
    }
    public void dfs(String s,int idx,String cur){
        if(idx==s.length()) {
            ret.add(cur);
            return;
        }
        char c = s.charAt(idx);
        if(c>='0' && c<='9') dfs(s,idx+1,cur+c);
        else{
            if(c>='a' && c<='z'){
                char c1 = Character.toUpperCase(c);
                dfs(s,idx+1,cur+c1);
            }else if(c>='A' && c<='Z') {
                char c1 = Character.toLowerCase(c);
                dfs(s,idx+1,cur+c1);
            }
            dfs(s,idx+1,cur+c);
        }
    }
}
