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
        // ij k ���� ���� С�����
        fun1(0);
        int weight;
        for(int i=0;i<=100;i++){
            // ��ö�ٴ�������������
            weight=100;
            weight-=3*i;
            for(int j=0;j<=100-i;j++){
                if(i==0 && j==49){}
                int temp=weight;
                temp-=2*j;
                // һ��һ��ƥ�� ö�����˴������������� ʣ�µľ���С���
                int k=100-i-j;
                // ��Ϊ��һ��С������ϻ� ȡ��
                // ���С�����ж��ٻ���
                int little=k/2;
//                if(temp>k){
//                    System.out.println("�����������"+i+","+j+","+k);
//                }else{
                temp-=little;
//                if(i==0 &&j==49){
//                    System.out.println(i+j+k);
//                }
                if(temp==0&&k%2==0){
                    System.out.println("���� ���� С��ĸ���"+i+","+j+","+(100-i-j));
                }
            }
        }
    }
}
