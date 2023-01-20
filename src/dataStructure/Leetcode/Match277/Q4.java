package dataStructure.Leetcode.Match277;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/1/23 11:00
 */
public class Q4 {
//    public int maximumGood(int[][] statements) {
//        int n = statements.length;
//        int max=0;
//        int temp=0;
//        for(int i=1;i<(1<<n);i++){
//            int flag=1;
//            int good=0;
//            for(int j=0;j<n;j++){
//                int flag1=1;
//                // 如果是好人 检验
//                if(((1<<j)&i)==(1<<j)){
//                    good++;
//                    for(int k=0;k<n;k++){
//                        if(k==j) continue;
//                        if(statements[j][k]==1){
//                            if(((1<<k)&i)!=(1<<k)){
//                                flag1=-1;
//                                break;
//                            }
//                        }
//                        else if(statements[j][k]==0){
//                            if(((1<<k)&i)!=0){
//                                flag1=-1;
//                                break;
//                            }
//                        }
//                    }
//                    if(flag1==-1){
//                        flag=-1;
//                        break;
//                    }
//                }
//            }
//            if(flag==-1) continue;
//            max=Math.max(max,good);
//            if(max==good){
//                temp=i;
//            }
//        }
//        System.out.println(temp);
//        return max;
//    }
    int max=0;
    int temp=0;
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        dfs(statements,0,vis);
        System.out.println(temp);
        return max;
    }
    // vis[i]=0坏人  vis[i]=1好人
    public void dfs(int[][] st,int cur,int[] vis){
        if(cur==st.length){
            int num=0;
            for(int i=0;i<st.length;i++){
                if(vis[i]==1) num++;
            }
            max=Math.max(max,num);
            int base=0;
            if(num==2) {
                for(int i=0;i<vis.length;i++){
                    if(vis[i]==1) base+=(1<<i);
                }
                temp=base;
            }
            return;
        }
        // 如果是坏人
        int[] copy = Arrays.copyOf(vis, vis.length);
        if(vis[cur]==0) dfs(st,cur+1,copy);
        // 如果是好人 或者还没确定
        copy = Arrays.copyOf(vis, vis.length);
        int flag=1;
        if(vis[cur]==1 || vis[cur]==-1){
            copy[cur]=1;
            for(int i=0;i<st.length;i++){
                if(cur==i) continue;
                if(st[cur][i]==2) continue;
                // 检查是否存在冲突 如果冲突则不能进行该步骤的dfs 下个步骤的dfs还需要进行特判
                if(copy[i]==0 && st[cur][i]!=0) {
                   flag=-1;
                   break;
                };
                if(copy[i]==1 && st[cur][i]!=1){
                    flag=-1;
                    break;
                }
                copy[i]=st[cur][i];
            }
            // 不冲突可以继续进行递归
            if(flag==1) dfs(st,cur+1,copy);
        }
        // 该步骤是假定cur为坏人 可以进行递归的前提条件是cur还没有判定 如果已经判定为好人 此时又把这个人改为坏人 会出错
        // 不加该特判 会卡在类似测试用例[[2,2,2,2],[1,2,1,0],[0,2,2,2],[0,0,0,2]]
        if(vis[cur]==-1){
            // copy在遍历statement时候已经改变 所以需要重新copy
            copy=Arrays.copyOf(vis,vis.length);
            copy[cur]=0;
            dfs(st,cur+1,copy);
        }
    }
}
