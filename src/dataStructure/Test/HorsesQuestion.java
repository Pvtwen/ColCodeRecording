package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2022/6/8 14:33
 */
public class HorsesQuestion {
    public static void fun1(int i){
        i=99;
        fun2(i);
    }
    public static void fun2(int i){
        i++;
        System.out.println(i);
    }
    public static void main(String[] args) {
        // ij k 大马 中马 小马对数
        fun1(0);
        int weight;
        for(int i=0;i<=100;i++){
            // 先枚举大马和中马的数量
            weight=100;
            weight-=3*i;
            for(int j=0;j<=100-i;j++){
                if(i==0 && j==49){}
                int temp=weight;
                temp-=2*j;
                // 一共一百匹马 枚举完了大马和中马的数量 剩下的就是小马的
                int k=100-i-j;
                // 因为是一对小马才能拖货 取余
                // 算出小马能托多少货物
                int little=k/2;
//                if(temp>k){
//                    System.out.println("该种情况不行"+i+","+j+","+k);
//                }else{
                temp-=little;
//                if(i==0 &&j==49){
//                    System.out.println(i+j+k);
//                }
                if(temp==0&&k%2==0){
                    System.out.println("大马 中马 小马的个数"+i+","+j+","+(100-i-j));
                }
            }
        }
    }
}
