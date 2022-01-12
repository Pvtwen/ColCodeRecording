package dataStructure.Leetcode.Hard;

/**
 * @author Yawen Cao
 * @data 2021/11/25 10:32
 */
public class Question458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base=(minutesToTest/minutesToDie)+1;
        int num=1;
        while(base<buckets){
            base*=base;
            num++;
        }
        return num;
    }
}
