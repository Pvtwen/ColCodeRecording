package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/2 9:48
 */
public class KY11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        solution(s);
    }
    static int index=0;
    public static TreeNode build(String s){
        char c = s.charAt(index++);
        if(c=='#') return  null;
        TreeNode tn = new TreeNode();
        tn.setC(c);
        if(s.charAt(index)=='#'){
            index++;
            if(s.charAt(index)=='#'){
                index++;
            }else{
                tn.setRight(build(s));
            }
        }else{
            tn.setLeft(build(s));
            tn.setRight(build(s));
        }
        return tn;
    }
    public static void solution(String s){
        TreeNode root = build(s);
        dfs(root);
    }
    public static void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        System.out.print(root.c+" ");
        dfs(root.right);
    }
}
class TreeNode{
    char c;
    TreeNode left;
    TreeNode right;
    TreeNode(){}

    public void setC(char c) {
        this.c = c;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}