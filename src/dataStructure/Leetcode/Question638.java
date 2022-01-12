package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/24 20:20
 */
public class Question638 {
//    static int res=Integer.MAX_VALUE;
//    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        int n=price.size();
//        int m=special.size();
//        int[][] specials=new int[n][n+1];
//        int[] need=new int[n];
//        int[] specialNum=new int[m];
//        int[] needCopy;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n+1;j++){
//                specials[i][j]=special.get(i).get(j);
//            }
//            need[i]=needs.get(i);
//        }
//        needCopy= Arrays.copyOf(need,n);
//        for(int i=0;i<n;i++){
//            dfs(specials,needCopy,specialNum,i,n,price,m);
//            needCopy= Arrays.copyOf(need,n);
//            specialNum=new int[m];
//        }
//        return res;
//    }
//
//    public static void dfs(int[][] speicials,int[] need,int[] specialNum,int special,int n,List<Integer> price,int m){
//        int flag=1;
//        int[] needCopy = Arrays.copyOf(need, n);
//        for(int i=0;i<n;i++){
//            int sub = needCopy[i] - speicials[special][i];
//            if(sub<0) {
//                int ret = compute(specialNum, n, price, need,speicials);
//                res=Math.min(res,ret);
//                return ;
//            }
//            if(sub!=0) flag=-1;
//            needCopy[i]=sub;
//        }
//        need=needCopy;
//        specialNum[special]+=1;
//        if(flag==1) {
//            int ret = compute(specialNum, n, price, need,speicials);
//            res=Math.min(res,ret);
//            return ;
//        }
//
//        for(int j=special;j<m;j++){
//            dfs(speicials,need,specialNum,special,n,price,m);
//        }
//    }
//
//    public static int compute(int[] specialNum,int n,List<Integer> price,int[] need,int[][] speicials){
//        int total=0;
//        for(int i=0;i<n;i++){
//            total+=specialNum[i]*speicials[i][n];
//            total+=need[i]*price.get(i);
//        }
//        return total;
//    }
//    HashMap<List<Integer>,Integer> map;
//    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        int n=price.size();
//        map=new HashMap<>();
//        return dfs(n,price,special,needs);
//    }
//
//    public int dfs(int n,List<Integer> price,List<List<Integer>> special,List<Integer> needs){
//        if(map.containsKey(needs)) return map.get(needs);
//        int ans=0;
//        //剩余的需求全部单买  不使用大礼包
//        for(int i=0;i<n;i++){
//            ans+=price.get(i)*needs.get(i);
//        }
//
//        // 暴搜
//        for (List<Integer> singleBag : special) {
//            int flag=-1;
//            List<Integer> need=new ArrayList<>(needs);
//            for(int i=0;i<n;i++){
//                if(need.get(i)-singleBag.get(i)<0){
//                    flag=1;
//                    break;
//                }
//                need.set(i,need.get(i)-singleBag.get(i));
//            }
//            if(flag==-1)
//                map.put(need,singleBag.get(n));
//                ans=Math.min(ans,singleBag.get(n)+dfs(n,price,special,need));
//        }
//        return ans;
//    }

    Set<List<Integer>> set;
    int res=Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n=price.size();
        set=new HashSet<>();
        dfs(needs,price,special,0,n);

        return res;
    }

    public void dfs(List<Integer> needs,List<Integer> price,List<List<Integer>> special,int money,int n){
        if(set.contains(needs)) return;
        for (List<Integer> singleBag : special) {
            List<Integer> need=new ArrayList<>(needs);
            int flag=-1;
            for(int i=0;i<n;i++){
                if(need.get(i)-singleBag.get(i)<0){
                    flag=1;
                    break;
                }
                need.set(i,need.get(i)-singleBag.get(i));
            }
            if(flag==-1){
                dfs(need,price,special,money+singleBag.get(n),n);
                set.add(needs);
            }
        }

        for(int i=0;i<n;i++){
            money+=needs.get(i)*price.get(i);
        }
        res=Math.min(res,money);
    }
}
