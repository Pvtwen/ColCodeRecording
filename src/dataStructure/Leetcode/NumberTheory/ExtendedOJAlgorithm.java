package dataStructure.Leetcode.NumberTheory;

/**
 * @author Yawen Cao
 * @data 2022/1/24 10:03
 * 扩展欧几里得 dfs
 */
public class ExtendedOJAlgorithm {
    public static void main(String[] args) {
        solution(6,15,9,-10,10,-10,10);
//        solution(15,6);
    }
    // ax+by=gcd(a,b) 在求解出最大公因数的同时 求解 x,y
//    static  int x=0;
//    static int y=0;
//    public static void solution(int a,int b){
//        dfs(a,b);
//        System.out.println("x:"+x+",y:"+y);
//    }
//    public static void dfs(int a,int b){
//        if(b==0){
//            x=1;y=0;
//            return;
//        }
//        dfs(b,a%b);
//        int tempx=y;
//        int tempy=x-(a/b)*y;
//        x=tempx;
//        y=tempy;
//    }

    // 求解ax+by+c=0 有多少个整点满足 x∈[x1,x2] y∈[y1,y2]
    static int x=0;
    static int y=0;
    public static void solution(int a,int b,int c,int x1,int x2,int y1,int y2){
        int gcd = gcd(a, b);
        if(gcd%c==0 && c%gcd==0) {
            System.out.println("无解");
            return;
        }
//        dfs(b,a);
        int[] x=new int[1];
        int[] y=new int[1];
        dfs(a,b,x,y);
        System.out.println("x:"+x[0]+"y:"+y[0]);
        System.out.println();
        // 求倍数
        int i = (-c) / gcd;
        x[0]*=i;
        y[0]*=i;
        // 直接相乘得到的不是ax+by+c=0的解 而是 kax+kby+kc=0的解
        // (x-k*b`,y+k*a`)
        for(int k=-100;k<=100;k++){
            int i1=x[0]-k*(b/gcd);
            int i2=y[0]+k*(a/gcd);
            if(i1>=x1 && i1<=x2 && i2>=y1 && i2<=y2){
                if(a*i1+b*i2+c==0) System.out.println("x:"+i1+",y:"+i2);
            }
        }
    }
    public static int gcd(int a,int b){
        while(b!=0){
            int tempA=a;
            a=b;
            b=tempA%b;
        }
        return a;
    }
    public static void dfs(int a,int b){
        if (b == 0) {
            x=1;y=0;
            return;
        }
        dfs(b,a%b);
        int tempx=y;
        int tempy=x-(a/b)*y;
        x=tempx;
        y=tempy;
    }
    public static void dfs(int a,int b,int[] x,int[] y){
        if(b==0){
            x[0]=1;y[0]=0;
            return;
        }
        dfs(b,a%b,y,x);
        y[0]-=(a/b)*x[0];
    }
}
