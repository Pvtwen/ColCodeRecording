package dataStructure.ACMSchoolMatch;

/**
 * @author Yawen Cao
 * @data 2021/12/20 10:59
 */
public class GCD {
    public static void main(String[] args) {
        int gcd = gcd(48, 18);
        System.out.println(gcd);
    }

    // x>y
//    public static int gcd(int x, int y) {
//        while(true){
//            int rem = x % y;
//            if(rem==0) return y;
//            x=y;
//            y=rem;
//        }
//    }
//    public static int gcd(int x,int y){
//        int rem=-1;
//        while(rem!=0){
//            rem = x % y;
//            x=y;
//            y=rem;
//        }
//        return x;
//    }
    public static int gcd(int x,int y){
        int rem = x % y;
        if(rem==0) return y;
        return gcd(y,rem);
    }

}
