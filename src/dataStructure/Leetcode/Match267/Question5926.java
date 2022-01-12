package dataStructure.Leetcode.Match267;

/**
 * @author Yawen Cao
 * @data 2021/11/14 10:30
 */
public class Question5926 {
    public static int timeRequiredToBuy(int[] tickets, int k) {
//        int length = tickets.length;
//        int MinusSum=0;
//        int target=tickets[k];
//        for(int i=0;i<length;i++){
//            tickets[i]-=target;
//            if(tickets[i]<0){
//                MinusSum+=Math.abs(tickets[i]);
//            }
//        }
//        return tickets[k]*length-MinusSum;
        int length = tickets.length;
        int time=0;
        int i=0;
        while(tickets[k]>0){
            if(tickets[i]==0) {
                i=(i+1)%length;

                continue;
            }
            tickets[i]--;
            time++;
            i=(i+1)%length;
        }
        return time;
    }
}
