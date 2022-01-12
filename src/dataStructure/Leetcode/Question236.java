package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/11/4 16:07
 */
public class Question236 {
//    HashMap<TreeNode,TreeNode> map=new HashMap<>();
//    int pDepth;
//    int qDepth;
//    TreeNode p;
//    TreeNode q;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        this.p=p;
//        this.q=q;
//        dfs(null,root,1);
//        int i;
//        if(pDepth>qDepth){
//            for(i=pDepth;i>qDepth;i--){
//                p=map.get(p);
//            }
//            if(p==q) return p;
//            for(;i>1;i--){
//                p=map.get(p);
//                q=map.get(q);
//                if(p==q) return p;
//            }
//        }else if(qDepth>pDepth){
//            for(i=qDepth;i>pDepth;i--){
//                q=map.get(q);
//            }
//            if(q==p) return q;
//            for(;i>1;i--){
//                p=map.get(p);
//                q=map.get(q);
//                if(q==p) return p;
//            }
//        }else{
//            int depth=pDepth;
//            for(i=depth;i>1;i--){
//                q=map.get(q);
//                p=map.get(p);
//                if(p==q) return p;
//            }
//        }
//
//        return null;
//    }
//    public void dfs(TreeNode from,TreeNode to,int depth){
//        if(to==null) return;
//        if(q==to) qDepth=depth;
//        else if(p==to) pDepth=depth;
//        map.put(to,from);
//        TreeNode left = to.left;
//        TreeNode right = to.right;
//        dfs(to,left,depth+1);
//        dfs(to,right,depth+1);
//    }

    //2
    HashMap<TreeNode,TreeNode> map=new HashMap<>();
    Set<Integer> set=new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p!=null){
            set.add(p.val);
            p=map.get(p);
        }
        while(q!=null){
            if(set.contains(q.val)) return q;
            q=map.get(q);
        }
        return null;
    }
    public void dfs(TreeNode root){
        if(root.left!=null){
            map.put(root.left,root);
            dfs(root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            dfs(root.right);
        }
    }
}
