package dataStructure.Test;

import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/28 11:00
 */
public class HanotaiiRev {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        if(n==0) return;

    }
    public void dfs(int n,List<Integer> from,List<Integer> aux,List<Integer> to){
        if(n==1){
            to.add(from.get(from.size()-1));
            from.remove(from.size()-1);
            return;
        }
        dfs(n-1,from,to,aux);
        to.add(from.remove(from.size()-1));
        dfs(n-1,aux,from,to);
    }
}
