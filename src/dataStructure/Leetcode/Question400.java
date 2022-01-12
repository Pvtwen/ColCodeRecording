package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/11/30 8:38
 */
public class Question400 {
//    public static int findNthDigit(int n) {
//        StringBuilder str=new StringBuilder();
//        int N=1<<20;
//        for(int i=1;i<=N;i++){
//            str.append(i);
//        }
//        char c = str.toString().charAt(n-1);
//        return  Integer.parseInt(""+c+"");
//    }
    public static int findNthDigit(int n) {
        //找第几位
        int len=1;
        while(len*9*Math.pow(10,len-1)<n){
            n-=len*9*Math.pow(10,len-1);
            len++;
        }
        // len位数的第几个
        int num = n % len;
        int time=1;
        int posit=0;
        if(num==0){
            time=1;
            posit=n/len-1;
        }else{
            time=len-num+1;
            posit=n/len;
        }
        // 该数字的第几位
        // 具体数字
        int number= (int) (Math.pow(10,len-1)+posit);
        int rem=-1;
        for(int i=1;i<=time;i++){
            rem=(number%10);
            number/=10;
        }
        return rem;
    }
}
