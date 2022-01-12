package dataStructure.Compute.TaylerExpression;
/**
 * @author Yawen Cao
 * @data 2021/11/28 18:24
 * 参考网址:https://chowdera.com/2021/10/20211007200043190I.html
 */
public class Math {
    static int N = (int) 1e6;
    static double pi=java.lang.Math.PI;
    public static double log(int x){
        double base=(x-1)/(double)(x+1);
        double sum=0;
        for(int i=1;i<=N;i+=2){
            double pow = java.lang.Math.pow(base, i);
            pow/=i;
            sum+=pow;
        }
        return sum*2;
    }

    public static double log(int x, int y) {
        return Math.log(y) / Math.log(x);
    }
    // 利用极坐标求解
    public static double atan2(int dy,int dx){
        if(dy>0 && dx==0) return pi/2;
        if(dy<0 && dx==0) return -pi/2;
        // 计算value
        int value = dy / dx;
        double atan = java.lang.Math.atan(value);
        // 分情况讨论
        // 如果是第一和第四象限
        if(dx>0){
            return atan;
        }
        // 如果是第二象限
        if(dx<0 && dy>0){
            return -atan+pi/2;
        }
        // 如果是第三象限
        if(dx<0 && dy<0){
            return -atan-pi/2;
        }
        return 1;
    }
}
