package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2022/1/16 20:31
 */
public class S {
    // abcd*9=dcba
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<=9;k++){
                    for(int m=0;m<=9;m++){
                        // 1
                        int a=i*1000+j*100+k*10+m;
                        int b=m*1000+k*100+j*10+i;
                        if(a*9==b) System.out.println(a);
                    }
                }
            }
        }
    }
}
