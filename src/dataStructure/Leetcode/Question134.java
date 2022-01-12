package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/20 10:53
 */
public class Question134 {
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int remainGas=0,j,flag=-1;
//        for(int i=0;i<gas.length;i++){
//            for(j=i;j!=i || (j==i && flag==-1);j=(j+1)%gas.length){
//                remainGas+=gas[j];
//                if(remainGas<cost[j]) {
//                    remainGas=0;
//                    flag=-1;
//                    break;
//                }
//                else{
//                    flag=1;
//                    remainGas-=cost[j];
//                }
//            }
//            if(flag==1 && j==i) return i;
//        }
//        return -1;
//    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int minIndex=0,sum=0,minSum=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            if(sum<minSum){
                minSum=sum;
                minIndex=i;
            }
        }
        return sum<0?-1:(minIndex+1)%gas.length;
    }
}
