package dataStructure.Leetcode.Match271;

/**
 * @author Yawen Cao
 * @data 2021/12/12 11:05
 */
public class Question5954 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int length = plants.length;
        int i = 0, j = length - 1;
        int time = 0;
        int aCap=capacityA,bCap=capacityB;
        while(i<j){
            if(aCap>=plants[i]){
                aCap-=plants[i];
            }else{
                aCap=capacityA;
                time++;
                aCap-=plants[i];
            }
            if(bCap>=plants[j]){
                bCap-=plants[j];
            }else{
                bCap=capacityB;
                time++;
                bCap-=plants[j];
            }
            i++;
            j--;
        }
        if(i==j){
            if(aCap>=bCap){
                if(aCap>=plants[i]){
                }else{
                    time++;
                }
            }else{
                if(bCap>=plants[i]){

                }else time++;
            }
        }
        return time;
    }
}
