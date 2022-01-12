package dataStructure.Leetcode;

import java.time.Clock;

/**
 * @author Yawen Cao
 * @data 2021/12/24 12:05
 */
public class Question686 {
    public int repeatedStringMatch(String a, String b) {
        int ans=0;
        StringBuilder sb=new StringBuilder();
        while(sb.length()<b.length()){
            sb.append(a);
            ans++;
        }
        Clock clock = Clock.systemDefaultZone();
        long start = clock.millis();
        while(clock.millis()-start<100){
            if(sb.indexOf(b)!=-1) return ans;
            sb.append(a);
            ans++;
        }
        return -1;
    }
//    public int repeatedStringMatch(String a, String b) {
//        int n = a.length();
//        int m = b.length();
//        int l = m / n;
//        // 下界
//        if(m%n!=0) l++;
//        // 上届
//        int r=l+1;
//        // 直接把上届赋值给a
//        int tmp=r;
//        String match="";
//        while(tmp>0){
//            match+=a;
//            tmp--;
//        }
//        System.out.println(match);
//        n=match.length();
//        m++;
//        b="-"+b;
//        int[] next = getNext(b);
//        // kmp i:match指针 j：b指针
//        int i=0,j=1;
//        // 设置标志变量 判断是不是已经开始匹配了
//        while(j<m){
//            if(j==0 && i>=a.length()) break;
//            // 如果超过一个a还没有匹配成功 直接退出
//            if(j==0 || b.charAt(j)==match.charAt(i)){
//                i++;j++;
//            }else if(b.charAt(j) != match.charAt(i)){
//                j=next[j];
//            }
//            else if(i>=a.length()) break;
//        }
//        // 匹配成功
//        for (char c : match.toCharArray()) {
//            System.out.print(c + " ");
//        }
//        System.out.println();
//        System.out.println("匹配结束的位置时"+i);
//        System.out.println("l*a.length的下标为"+l*a.length());
//        if(j==m){
//            // 如果匹配的结束位置小于等于下届的长度 返回下届 否则 返回上界的长度
//            if(i-1<l*a.length()) return l;
//            else return r;
//        }else return -1;
//    }
//    public int[] getNext(String b){
//        int n = b.length();
//        int i = 0, j = 1;
//        int[] next=new int[n];
//        next[0]=-1;next[1]=0;
//        while(j<n-1){
//            if(i==0||b.charAt(i)==b.charAt(j)){
//                i++;j++;
//                if(b.charAt(i)==b.charAt(j)) next[j]=next[i];
//                else next[j]=i;
//            }else i=next[i];
//        }
//        return next;
//    }
}
