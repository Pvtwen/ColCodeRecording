package dataStructure.Leetcode;

import dataStructure.Leetcode.Node.TreeNode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/25 9:39
 */
public class Question1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<List<TreeNode>> queue=new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        queue.offer(list);

        int level=0;
        while (!queue.isEmpty()) {
            List<TreeNode> lis = queue.poll();
            // 判断lis中的元素是否是单增或者是单键  且是否满足 偶数奇数
            boolean condition = isCondition(lis, level);
            if(!condition) return false;
            List<TreeNode> newLis=new ArrayList<>();
            for (TreeNode li : lis) {
                if(li.left!=null) newLis.add(li.left);
                if(li.right!=null) newLis.add(li.right);
            }
            if(newLis.size()!=0) queue.offer(newLis);
            level++;
        }
        return true;
    }
    // 判断严格单增 单键
    public boolean isCondition(List<TreeNode> list,int level){
        // level=0 奇数 严格丹增
        if(level%2==0){
            int pre=-1;
            for (TreeNode treeNode : list) {
                int val = treeNode.val;
                if(val>pre && val%2!=0) pre=val;
                else return false;
            }
            return true;
        }
        // level=1 偶数 单键
        else {
            int pre= (int) 1e7;
            for (TreeNode treeNode : list) {
                int val = treeNode.val;
                if(val<pre && val%2==0) pre=val;
                else return false;
            }
            return true;
        }
    }
}
