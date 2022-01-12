package dataStructure.BinaryTree;

/**
 * @author Yawen Cao
 * @data 2021/12/6 9:40
 */
public class testMain {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode root1=new TreeNode(2);
        TreeNode root2=new TreeNode(3);
        TreeNode root3=new TreeNode(4);
        TreeNode root4=new TreeNode(5);
        root.left=root1;root.right=root2;
        root1.left=root3;root1.right=root4;
        Iteration i= new Iteration();
        i.backIteration(root);
    }
}
