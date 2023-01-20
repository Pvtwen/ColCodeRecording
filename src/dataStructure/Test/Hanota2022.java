package dataStructure.Test;

import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/2/12 10:03
 */
public class Hanota2022 {
    long time=0;
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        dfs(n,A,B,C,'A','B','C');
        System.out.println(time);
    }
    public void dfs(int n,List<Integer> from,List<Integer> aux,List<Integer> to,char A,char B,char C){
        if(n==1){
            to.add(from.remove(from.size()-1));
            time++;
            System.out.println("第"+time+"步:"+"把"+n+"从"+A+"移动到"+C);
            return;
        }
        dfs(n-1,from,to,aux,A,C,B);
        to.add(from.remove(from.size()-1));
        time++;
        System.out.println("第"+time+"步:"+"把"+n+"从"+A+"移动到"+C);
        dfs(n-1,aux,from,to,B,A,C);
    }
}
