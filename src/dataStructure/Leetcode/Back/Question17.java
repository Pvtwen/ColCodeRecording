package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/5 9:50
 */
public class Question17 {
    List<String> ret=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        dfs("",digits,0);
        return ret;
    }
    public void dfs(String cur,String digits,int idx){
        if(idx==digits.length()){
            ret.add(cur);
            return;
        }
        char c = digits.charAt(idx);
        if(c>='7') {
            if(c=='7'){
                int base=97+15;
                dfs(cur+(char)base,digits,idx+1);
                dfs(cur+(char)(base+1),digits,idx+1);
                dfs(cur+(char)(base+2),digits,idx+1);
                dfs(cur+(char)(base+2),digits,idx+1);
            }
            if(c=='8'){
                int base=97+19;
                dfs(cur+(char)base,digits,idx+1);
                dfs(cur+(char)(base+1),digits,idx+1);
                dfs(cur+(char)(base+2),digits,idx+1);
            }
            if(c=='9'){
                int base=97+22;
                dfs(cur+(char)base,digits,idx+1);
                dfs(cur+(char)(base+1),digits,idx+1);
                dfs(cur+(char)(base+2),digits,idx+1);
            }
        }else {
            int base = 97 + (Integer.parseInt(c + "") - 2) * 3;
            dfs(cur+(char)base,digits,idx+1);
            dfs(cur+(char)(base+1),digits,idx+1);
            dfs(cur+(char)(base+2),digits,idx+1);
        }
    }
}
