package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author 86153
 * @data 2021/8/12 11:17
 */
public class Question89 {
//    static int N;
//    static int num;
    static List<Integer> ans = new ArrayList<>();
//    static String[] arr;
//    static int flag = 1;
//
//    public static List<Integer> grayCode(int n) {
//        N = n;
//        num = (int) Math.pow(2, n);
//        arr = new String[num];
//        String s = new String("0").repeat(n);
//        arr[0] = s;
//        dfs(s.toCharArray());
//
//        return ans;
//    }
//
//    public static void dfs(char[] s) {
//        for (int t = 1; t < num; t++) {
//            for (int i = 0; i < N; i++) {
//                if (s[i] == '0') s[i] = '1';
//                else s[i] = '0';
//                String s1 = new String(s);
//                for (int j = 0; j < t; j++) {
//                    if (s1.equals(arr[j])) {
//                        flag = 0;
//                        break;
//                    }
//                }
//                //如果改变了之后  发现arr中存在相同的字符串 则继续循环  并且回溯
//                if (flag == 0) {
//                    if (s[i] == '0') s[i] = '1';
//                    else s[i] = '0';
//                    flag = 1;
//                    continue;
//                }
//                //如果改变之后  arr中唯一  则将其添加进arr数组
//                arr[t] = new String(s);
//                break;
//            }
//        }
//            for (int i = 0; i < num; i++) {
//                int sum = 0;
//                for (int j = 0; j < N; j++) {
//                    if (arr[i].charAt(j) == '1') sum += Math.pow(2, N - j - 1);
//                }
//                ans.add(sum);
//            }
//        }


//        public static List<Integer> grayCode(int n) {
//            if(n==1){
//                ans.add(0);
//                return ans;
//            }
//            int[] s={0,2,3,1};
//            if(n==2){
//                ans.add(0);
//                ans.add(2);
//                ans.add(3);
//                ans.add(1);
//                return ans;
//            }
//            int[] arr;
//            arr=Arrays.copyOf(s,(int) Math.pow(2, n));
//
//            for(int i=3;i<=n;i++){
//                for(int j = (int) Math.pow(2,i-1),t=1;j<Math.pow(2,i);j++,t++){
//                    arr[j]=arr[(int) (Math.pow(2,i-1)-t)]*(int)Math.pow(2,i-1);
//                }
//            }
//            for(int i=0;i<Math.pow(2,n);i++){
//                ans.add(arr[i]);
//            }
//            return ans;
//        }

    public static List<Integer> grayCode(int n) {
        ans.add(0);
        int add;
        // 一共求解多少次
        for(int i=0;i<n;i++){
            // 一次加多少
            add=1<<i;
            // 倒序遍历ans
            for(int j=ans.size()-1;j>=0;j--){
                ans.add(ans.get(j)+add);
            }
        }
        return ans;
    }
}
