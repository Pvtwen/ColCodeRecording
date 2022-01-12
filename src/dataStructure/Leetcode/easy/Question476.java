package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2021/10/18 11:36
 */
public class Question476 {
    // num是正数
    public int findComplement(int num) {
        int maxBitIndex=-1;
        int temp=num;
        int index=0;
        while(temp>0){
            int bit=temp&1;
            if(bit==1) maxBitIndex=index;
            temp>>=1;
            index++;
        }
        return ((1<<(maxBitIndex+1))-1) & (~num);
    }
}
