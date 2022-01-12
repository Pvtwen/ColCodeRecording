package iteration;

import java.util.List;

/**
 * @author 86153
 * @data 2021/6/13 18:20
 */
public class Hanota {
    public static void main(String[] args) {
        hano(1,'A','B','C');
    }
    public static void hano(int n,char fromPeg,char auxPeg,char toPeg){
        if(n==1){
            System.out.println("Move pack 1 from "+fromPeg+" to "+toPeg);
            return;
        }
        hano(n-1,fromPeg,toPeg,auxPeg);
        System.out.println("Move pack "+n+" from "+fromPeg+" to "+toPeg);
        hano(n-1,auxPeg,fromPeg,toPeg);
    }
    //Leetcode
    public static void hano(List<Integer> A,List<Integer> B,List<Integer> C){
        if(A.size()==1){
            Integer remove = A.remove(A.size() - 1);
            C.add(remove);
            return;
        }
        Integer remove1 = A.remove(A.size() - 1);

//        hano(, );
    }
}
