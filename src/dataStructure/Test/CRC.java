package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2021/12/30 17:25
 * 两数的余数异或等于两数异或后的余数
 */
public class CRC {
    public static void main(String[] args) {
        int a=1<<6;
        int b=1<<5;
        int c=1<<4;
        int d=1<<3;
        int z=a^d;
        System.out.println(z%11);
        System.out.println((a % 11) ^(d % 11));
    }
}
