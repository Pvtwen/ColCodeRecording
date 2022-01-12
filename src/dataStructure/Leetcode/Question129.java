package dataStructure.Leetcode;

import dataStructure.Node.TreeNode;

/**
 * @author 86153
 * @data 2021/7/26 10:02
 *  求根节点到叶节点数字之和
 *  反思: 能够想到用递归来做(拼接字符串，最后Integer.parseInt())
 *          深度优先遍历
 *  正解: 所有数字之和=遍历左子树之和+遍历右子树之和  return dfs(root.left,sum)+dfs(root.right,sum)
 *  prevVal是之前节点的值
 */
public class Question129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int prevVal){
        if(root==null){
            return 0;
        }
        int sum=prevVal*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }
        return dfs(root.left,sum)+dfs(root.right,sum);
    }
}
