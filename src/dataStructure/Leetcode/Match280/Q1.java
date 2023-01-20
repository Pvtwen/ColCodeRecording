package dataStructure.Leetcode.Match280;

/**
 * @author Yawen Cao
 * @data 2022/2/13 10:32
 */
public class Q1 {
    public int countOperations(int num1, int num2) {
        int time=0;
        while(num1==0 || num2==0){
            if(num1>=num2){
                num1-=num2;
            }else{
                num2-=num1;
            }
            time++;
        }
        return time;
    }
}
