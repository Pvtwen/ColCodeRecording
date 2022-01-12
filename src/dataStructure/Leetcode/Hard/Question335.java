package dataStructure.Leetcode.Hard;

/**
 * @author Yawen Cao
 * @data 2021/10/30 10:49
 */
public class Question335 {
    public boolean isSelfCrossing(int[] distance) {
        int length=distance.length;
        if(length<=3) return false;
        for(int i=3;i<length;i++){
            if(distance[i]>=distance[i-2] && distance[i-1]<=distance[i-3]) return true;
            if(i>=4 && distance[i-1]==distance[i-3] && distance[i-2]<=distance[i]+distance[i-4]) return true;
            if(i>=5 && distance[i]+distance[i-4]>=distance[i-2] && distance[i-1]+distance[i-5]>=distance[i-3] && distance[i-2]>=distance[i-4] && distance[i-1]<=distance[i-3]) return true;
        }
        return false;
    }
    /*               i-2
    case 1 : i-1┌─┐
                └─┼─>i
                 i-3

                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2

*/
}
