package dataStructure.BinarySortTree;

import lombok.val;

/**
 * @author Yawen Cao
 * @data 2021/12/2 9:12
 * 二叉搜索树亦称作二叉查找树
 */
public class binarySearch {
    // val:to be find
    // root: tree root

    // while循环搜索
    public boolean bsByWhile(int val,TreeNode root){
        while(root!=null){
            int val1 = root.val;
            if(val==val1) return true;
            else if(val>val1) root=root.right;
            else root=root.left;
        }
        return false;
    }
    // 递归遍历搜索
    public boolean bsByRecursion(int val,TreeNode root){
        return dfs(val,root);
    }
    public boolean dfs(int val,TreeNode root){
        if(root==null) return false;
        if(root.val==val) return true;

        int val1 = root.val;
        if(val>val1) return dfs(val,root.right);
        else return dfs(val,root.left);
    }

    // 往二叉查找树中添加节点 直接插入法
    public void insertImmediately(int val,TreeNode root){
        TreeNode n=new TreeNode(val);
        while(root!=null){
            int val1 = root.val;
            if(val>val1){
                TreeNode rightNode = root.right;
                if(rightNode==null){
                    root.right=n;
                    return;
                }
                int val2 = rightNode.val;
                // 大于根节点 小于右节点 直接插入 也可以继续寻找 这里先做直接插入
                if(val<val2){
                    root.right=n;
                    n.right=rightNode;
                }
                else if(val>val2){
                    root=root.right;
                }
            }
            else if(val<val1){
                TreeNode leftNode = root.left;
                if (leftNode == null) {
                    root.left=n;
                    return;
                }
                int val2 = leftNode.val;
                // 小于根节点 大于左节点 可以直接插入 也可以继续寻找 这里先做直接插入
                if(val>val2){
                    root.left=n;
                    n.left=leftNode;
                }
                // 如果小于左节点 继续搜寻
                else if (val<val2){
                    root=root.left;
                }
            }
        }
    }

    public void insertImmediatelyByRecusion(int val,TreeNode root){
        recursionImmediately(val,root);
    }
    public void recursionImmediately(int val,TreeNode root){
        int val1 = root.val;
        if(val>val1){
            TreeNode right = root.right;
            if(right==null){
                TreeNode n=new TreeNode(val);
                root.right=n;
                return;
            }
            int val2 = right.val;
            if(val<val2){
                TreeNode n=new TreeNode(val);
                root.right=n;
                n.right=right;
                return;
            }
            else if(val>val2) recursionImmediately(val,root.right);
        }else if(val<val1){
            TreeNode left = root.left;
            if(left==null){
                TreeNode n = new TreeNode(val);
                root.left=n;
                return;
            }
            int val2 = left.val;
            if(val>val2){
                TreeNode n = new TreeNode(val);
                root.left=n;
                n.left=left;
                return;
            }
            else if(val<val2) recursionImmediately(val,root.left);
        }
    }

    // 先不插入 知道搜寻到空姐点为止
    public void insertNextTime(int val, TreeNode root) {
        TreeNode n=new TreeNode(val);
        while (root != null) {
            int val1 = root.val;
            if (val > val1) {
                TreeNode rightNode = root.right;
                if (rightNode == null) {
                    root.right = n;
                    return;
                }
                root=root.right;
            }
            else if(val<val1){
                TreeNode leftNode=root.left;
                if(leftNode==null){
                    root.left=n;
                    return;
                }
                root=root.left;
            }
        }
    }

    public void insertNextTimeByRecursion(int val,TreeNode root){
        recursionNextTime(val,root);
    }
    public void recursionNextTime(int val,TreeNode root){
        int val1 = root.val;
        if(val>val1){
            TreeNode right = root.right;
            if(right==null){
                TreeNode n=new TreeNode(val);
                root.right=n;
            }else recursionNextTime(val,root.right);
        }
        else if(val<val1){
            TreeNode left= root.left;
            if(left==null){
                TreeNode n = new TreeNode(val);
                root.left=n;
            }else recursionNextTime(val,root.left);
        }
    }

    // 递归删除
    public boolean delete(int val,TreeNode root){
        deleteByRecursion(val, root);
        return true;
    }

    public boolean deleteByRecursion(int val, TreeNode root) {
        if(root==null) return false;
        int val1 = root.val;
        TreeNode right = root.right;
        TreeNode left = root.left;
        TreeNode parent = root.parent;
        if (val == val1) {
            // 所有子节点的父节点都得改变 ！！！！
            if (right == null && left == null) {
                if (parent.left == root) parent.left = null;
                if (parent.right == root) parent.right = null;
            } else if (right == null && left != null) {
                if (parent.left == root) {
                    parent.left = left;
                    left.parent=parent;
                }
                if (parent.right == root){
                    parent.right = left;
                    left.parent=parent;
                }
            } else if (right != null && left == null) {
                if (parent.left == root){
                    parent.left = right;
                    right.parent=parent;
                }
                if (parent.right == root) {
                    parent.right = right;
                    right.parent=parent;
                }
            } else {
                // firstMin 是一个没有左子节点的节点  但是不一定没有右节点 所以还得递归 delete
                TreeNode firstMin = findFirstMin(root.right);
                deleteByRecursion(firstMin.val,firstMin);
                if(parent.left==root){
                    parent.left=firstMin;
                    firstMin.parent=parent;
                }
                if(parent.right==root){
                    parent.right=firstMin;
                    firstMin.parent=parent;
                }
            }
        } else if (val > val1) {
            return deleteByRecursion(val, root.right);
        } else {
            return deleteByRecursion(val, root.left);
        }
        return true;
    }

    public TreeNode findFirstMin(TreeNode root){
        if(root.left==null) return root;
        return findFirstMin(root.left);
    }
}
