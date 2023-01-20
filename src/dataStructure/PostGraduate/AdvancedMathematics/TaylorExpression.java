package dataStructure.PostGraduate.AdvancedMathematics;

/**
 * @author Yawen Cao
 * @data 2022/4/5 19:15
 * 没有写成级数的形式
 */
public class TaylorExpression {
    public static void main(String[] args) {

    }
    // f(x)=x*x;
    public static void integeral(double a,double b,double x,double n){
        double delta = (b - a) / n;
        double l=a,r=a+delta;
        double sum=0;
        for(int seg=1;seg<=n;seg++){
            double mid=(l+r)/2;
            double fun=mid*mid;
            l+=delta;r+=delta;
            sum+=fun;
        }
        double va = sum * delta;
        System.out.println(va);
    }
    public static void sinx(double x){
        double ret=x-Math.pow(x,3)/6+Math.pow(x,5)/120;
        System.out.println(ret);
    }
    public static void cosx(double x){
        double ret=1-Math.pow(x,2)/2+Math.pow(x,4)/24;
        System.out.println(ret);
    }
    public static void tanx(double x){
        double ret=x+Math.pow(x,3)/3;
        System.out.println(ret);
    }
    public static void arcsinx(double x){
        double ret=x+Math.pow(x,3)/6;
    }
    public static void arctanx(double x){
        double ret=x-Math.pow(x,3)/3;
    }
    public static void ln1x(double x){
        double ret=x-(x*x)/2+(x*x*x)/3;
    }
    public static void expx(double x){
        double ret=1+x+(x*x)/2+(x*x*x)/6;
    }
    public static void sqrt(double x,double a){
        double ret=1+a*x+a*(a-1)*x*x/2;
    }
}
