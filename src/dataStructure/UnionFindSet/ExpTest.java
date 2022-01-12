package dataStructure.UnionFindSet;

/**
 * @author 86153
 * @data 2021/8/21 10:49
 */
public class ExpTest {
    public static void main(String[] args) {
        exception.init(10);
        exception.union(2,4);
        exception.union(5,7);
        exception.union(1,3);
        exception.union(8,9);
        exception.union(1,2);
        exception.union(5,6);
        exception.union(2,3);

        int i = exception.find(3);
        int j=exception.find(4);
        if(i==j) System.out.println("YES");
        else System.out.println("NO");

        int k=exception.find(7);
        int m=exception.find(10);
        if(k==m) System.out.println("YES");
        else System.out.println("NO");

        int l=exception.find(8);
        int o=exception.find(9);
        if(l==o) System.out.println("YES");
        else System.out.println("NO");
    }
}
