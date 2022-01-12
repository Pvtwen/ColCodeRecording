package dataStructure.Leetcode.LUCCUP;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/9/25 15:05
 */
public class Question1 {
    Set<Integer> set;
    int sum=0;
    public int numColor(TreeNode root) {
        set=new HashSet<>();
        recursion(root);
        return sum;
    }

    public void recursion(TreeNode node){
        if(node==null) return;
        if(!set.contains(node.val)){
            set.add(node.val);
            sum++;
        }

        recursion(node.left);
        recursion(node.right);
    }
}
