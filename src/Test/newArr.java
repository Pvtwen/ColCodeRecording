package Test;

/**
 * @author 86153
 * @data 2021/8/21 11:06
 */
public class newArr {
    public static void main(String[] args) {
        int i=3,count=0;
        while(i!=0){
            int p=i&1;
            if(p==1) count++;
            i>>=1;
        }
        System.out.println(count);
    }
}
