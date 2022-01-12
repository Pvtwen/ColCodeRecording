package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/11/5 9:46
 */
public class Question337 {
//    static HashMap<TreeNode,Integer> selectMap=new HashMap<>();
//    static  HashMap<TreeNode,Integer> nonSelectMap=new HashMap<>();
//    public static int rob(TreeNode root) {
//        dfs(root);
//        return Math.max(selectMap.get(root),nonSelectMap.get(root));
//    }
//    public static void dfs(TreeNode root){
//        if(root==null) return;
//        if(root.left==null && root.right==null){
//            selectMap.put(root,root.val);
//            nonSelectMap.put(root,0);
//            return;
//        }
//
//        int nonSelectValue=0;
//        int selectValue=0;
//        if(root.left!=null){
//            dfs(root.left);
//            // 选中root
//            selectValue+=nonSelectMap.get(root.left);
//            // 不选root
//            nonSelectValue+=Math.max(selectMap.get(root.left),nonSelectMap.get(root.left));
//        }
//        if(root.right!=null){
//            dfs(root.right);
//            selectValue+=nonSelectMap.get(root.right);
//            nonSelectValue+=Math.max(selectMap.get(root.right),nonSelectMap.get(root.right));
//        }
//        selectMap.put(root,selectValue+root.val);
//        nonSelectMap.put(root,nonSelectValue);
//    }


    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0],dfs[1]);
    }

    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        int selectValue=root.val+l[1]+r[1];
        int nonSelectValue=Math.max(l[0],l[1])+Math.max(r[0],r[1]);
        return new int[]{selectValue,nonSelectValue};
    }
}
