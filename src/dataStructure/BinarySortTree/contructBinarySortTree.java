package dataStructure.BinarySortTree;

/**
 * @author Yawen Cao
 * @data 2021/12/2 9:16
 */
public class contructBinarySortTree {
    // 暴力构建二叉查找树 O(n* 2^n) 非平衡二叉树
    public void construct(int[] arr){
        int length = arr.length;
        TreeNode root=new TreeNode(arr[0]);
        for(int i=1;i<length;i++){
            dfs(arr[i],root);
        }
    }
    public void dfs(int con,TreeNode root){
        int val = root.val;
        if(con>val){
            if(root.right!=null){
                dfs(con,root.right);
            }else{
                TreeNode node=new TreeNode(con);
                root.right=node;
            }
        }else{
            if(root.left!=null){
                dfs(con,root.left);
            }else{
                TreeNode node=new TreeNode(con);
                root.left=node;
            }
        }
    }
}
