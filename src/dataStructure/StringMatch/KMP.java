package dataStructure.StringMatch;

/**
 * @author Yawen Cao
 * @data 2021/12/23 15:35
 * dp优化kmp
 */
public class KMP {
        public static void main(String[] args) {
        System.out.println(kmp("ABABBAAAAABABBAAAA", "AAB"));
    }
    public static boolean kmp(String main, String find) {
        find="-"+find;
        int[] next = getNext(find);
        for (int i : next) {
            System.out.println(i);
        }
        int length = find.length();
        int length1 = main.length();
        // i指向main  j指向find
        int i=0,j=1;
        while(i<length1 && j<length){
            if(j==0||find.charAt(j)==main.charAt(i)){
                i++;
                j++;
            }else j=next[j];
        }
        if(j==length) return true;
        return false;
    }
    // 优化getnext函数
//    public static int[] getNext(String myString){
//        int n = myString.length();
//        int[] next=new int[n];
//        next[0]=-1;next[1]=0;
//        int i=1,j=0;
//        while(i<n-1){
//            if(j==0 || myString.charAt(i)==myString.charAt(j)){
//                i++;j++;
//                if(myString.charAt(i)==myString.charAt(j)) next[i]=next[j];
//                else next[i]=j;
//            }else j=next[j];
//        }
//        return next;
//    }

//
//    public static int[] getNext(String myString){
//        int n = myString.length();
//        int[] dp=new int[n];
//        int i=0,j=1;
//        while(j<n-1){
//            if(j==0 || myString.charAt(i)==myString.charAt(j)){
//                i++;
//                j++;
//                if(myString.charAt(i)==myString.charAt(j)) dp[j]=dp[i];
//                else dp[j]=i;
//            }else i=dp[i];
//        }
//        return dp;
//    }


    public static int[] getNext(String myStringStr) {
        int n = myStringStr.length();
        int[] next = new int[n];
        next[0]=-1;next[1]=0;
        // 双指针 快指针i  慢指针j
        int i=1,j=0;
        while(i<n-1){
            if(j==0 || myStringStr.charAt(i)==myStringStr.charAt(j)) {
                i++;
                j++;
                next[i]=j;
            }else j=next[j];
        }
        return next;
    }

//    static boolean[][] dp;
//    public static void main(String[] args) {
//        System.out.println(kmp("ABABBAAAAABABBAAAA", "ABAABCAC"));
//    }
//    public static boolean kmp(String  main,String find){
//        // 先对find进行预处理
//        find = "-" + find;
//        int n = find.length();
//        int[] next = new int[n];
//        next[1] = 0;
//        next[0]=-1;
//        int idx=2;
//        char[] chars = find.toCharArray();
//        // 用dp思想预先对num中的重叠值结算
//        dp = new boolean[n][n];
//
////        for(int i=1;i<n;i++){
////            char c = find.charAt(i);
////            char fir = find.charAt(0);
////            if(c==fir) dp[i][i]=true;
////            else{
////                Arrays.fill(dp[i],false);
////            }
////        }
//
//        for(int i=1;i<n;i++){
//            for(int j=i;j<n;j++){
//                char c = find.charAt(j);
//                if(j==i) dp[i][i]=(c==find.charAt(1));
//                else{
//                    dp[i][j]=dp[i][j-1]&&(c==find.charAt(j-i+1));
//                }
//                // 如果dp[i][j]不能构成重叠 那么之后的字符也不能构成重叠了
//                if(dp[i][j]==false) break;
//            }
//        }
////        for (int i = 1; i < n; i++) {
////            System.out.print(i+":");
////            for (int j = i; j < n; j++) {
////                System.out.print(dp[i][j]+" ");
////            }
////            System.out.println();
////        }
//        for(int i=2;i<n;i++){
//            String s = new String(chars, 1, i - 1);
//            int num = num(s);
//            next[idx]=num;
//            idx++;
//        }
//        int length = main.length();
//        // l:main数组的指针
//        int l=1;
//        for(int i=0;i<=length-n+1;i++){
//            int pointer = 1;
//            int tmp=i;
//            while(pointer<n && next[pointer]!=-1){
//                char c = main.charAt(tmp);
//                char c1 = find.charAt(pointer);
//                if(c==c1){
//                    pointer++;
//                    tmp++;
//                }else{
//                    pointer=next[pointer];
//                }
//            }
//            if(pointer==n) return true;
//        }
//        for (int i : next) {
//            System.out.println(i);
//        }
//        return false;
//    }
//
//    public static int num(String find){
//        int length = find.length();
//        int start=0,end=length-1;
//        for(int i=start;i<=end;i++){
//            if (!dp[i][end]) {
//                return end - i + 1;
//            }
//        }
//        return 1;
//    }

//    public static int num(String prefix) {
//        char[] arr = prefix.toCharArray();
//        int length = prefix.length();
//        int maxPrefixLen = 0;
//        for (int i = 0; i < length-1; i++) {
//            // l:左边界的起始位置 r:右边界的起始位置
//            int l = 0, r = length - 1 - i;
//            // 长度为i+1
//            String back = new String(arr, r, i + 1);
//            String pre = new String(arr, l, i + 1);
//            if(back.equals(pre)) maxPrefixLen=i+1;
//        }
//        return maxPrefixLen+1;
//    }
}
