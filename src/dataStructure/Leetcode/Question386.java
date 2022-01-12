package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/5 16:24
 */
public class Question386 {
    static List<Integer> res=new ArrayList<>();
    static int t=0;
    public static List<Integer> lexicalOrder(int n) {
    dfs(0,n);
        return res;
}

    public static void dfs(int p,int n){
        if(p==0 && t==1) return;
        res.add(p);
        t++;
        for(int i=0;i<10;i++){
            int val=p*10+i;
            if(val>n) break;
            dfs(val,n);
        }
        return;
    }
}
