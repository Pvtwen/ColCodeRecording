package Tree;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author 86153
 * @data 2021/6/14 16:25
 */
public class TreeUtils {
    //ǰ���������  ���ղ�������
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

    //ǰ���������  ����ǰ������
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

    //ǰ����������� �ݹ�
    public static void preOrder(BiTreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.data+"--");
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    //������������� �ǵݹ�
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

    //�������������  �ݹ�
    public static void inOrder(BiTreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.getLeftChild());
        System.out.print(node.getData()+"---");
        inOrder(node.getRightChild());
    }

    //������������� �ǵݹ�
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

    //������������� �ݹ�
    public static void postOrder(BiTreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getData()+"---");
    }

    //������������� �ǵݹ�
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
        System.out.println("ǰ��ݹ����");
        TreeUtils.preOrder(root);
        System.out.println("\n����ݹ����");
        TreeUtils.inOrder(root);
        System.out.println("\n�����ݹ����");
        TreeUtils.postOrder(root);
        System.out.println("\nǰ��ǵݹ����");
        TreeUtils.preOrder(root,stack);
        System.out.println("\n����ǵݹ����");
        TreeUtils.inOrder(root,stack);
        System.out.println("\n�����ǵݹ����");
        TreeUtils.postOrder(root,stack);
    }
}
