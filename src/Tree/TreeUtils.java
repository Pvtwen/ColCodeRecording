package Tree;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 86153
 * @data 2021/6/14 16:25
 */
public class TreeUtils {
    //前序构造二叉树  按照层序输入
    static int index=0;
    public static BiTreeNode buildTree(String str,int index){
        char c = str.charAt(index);
        if(c=='#'){
            return null;
        }
        BiTreeNode node=new BiTreeNode();
        node.setData(c);
        node.setLeftChild(buildTree(str,2*index+1));
        node.setRightChild(buildTree(str,2*index+2));
        return node;
    }

    //前序构造二叉树  按照前序输入
    public static BiTreeNode  buildTree(String str){
        char c = str.charAt(index++);
        if(c=='#'){
            return null;
        }
        BiTreeNode node = new BiTreeNode();
        node.setData(c);
        node.setLeftChild(buildTree(str));
        node.setRightChild(buildTree(str));
        return node;
    }

    //前序遍历二叉树 递归
    public static void preOrder(BiTreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.data+"--");
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    //先序遍历二叉树 非递归
    public static void preOrder(BiTreeNode node, Stack<BiTreeNode> stack){
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                System.out.print(node.getData()+"---");
                stack.push(node);
                node=node.getLeftChild();
            }
            else{
                node = stack.pop();
                node= node.getRightChild();
            }
        }
    }

    //中序遍历二叉树  递归
    public static void inOrder(BiTreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.getLeftChild());
        System.out.print(node.getData()+"---");
        inOrder(node.getRightChild());
    }

    //中序遍历二叉树 非递归
    public static void inOrder(BiTreeNode node,Stack<BiTreeNode> stack){
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.getLeftChild();
            }
            else{
                node=stack.pop();
                System.out.print(node.getData()+"---");
                node=node.getRightChild();
            }
        }
    }

    //后序遍历二叉树 递归
    public static void postOrder(BiTreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getData()+"---");
    }

    //后序遍历二叉树 非递归
    public static void postOrder(BiTreeNode node,Stack<BiTreeNode> stack){
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.getLeftChild();
            }
            else{
                node=stack.pop();
                if(node.isFirst==true){
                    node.isFirst=false;
                    stack.push(node);
                    node=node.getRightChild();
                }
                else{
                    System.out.print(node.getData()+"---");
                    node=null;
                }
            }
        }
    }
}

class myTest{
    public static void main(String[] args) {
//        BiTreeNode D=new BiTreeNode(null,null,'D');
//        BiTreeNode B=new BiTreeNode(D,null,'B');
//        BiTreeNode C=new BiTreeNode(null,null,'C');
        String str="ABCD#####";
        String str1="ABC##D##E##";
        Stack<BiTreeNode> stack=new Stack<>();
//        BiTreeNode root = TreeUtils.buildTree(str, 0);
        BiTreeNode root = TreeUtils.buildTree(str1);
        System.out.println("前序递归遍历");
        TreeUtils.preOrder(root);
        System.out.println("\n中序递归遍历");
        TreeUtils.inOrder(root);
        System.out.println("\n后续递归遍历");
        TreeUtils.postOrder(root);
        System.out.println("\n前序非递归遍历");
        TreeUtils.preOrder(root,stack);
        System.out.println("\n中序非递归遍历");
        TreeUtils.inOrder(root,stack);
        System.out.println("\n后续非递归遍历");
        TreeUtils.postOrder(root,stack);
    }
}
