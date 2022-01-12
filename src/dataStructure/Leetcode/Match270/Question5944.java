package dataStructure.Leetcode.Match270;

import dataStructure.Node.TreeNode;
/**
 * @author Yawen Cao
 * @data 2021/12/5 10:54
 */
public class Question5944 {
    String start="";
    String end="";
    int startFlag=-1;
    int endFlag=-1;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root,startValue,destValue,"");
        int idx=0;
        char[] staArr = start.toCharArray();
        char[] endArr = end.toCharArray();
        int length=start.length();
        int length1 = end.length();
        while (idx<length && idx<length1 && staArr[idx] == endArr[idx]) {
            idx++;
        }
        for(int i=idx;i<length;i++){
            staArr[i]='U';
        }
//        for (char c : staArr) {
//            System.out.println(c);
//        }
//        System.out.println();
//        for (char c : endArr) {
//            System.out.println(c);
//        }
//        String ret="";
        StringBuilder ret = new StringBuilder();
        ret.append(new String(staArr,idx,length-idx));
        ret.append(new String(endArr,idx,length1-idx));
//        ret+=new String(staArr,idx,length-idx);
//        ret+=new String(endArr,idx,length1-idx);
        return ret.toString();
    }
    public void dfs(TreeNode root,int startValue,int endValue,String path){
        if(root.val==startValue){
            start=path;
            startFlag=1;
        }
        if (root.val == endValue) {
            end=path;
            endFlag = 1;
        }
        if(startFlag==1 && endFlag==1) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left!=null) dfs(left,startValue,endValue,path+"L");
        if(right!=null) dfs(right,startValue,endValue,path+"R");
    }

//    HashMap<Integer,TreeNode> map=new HashMap<>();
//    int startDepth=-1;
//    int destDepth=-1;
//    String path="";
//    public String getDirections(TreeNode root, int startValue, int destValue) {
//        int depth=0;
//        // 递归 将每个节点的父节点和该节点的值放入哈希表, 并同时得到开始节点的深度和终点的深度，方便后续分情况讨论
//        dfs(root, startValue, destValue, depth);
//        // 开始节点的路径
//        String l="";
//        // 从终点回头找的路径
//        String r="";
//        // 如果终点的深度更深 则先从终点往回找，直到深度相同
//        if(startDepth<destDepth){
//            TreeNode par2 = map.get(destValue);
//            TreeNode par1 = map.get(startValue);
//            while(par2.val!=startValue && startDepth<destDepth){
//                String direction = direction(par2, destValue);
//                r=direction+r;
//                destValue=par2.val;
//                par2=map.get(par2.val);
//                destDepth--;
//            }
//            // 循环结束条件的判断  看是否是因为匹配了 还是 因为深度相同才退出循环
//            if(par2.val==startValue) {
//                String direction = direction(par2, destValue);
//                r=direction+r;
//                return r;
//            }
//            if(startDepth==destDepth){
//                while(par1!=par2){
//                    // 更新
//                    l+="U";
//                    String direction = direction(par2, destValue);
//                    r=direction+r;
//                    destValue=par2.val;
//
//                    par1=map.get(par1.val);
//                    par2 = map.get(par2.val);
//                }
//                String direction = direction(par2, destValue);
//                l+="U";
//                r=direction+r;
//                return l+r;
//            }
//            // 开始节点的深度大于终点的深度 思路和前面一样
//        }else if(startDepth>destDepth){
//            TreeNode par1 = map.get(startValue);
//            TreeNode par2 = map.get(destValue);
//            while(par1.val!=destValue && startDepth>destDepth){
//                l+="U";
////                startValue=par1.val;
//                par1=map.get(par1.val);
//                startDepth--;
//            }
//            if(par1.val==destValue){
//                l+="U";
//                return l;
//            }
//            if(startDepth==destDepth){
//                while(par1!=par2){
//                    // 更新
//                    l+="U";
//                    String direction = direction(par2, destValue);
//                    r=direction+r;
//                    destValue=par2.val;
//
//                    par1=map.get(par1.val);
//                    par2 = map.get(par2.val);
//                }
//                String direction = direction(par2, destValue);
//                l+="U";
//                r=direction+r;
//                return l+r;
//            }
//        }else{
//            // 两者深度相同
//            TreeNode par1 = map.get(startValue);
//            TreeNode par2 = map.get(destValue);
//
//            while(par1!=par2){
//                // 更新
//                l+="U";
//                String direction = direction(par2, destValue);
//                r=direction+r;
//                destValue=par2.val;
//
//                par1=map.get(par1.val);
//                par2 = map.get(par2.val);
//            }
//            String direction = direction(par2, destValue);
//            l+="U";
//            r=direction+r;
//            return l+r;
//        }
//        return l+r;
//    }
//    // 只用判断右节点方向 因为左节点只可能是 "U"
//    public String direction(TreeNode par,int val){
//        if(par.left!=null && par.left.val==val) return "L";
//        else if(par.right!=null && par.right.val==val) return "R";
//        return null;
//    }
//    public void dfs(TreeNode root,int startValue,int destValue,int depth){
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        int val = root.val;
//        if(val==startValue){
//            startDepth=depth;
//        }
//        if(val==destValue){
//            destDepth=depth;
//        }
//        // 如果开始节点和结束节点都被找到 则回溯
//        if(startDepth!=-1 && destDepth!=-1) return;
//        if(left!=null){
//            map.put(left.val,root);
//            dfs(left,startValue,destValue,depth+1);
//        }
//        if(right!=null){
//            map.put(right.val,root);
//            dfs(right,startValue,destValue,depth+1);
//        }
//    }
}
//   class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }
