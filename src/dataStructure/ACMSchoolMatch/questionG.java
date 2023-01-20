package dataStructure.ACMSchoolMatch;
import java.util.*;
/**
 * @author Yawen Cao
 * @data 2021/12/20 15:57
 */
public class questionG {
    static HashMap<Integer, Integer> map = new HashMap<>();   // k:�ڵ� v:����n����̲���
    static HashMap<Integer, List<Integer>> distan = new HashMap<>();

    // ����dp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 1;
        int[] arr = new int[n + 1];
        while (n > 0) {
            arr[idx] = sc.nextInt();
            idx++;
            n--;
        }
        n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            int dest = arr[i];
            dp[i][dest] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 1;
        }
        for (int len = 2; len < n; len++) {
            for (int l = 0; l + len < n; l++) {
                int r = l + len;
                if (dp[l][r] == 1) continue;
                dp[l][r] = n + 1;
                for (int x = l + 1; x < r; x++) {
                    dp[l][r] = Math.min(dp[l][x] + dp[x][r], dp[l][r]);
                }
            }
        }
        for(int i=1;i<n-1;i++){
            System.out.print(dp[0][i] + " ");
        }
        System.out.print(dp[0][n-1]);
    }
}
//     dp
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int idx=1;
//        int[] arr = new int[n+1];
//        while(n>0){
//            arr[idx]=sc.nextInt();
//            idx++;
//            n--;
//        }
//        n = arr.length;
//        int[] dp=new int[n];
//        Arrays.fill(dp,n+1);
//        dp[0]=0;
//        for(int i=0;i+1<n;i++){
////            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
//            dp[i+1]=Math.min(dp[i]+1,dp[i+1]);
//            dp[arr[i]]=Math.min(dp[i]+1,dp[arr[i]]);
//        }
//        for(int i=1;i<n-1;i++){
//            System.out.print(dp[i]+" ");
//        }
//        System.out.print(dp[n-1]);
//    }
//}

    // ����dp ����д��
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int idx=0;
//        int[] arr=new int[n];
//        while(n>0){
//            arr[idx]=sc.nextInt();
//            idx++;
//            n--;
//        }
//        n=arr.length;
//        int[][] dp=new int[n+1][n+1];
//        for (int[] ints : dp) {
//            Arrays.fill(ints,n+1);
//        }
//        for(int i=0;i<n;i++){
//            int i1 = arr[i];
//            // ��ʼ���ݾ�
//            if(i1!=i+1){
//                dp[i+1][i1]=1;
//            }
//        }
//        for(int len=1;len<=n;len++){
//            for(int i=0;i+len<=n;i++){
//                int j=i+len;
//                if(len==1) {
//                    dp[i][j] = 1;
//                    continue;
//                }
//                // ת��
//                dp[i][j]=Math.min(Math.min(dp[i+1][j]+1,dp[i][j-1]+1),dp[i][j]);
//            }
//        }
//        for(int i=1;i<n;i++){
//            System.out.print(dp[0][i]+" ");
//        }
//        System.out.print(dp[0][n]);
//    }

//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int idx=0;
//        int[] arr=new int[n];
//        while(n>0){
//            arr[idx]=sc.nextInt();
//            idx++;
//            n--;
//        }
//        n=arr.length;
//        ArrayList<Integer>[] lists=new ArrayList[n+1];
//        for(int i=0;i<=n;i++){
//            lists[i]=new ArrayList<>();
//        }
//        lists[0].add(1);
//        for(int i=0;i<n-1;i++){
//            if(arr[i]==i+1||arr[i]==i+2){
//                lists[i+1].add(i+2);
//                continue;
//            }
//            lists[i+1].add(arr[i]);
//            lists[i+1].add(i+2);
//        }
//        // ÿ���ڵ㵽���սڵ�����·��
//        dfs(0,lists);
//        // ����map
//        for (Map.Entry<Integer, List<Integer>> entry : distan.entrySet()) {
//            Integer node = entry.getKey();
//            List<Integer> step = entry.getValue();
//            Collections.sort(step);
//            System.out.print("�ڵ�"+node+"���յ�����·��Ϊ");
//            for (Integer s : step) {
//                System.out.print(s+" ");
//            }
//            System.out.println();
//        }
//    }
//
//    // ���仯�ݹ� ��ӡ·��
//    public static List<Integer> dfs(int curNode, ArrayList<Integer>[] lists) {
//        // ���������һ��
//        if (curNode == lists.length - 1) {
//            List<Integer> copy=new ArrayList<>();
//            copy.add(curNode);
//            distan.put(curNode,copy);
//            return copy;
//        }
//        if(distan.containsKey(curNode)) return distan.get(curNode);
//        for (Integer neigh : lists[curNode]) {
//            List<Integer> step = dfs(neigh,lists);
//            List<Integer> copy=new ArrayList<>(step);
//            if (!distan.containsKey(curNode)) {
//                copy.add(curNode);
//                distan.put(curNode, copy);
//            } else {
//                List<Integer> steps = distan.get(curNode);
//                if (steps.size()>step.size()+1){
//                    copy.add(curNode);
//                    distan.put(curNode,copy);
//                }
//            }
//        }
//        return distan.get(curNode);
//    }

//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n = sc.nextInt();
//        int idx=0;
//        int[] arr=new int[n];
//        while(n>0){
//            arr[idx]=sc.nextInt();
//            idx++;
//            n--;
//        }
//        n=arr.length;
//        ArrayList<Integer>[] lists=new ArrayList[n+1];
//        for(int i=0;i<=n;i++){
//            lists[i]=new ArrayList<>();
//        }
//        // i+1����ǰ�ڵ�
//        for(int i=n-1;i>=0;i--){
//            if(i+1==arr[i]||arr[i]==i+2){
//                lists[i+1].add(i);
//                continue;
//            }
//            lists[i+1].add(i);
//            lists[arr[i]].add(i+1);
//        }
//        int[] dp=new int[n+1];
//        dfs(n, lists);
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer node = entry.getKey();
//            Integer dist = entry.getValue();
//            dp[node]=dist;
//        }
//        for(int i=1;i<n;i++){
//            System.out.print(dp[i]+" ");
//        }
//        System.out.print(dp[n]);
//    }
    // ���仯�ݹ�
//    public static int dfs(int curNode, ArrayList<Integer>[] lists) {
//        // ���������һ���ڵ�
//        if (curNode == 0){
//            return 0;
//        }
//        if(map.containsKey(curNode)) return map.get(curNode);
//        int step=lists.length+1;
//        for (Integer neigh : lists[curNode]) {
//            step = Math.min(step, dfs(neigh, lists) + 1);
//        }
//        map.put(curNode,step);
//        return step;
//    }
//
//     ������ʱ curNode:��ǰ�ڵ� step:��ǰ����
//    public static void dfs(int[] dp,int curNode,int step,ArrayList<Integer>[] lists){
//        if(dp[curNode]>step) dp[curNode]=step;
//        if(curNode==dp.length-1) return;
//        for (Integer neigh : lists[curNode]) {
//            dfs(dp,neigh,step+1,lists);
//        }
//    }
//}
