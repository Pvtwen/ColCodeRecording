package dataStructure.Factorial;

/**
 * @author 86153
 * @data 2021/6/13 17:15
 */
public class fact {
    public static void main(String[] args) throws Exception {
        Integer factorial = factorial(3);
        System.out.println(factorial);
    }
    public static Integer factorial(int n) throws Exception {
        if(n<=0){
            throw new Exception("n<=0");
        }
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
