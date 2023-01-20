package dataStructure.Leetcode.Posiibility;

/**
 * @author Yawen Cao
 * @data 2022/1/28 10:35
 */
public class Demo {
//    public static void main(String[] args) {
//        double ans=1;
//        int n=365;
//        for(int i=0;i<365;i++){
//            ans*=(n-i);
//        }
//
//        double fm=1;
//        for(int i=1;i<=365;i++){
//            fm*=n;
//        }
//        System.out.println(1-(ans/fm));
//    }
    public static void main(String[] args) {
        double ans=1;
        int n=365;
        for(int i=0;i<365;i++){
            ans*=(n-i)/(double)365;
        }
        System.out.println(1-ans);
    }
}
