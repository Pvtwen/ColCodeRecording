package DataMining.Mission3;

/**
 * @author Yawen Cao
 * @data 2021/10/18 20:34
 */
public class partion {
    public int[][] partionFunction(int[] instances,Shuffle shuffle,double[] proportion){
        int n=proportion.length;
        int length=instances.length;
        int[][] res=new int[n][length];

        return res;
        }

    public double gcd(double x,double y){
        if(x<y) {
            double temp=x;
            x=y;
            y=temp;
        }
        while(y!=0){
            y=x%y;
            x=y;
        }
        return x;
    }
}