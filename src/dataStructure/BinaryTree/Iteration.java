package dataStructure.BinaryTree;

import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2021/12/6 9:31
 * 前中后的非递归遍历
 */
public class Iteration {
    public void backIteration(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        findLeft(root,stack);
        int count=1;
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            TreeNode right = pop.right;
            int flag = pop.flag;
            if(flag==-1){
                pop.flag=1;
                stack.push(pop);
                if(right==null){
                    continue;
                }else findLeft(right,stack);
            }else if(flag==1){
                System.out.println(count+++":"+pop.val);
            }
        }
    }

    public void midIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        findLeft(root, stack);
        int count=1;
        while(!stack.isEmpty()){
            TreeNode left = stack.pop();
            System.out.println(count++ + ":" + left.val);
            TreeNode right = left.right;
            if(right!=null){
                findLeft(right,stack);
            }
        }
    }

    public TreeNode findLeft(TreeNode root, Stack<TreeNode> stack) {
        stack.push(root);
        while (root.left != null) {
            root=root.left;
            stack.push(root);
        }
        return root;
    }
    public void preIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count=1;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            int val = pop.val;
            System.out.println(count+++":"+val);
            TreeNode right = pop.right;
            TreeNode left = pop.left;
            if(right!=null){
                stack.push(right);
            }
            if(left!=null){
                stack.push(left);
            }
        }
    }
}
class TreeNode{
    public int val;
    public  TreeNode left;
    public TreeNode right;
    int flag=-1;
    public TreeNode() {
    }
    public TreeNode(int val){
        this.val=val;
    }
}
