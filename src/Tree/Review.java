package Tree;

import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2022/2/5 9:52
 */
public class Review {
    // 非递归前序遍历二叉树
    public void preOrder(BiTreeNode node, Stack<BiTreeNode>stack){
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                System.out.println(node.getData()+"----");
                stack.push(node);
                node=node.getLeftChild();
            }else{
                BiTreeNode pop = stack.pop();
                node=pop.getRightChild();
            }
        }
    }
    // 非递归中序遍历二叉树
    public void inOrder(BiTreeNode node,Stack<BiTreeNode> stack){
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.getLeftChild();
            }else{
                BiTreeNode pop = stack.pop();
                System.out.println(pop.getData()+"-----");
                node=pop.getRightChild();
            }
        }
    }
    // 非递归后续遍历二叉树
    public void postOrder(BiTreeNode node,Stack<BiTreeNode> stack){
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.getLeftChild();
            }else{
                BiTreeNode pop = stack.pop();
                if(pop.isFirst){
                    pop.isFirst=false;
                    stack.push(pop);
                    node=pop.getRightChild();
                }else{
                    System.out.println(pop.getData()+"---");
                }
            }
        }
    }
}
