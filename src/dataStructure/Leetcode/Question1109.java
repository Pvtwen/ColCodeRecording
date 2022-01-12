package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/11/6 9:26
 */
public class Question1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefixArray=new int[n+1];
        int length=bookings.length;

        for(int i=0;i<length;i++){
            int i1 = bookings[i][0];
            int i2 = bookings[i][1];
            int value = bookings[i][2];
            prefixArray[i1]+=value;
            if(i2<n) prefixArray[i2+1]+=(-value);
        }

        int[] res=new int[n];
        int sum=0;
        for(int i=1;i<n+1;i++){
            sum+=prefixArray[i];
            res[i-1]=sum;
        }
        return res;
    }
}
