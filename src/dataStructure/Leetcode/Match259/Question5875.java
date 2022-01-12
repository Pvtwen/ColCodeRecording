package dataStructure.Leetcode.Match259;

/**
 * @author Yawen Cao
 * @data 2021/9/19 10:32
 */
public class Question5875 {
    public int finalValueAfterOperations(String[] operations) {
        int res=0;
        for (String operation : operations) {
            if(operation.contains("+")) res++;
            else res--;
        }
        return res;
    }
}
