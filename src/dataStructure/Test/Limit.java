package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2022/3/8 14:13
 */
public class Limit {
    public static void main(String[] args) {
        double x=1e-6-(1e-7)*9;
        while(x>0){
            double fz = x * x - Math.sin(x) * Math.sin(x);
            double fm=x*x*x*x;
            double ret = fz / fm;
            System.out.println("x:"+x+" "+ret);
//            x-=0.000001;
            break;
        }
    }
}
