package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2022/2/20 15:37
 */
public class Q717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if(n==1) return bits[0]==0;
        int idx=0;
        while(idx<n){
            int bit = bits[idx];
            if(bit==0){
                idx++;
                if(idx==n-1) return true;
            }else {
                idx+=2;
                if(idx==n-1) return true;
            }
        }
        return false;
    }
}
