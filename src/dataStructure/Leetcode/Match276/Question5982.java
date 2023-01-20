package dataStructure.Leetcode.Match276;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/1/16 11:27
 */
public class Question5982 {
    // ����dp
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        long[] dp= new long[n + 1];
//        dp[0]=questions[0][0];
//        for(int i=0;i<n;i++){
//            dp[i+1]=Math.max(dp[i],dp[i+1]);
//            int s=questions[i][1]+i+1;
//            if(s>n){
//                dp[n]=Math.max(dp[n],dp[i]+questions[i][0]);
//            }else{
//                dp[s]=Math.max(dp[s],dp[i]+questions[i][0]);
//            }
//        }
//        return dp[n];
//    }

    // ����dp ����dp[i]: i~n-1���ܻ�ȡ��������
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        long[] dp= new long[n + 1];
//        for(int i=n-1;i>=0;i--){
//            int j=i+questions[i][1]+1;
//            long doI;
//            if(j<n){
//                doI=questions[i][0]+dp[j];
//            }else doI=questions[i][0];
//            dp[i]=Math.max(doI,dp[i+1]);
//        }
//        return dp[0];
//    }

    // ��ʱ����dp
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        if(n==1) return questions[0][0];
//        long[] dp= new long[n];
//        dp[0]=questions[0][0];
//        long ret=0;
//        for(int i=1;i<n;i++){
//            dp[i]=questions[i][0];
//            for(int j=i-1;j>=0;j--){
//                int s=questions[j][1]+j+1;
//                if(s>i){
//                    continue;
//                }else{
//                    dp[i]=Math.max(dp[j]+questions[i][0],dp[i]);
//                }
//            }
//            ret=Math.max(ret,dp[i]);
//        }
//        return ret;
//    }

    // ����ʱ ���仯
//    public long dfs(int[][] q,int i){
//        if(i>=q.length) return 0;
//        if(set[i]!=0) return set[i];
//        long sum=0;
//        // do it
//        long dfs = dfs(q, i + q[i][1] + 1);
//        sum=Math.max(sum,dfs+q[i][0]);
//        // not do it
//        long dfs1 = dfs(q, i + 1);
//        sum=Math.max(sum,dfs1);
//        set[i]=sum;
//        return sum;
//    }

    // ��ʱ���仯
//        long[] set;
//    HashMap<String,Integer> map=new HashMap<>();
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        set=new long[n];
//        return dfs(questions,0);
//    }
//    public long dfs(int[][] q, int idx){
//        if(set[idx]!=0) return set[idx];
//        if(idx>=q.length){
//            return 0;
//        }
//        long sum=0;
//        for(int start=idx;start<q.length;start++){
//            int s=q[start][1]+start+1;
//            long dfs = dfs(q, s);
//            sum=Math.max(sum,dfs+q[start][0]);
//        }
//        set[idx]=sum;
//        return sum;
//    }

    //��idx��ʼ�����Ա���  ��ʱ���仯+����
//    public void dfs(int[][] q, int idx, int sum, List<Integer> list){
//        if(idx>=q.length){
//            // ��ӡ����
//            System.out.println("��Ϊ"+sum+"ʱ�ķ���");
//            for (Integer id : list) {
//                System.out.print(id+" ");
//            }
//            System.out.println();
//            ret=Math.max(ret,sum);
//            return;
//        }
//        for(int start=idx;start<q.length;start++){
//            ArrayList<Integer> copy=new ArrayList<>(list);
//            int s=q[start][1]+start+1;
//            copy.add(start);
//            dfs(q,s,sum+q[start][0],copy);
//        }
//    }
}
