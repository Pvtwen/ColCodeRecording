package Tree;

import dataStructure.Node.TreeNode;

/**
 * @author 86153
 * @data 2021/6/28 20:57
 */
public class TreeNodeUtils {
    //前序遍历二叉树 递归
    public static void preOrder(TreeNode node){
        if(node==null){
            System.out.print(node);
            return;
        }
        System.out.print(node.val+"--");
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历二叉树  递归
    public static void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+"---");
        inOrder(node.right);
    }

    //后序遍历二叉树 递归
    public static void postOrder(TreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+"---");
    }
}
