package dataStructure.Test.ThougtAbout2080AndReversedIndex;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/12/2 20:06
 */
public class ReversedIndex {
    // 数据结构 这里的TreeNode对应的节点应该是已经够造好二叉搜索树的根节点  方便后续查找
    HashMap<String, TreeNode> map = new HashMap<>();
    // 给定word需要查找的单词  fileId是单词是否在该文档当中出现过
    public boolean findEle(int fileId,String word){
        TreeNode root = map.get(word);
        while(root!=null){
            int val = root.val;
            if(val==fileId) return true;
            if(val>fileId) root=root.left;
            else root=root.right;
        }
        return false;
    }
}
