package dataStructure.Test;
import java.util.Stack;
/**
 * @author Yawen Cao
 * @data 2021/11/17 10:37
 */
public class TestReadFile {
    public static void main(String[] args) {
        for(int i=2;i<20;i++){
            System.out.println(FibonacciByRealStack(i));
        }
    }
    // F(n)=F(n-1)+F(n-2)
    public static int FibonacciByRealStack(int n){
        Stack<FiboNode[]> stack=new Stack<>();
        FiboNode f1 = new FiboNode(n - 1, false);
        FiboNode f2 = new FiboNode(n - 2, false);
        FiboNode[] arr=new FiboNode[2];
        arr[0]=f1;arr[1]=f2;
        stack.push(arr);
        int base=0;
        while(!stack.isEmpty()){
            FiboNode[] pop = stack.pop();
            FiboNode n1 = pop[0];
            FiboNode n2 = pop[1];
            int val = n1.val;
            if(!n1.visited){
                stack.push(pop);
                if (val == 0) {
                    base += 0;
                } else if (val == 1) base += 1;
                // 入栈
                else {
                    FiboNode[] array=new FiboNode[2];
                    FiboNode fiboNode = new FiboNode(val - 1, false);
                    FiboNode fiboNode1 = new FiboNode(val - 2, false);
                    array[0]=fiboNode;
                    array[1]=fiboNode1;
                    stack.push(array);
                }
                n1.visited=true;
//                System.out.println(base);
            }else if(!n2.visited){
                int val1 = n2.val;
                if (val1 == 0) {
                    base += 0;
                } else if (val1 == 1) base += 1;
                // 入栈
                else {
                    FiboNode[] array=new FiboNode[2];
                    FiboNode fiboNode = new FiboNode(val1 - 1, false);
                    FiboNode fiboNode1 = new FiboNode(val1 - 2, false);
                    array[0]=fiboNode;
                    array[1]=fiboNode1;
                    stack.push(array);
                }
//                System.out.println(base);
            }
        }
        return base;
    }
    // F(n)=F(n-1)+n-1
//    public static int compute(int n) {
//        Stack<Integer> stack = new Stack<>();
//        n-=1;
//        while(n!=1){
//            stack.push(n);
//            n-=1;
//        }
//        stack.push(1);
//        int base=1;
//        while(!stack.isEmpty()){
//            Integer pop = stack.pop();
//            base+=pop;
//        }
//        return base;
//        stack.push(n);
//        while(n!=1 && n!=0){
//            n-=2;
//            stack.push(n);
//        }
//        int base=stack.pop();
//        while (!stack.isEmpty()) {
//            stack.pop();
//            base += 1;
//        }
//        return base;
//    }

}
class FiboNode{
    int val;
    boolean visited;

    public FiboNode() {
    }

    public FiboNode(int val, boolean visited) {
        this.val = val;
        this.visited = visited;
    }
}