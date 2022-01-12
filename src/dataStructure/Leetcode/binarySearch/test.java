package dataStructure.Leetcode.binarySearch;

/**
 * @author Yawen Cao
 * @data 2021/12/7 19:25
 */
public class test {
    public static void main(String[] args) {
        binarySearch s=new binarySearch();
        s.bsForFirstGT(new int[]{1,1,2,3,4},0);
        s.bsForFirstGT(new int[]{1,1,2,3,4},1);

        s.bsForFirstGT(new int[]{1,1,2,3,4},2);
        s.bsForFirstGT(new int[]{1,1,2,3,4},3);
        s.bsForFirstGT(new int[]{1,1,2,3,4},5);

    }
}
