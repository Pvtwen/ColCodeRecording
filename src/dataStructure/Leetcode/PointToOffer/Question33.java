package dataStructure.Leetcode.PointToOffer;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/7/22 11:48
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Question33 {
    public static boolean verifyPostorder(int[] postorder) {
        return recursion(postorder,0,postorder.length-1);
    }
    public static boolean recursion(int[] postorder,int l,int r){
        // 这里是l>=r 而不是l==r 原因是可能出现迭代到 {1,2,5,10,6,9,4,3} 中的1，2时，会出现 recursion(postorder,0,0) && recursion(postorder,1,0)
        //的情况 ， 因为 2为根，1为左子树，没有右子树
        if(l>=r){
            return true;
        }
        int i=l;
        while(postorder[l]<postorder[r]){
            l++;
        }
        int m=l;    //m为左子树的区间
        while(postorder[l]>postorder[r]){
            l++;
        }
        return l==r && recursion(postorder,i, m-1) && recursion(postorder,m,r-1);
    }
}
