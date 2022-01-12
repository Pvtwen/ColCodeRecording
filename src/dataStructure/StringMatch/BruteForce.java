package dataStructure.StringMatch;

/**
 * @author Yawen Cao
 * @data 2021/12/23 14:47
 */
public class BruteForce {
    public static void main(String[] args) {
        System.out.println(bf("abcdefaa", "bcefaa"));
    }
    public static boolean bf(String main,String find){
        int n = main.length();
        int m = find.length();
        for(int i=0;i<=n-m;i++){
            char c = main.charAt(i);
            char c1 = find.charAt(0);
            if(c==c1){
                int idx=1;
                int tmp=i+1;
                while(idx<m && c==c1){
                    c=main.charAt(tmp);
                    c1=find.charAt(idx);
                    tmp++;
                    idx++;
                }
                if(idx==m) return true;
            }
        }
        return false;
    }
}
