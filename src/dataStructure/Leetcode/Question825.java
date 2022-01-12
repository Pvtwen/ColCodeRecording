package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/12/27 15:33
 */
public class Question825 {
    public static void main(String[] args) {
        numFriendRequests(new int[]{16,16});
    }
    public static int numFriendRequests(int[] ages) {
        int length = ages.length;
        int[] counts=new int[121];
        for (int age : ages) {
            counts[age]++;
        }

        int[] prefixArr=new int[121];
        prefixArr[0]=counts[0];
        for(int i=1;i<121;i++){
            prefixArr[i]=prefixArr[i-1]+counts[i];
        }

        // 判定条件
        int requests=0;
        for(int x=15;x<121;x++){
            if(counts[x]>0){
                int l= (int) (x*0.5+7);
                int r=x;
                int cover = prefixArr[r] - prefixArr[l] - 1;
                requests+=cover*counts[x];
            }
            // 区间的人数
            // 总的请求
        }
        return requests;
    }
}
